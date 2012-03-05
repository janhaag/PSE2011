package test;

import ast.Program;
import org.antlr.runtime.RecognitionException;
import verifier.smtlib.SMTLibTranslator;
import parser.ParserInterface;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 */
public class SMTLibTranslatorTest {
    private SMTLibTranslator translator;
    private ParserInterface parserInterface;
    private Program p;
    private String expected;
    private static final String LOGIC = "(set-logic AUFNIRA)";
    
    private static String embed(String s) {
        return "(push)" + s + "(check-sat)(get-model)(pop)";
    }
    
    @Before
    public void setUp() {
        translator = new SMTLibTranslator();
        parserInterface = new ParserInterface();
    }
    
    @After
    public void tearDown() {
        translator = null;
        parserInterface = null;
        p = null;
        expected = null;
    }
    
    @Test
    public void testEmptyProgram() throws RecognitionException {
        p = parserInterface.parseProgram("main(){}");
        expected = LOGIC+embed("(assert (not (and true true)))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testEmptyProgramEnsureTrue() throws RecognitionException {
        p = parserInterface.parseProgram("main(){} ensure true;");
        expected = LOGIC+embed("(assert (not (and true (and true true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testEmptyProgramEnsureFalse() throws RecognitionException {
        p = parserInterface.parseProgram("main(){} ensure false;");
        expected = LOGIC+embed("(assert (not (and true (and false true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testEmptyProgramAssumeFalse() throws RecognitionException {
        p = parserInterface.parseProgram("main()assume false;{}");
        expected = LOGIC+embed("(assert (not (=> false (and true true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testEmptyProgramAssumeTrue() throws RecognitionException {
        p = parserInterface.parseProgram("main()assume true;{}");
        expected = LOGIC+embed("(assert (not (=> true (and true true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testParamAssumeInt() throws RecognitionException {
        p = parserInterface.parseProgram("main(int i)assume i>0;{}");
        expected = LOGIC+embed("(declare-fun i$0 () Int)" +
                "(assert (not (=> (> i$0 0) (and true true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testParamAssumeBool() throws RecognitionException {
        p = parserInterface.parseProgram("main(bool i)assume i;{}");
        expected = LOGIC+embed("(declare-fun i$0 () Bool)" +
                "(assert (not (=> i$0 (and true true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testParamEnsure() throws RecognitionException {
        p = parserInterface.parseProgram("main(int i){}ensure i != 0;");
        expected = LOGIC+embed("(declare-fun i$0 () Int)" +
                "(assert (not (and true (and (distinct i$0 0) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIntDeclarationReplace() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i=4;}ensure i >= 0;");
        expected = LOGIC+embed("(assert (not (and true (and (>= 4 0) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIntZeroDeclarationReplace() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i;}ensure i <= 0;");
        expected = LOGIC+embed("(assert (not (and true (and (<= 0 0) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIntNegDeclarationReplace() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i=-4;}ensure i < 0;");
        expected = LOGIC+embed("(assert (not (and true (and (< (- 4) 0) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testBoolDeclarationReplace() throws RecognitionException {
        p = parserInterface.parseProgram("main(){bool i=true;}ensure i==false;");
        expected = LOGIC+
                embed("(assert (not (and true (and (= true false) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testBoolFalseDeclarationReplace() throws RecognitionException {
        p = parserInterface.parseProgram("main(){bool i;}ensure i;");
        expected = LOGIC+embed("(assert (not (and true (and false true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testBoolNegDeclarationReplace() throws RecognitionException {
        p = parserInterface.parseProgram("main(){bool i=!false;}ensure i | true;");
        expected = LOGIC+
                embed("(assert (not (and true (and (or (not false) true) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testAdd() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i=2+3;}ensure i == 1;");
        expected = LOGIC+embed("(assert (not " +
                     "(and true (and (= (+ 2 3) 1) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testSubtract() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i=2-3;}ensure i == 1;");
        expected = LOGIC+embed("(assert (not " +
                     "(and true (and (= (- 2 3) 1) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testMultiplication() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i=2*3;}ensure i == 1;");
        expected = LOGIC+embed("(assert (not " +
                     "(and true (and (= (* 2 3) 1) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testDivision() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i=2/3;}ensure i == 1;");
        expected = LOGIC+embed("(assert (not (and true (and (distinct 3 0) " +
                "(and (= (div 2 3) 1) true)))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testModulo() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i=2%3;}ensure i == 1;");
        expected = LOGIC+embed("(assert (not (and true (and (distinct 3 0) " +
                "(and (= (mod 2 3) 1) true)))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIntNegation() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i=-3;}ensure i == 1;");
        expected = LOGIC+embed("(assert (not " +
                     "(and true (and (= (- 3) 1) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testConjunction() throws RecognitionException {
        p = parserInterface.parseProgram("main(){bool i=true&false;}ensure i;");
        expected = LOGIC+embed("(assert (not " +
                     "(and true (and (and true false) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testDisjunction() throws RecognitionException {
        p = parserInterface.parseProgram("main(){bool i=true|false;}ensure i;");
        expected = LOGIC+embed("(assert (not " +
                     "(and true (and (or true false) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testBoolNegation() throws RecognitionException {
        p = parserInterface.parseProgram("main(){bool i=!false;}ensure i;");
        expected = LOGIC+embed("(assert (not " +
                     "(and true (and (not false) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testReplacements() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int j = 3; bool i=j<4;" +
                "bool k = !i; j=2;i=k|(j<2);}ensure k|i;");
        expected = LOGIC+embed("(assert (not (and true " +
                "(and (or (not (< 3 4)) (or (not (< 3 4)) (< 2 2))) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testReplacementsParam() throws RecognitionException {
        p = parserInterface.parseProgram("main(int j){bool i=j<4;" +
                "bool k = !i; j=2;i=k|(j<2);}ensure k|i;");
        expected = LOGIC+embed("(declare-fun j$0 () Int)(assert (not (and true " +
                "(and (or (not (< j$0 4)) (or (not (< j$0 4)) (< 2 2))) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testDoubleAssignment() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int j = 3; j=4;}ensure j==4;");
        expected = LOGIC+embed("(assert (not (and true (and (= 4 4) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testAssignmentSelfRead() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int j = 3; j=2*j;}ensure j==6;");
        expected = LOGIC+embed("(assert (not (and true (and (= (* 2 3) 6) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testSingleForAll() throws RecognitionException {
        p = parserInterface.parseProgram("main(){}ensure forall x() x==x;");
        expected = LOGIC+embed("(declare-fun x$1 () Int)(assert (not " +
                "(and true (and (forall ((x$1 Int)) (= x$1 x$1)) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testSingleExists() throws RecognitionException {
        p = parserInterface.parseProgram("main(){}ensure exists x() x==x;");
        expected = LOGIC+embed("(declare-fun x$1 () Int)(assert (not " +
                "(and true (and (exists ((x$1 Int)) (= x$1 x$1)) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testForAllReplacement() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int y=1;}ensure forall x() x==x/y;");
        expected = LOGIC+embed("(declare-fun x$1 () Int)(assert (not " +
                "(and true (and (forall ((x$1 Int)) (and (distinct 1 0) " +
                "(= x$1 (div x$1 1)))) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testForAllAssert() throws RecognitionException {
        p = parserInterface.parseProgram("main(int y){assert forall x() x==x/y;}");
        expected = LOGIC+embed("(declare-fun x$1 () Int)(declare-fun y$0 () Int)" +
                "(assert (not (and true (and (forall ((x$1 Int)) " +
                "(and (distinct y$0 0) (= x$1 (div x$1 y$0)))) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testForAllExists() throws RecognitionException {
        p = parserInterface.parseProgram("main(){}ensure forall x() exists y() x==y;");
        expected = LOGIC+embed("(declare-fun y$2 () Int)(declare-fun x$1 () Int)" +
                "(assert (not (and true (and (forall ((x$1 Int)) " +
                "(exists ((y$2 Int)) (= x$1 y$2))) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testEmptyIf() throws RecognitionException {
        p = parserInterface.parseProgram("main(){if(true){}}");
        expected = LOGIC+embed("(assert (not (and true " +
                "(or (and true true) (and (not true) true)))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIfReplace() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int y;if(true){y=1;}}ensure y<2;");
        expected = LOGIC+embed("(assert (not (and true (or (and true " +
                "(and (< 1 2) true)) (and (not true) (and (< 0 2) true))))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIfElseReplace() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int y;" +
                "if(true){y=1;}else{y=3;}}ensure y<2;");
        expected = LOGIC+embed("(assert (not (and true (or (and true " +
                "(and (< 1 2) true)) (and (not true) (and (< 3 2) true))))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIfAssert() throws RecognitionException {
        p = parserInterface.parseProgram("main(){if(false){assert false;}" +
                "else{assert true;}}");
        expected = LOGIC+embed("(assert (not (and true (or " +
                "(and false (and false true)) (and (not false) (and true true))))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIfParam() throws RecognitionException {
        p = parserInterface.parseProgram("main(int i){" +
                "if(i<0){i=-i;}else{}}ensure i>=0;");
        expected = LOGIC+embed("(declare-fun i$0 () Int)(assert (not (and true " +
                "(or (and (< i$0 0) (and (>= (- i$0) 0) true)) (and " +
                "(not (< i$0 0)) (and (>= i$0 0) true))))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testTwoIfsFollowing() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int y;if(true){}else{y=-y;}" +
                "if(y<0){}else{y=y+1;}}ensure y<0;");
        expected = LOGIC+embed("(assert (not (and true (or (and true (or " +
                "(and (< 0 0) (and (< 0 0) true)) (and (not (< 0 0)) (and " +
                "(< (+ 0 1) 0) true)))) (and (not true) (or (and (< (- 0) 0) " +
                "(and (< (- 0) 0) true)) (and (not (< (- 0) 0)) " +
                "(and (< (+ (- 0) 1) 0) true))))))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIfScoping() throws RecognitionException {
        p = parserInterface.parseProgram("main(int i){" +
                "if(i<0){i=-i;int i;i=2;}}ensure i>=0;");
        expected = LOGIC+embed("(declare-fun i$0 () Int)(assert (not (and true " +
                "(or (and (< i$0 0) (and (>= (- i$0) 0) true)) (and " +
                "(not (< i$0 0)) (and (>= i$0 0) true))))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIfScopingIntBool() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int i;" +
                "if(i<0){i=-i;bool i;i=true;}}ensure i>=0;");
        expected = LOGIC+embed("(assert (not (and true " +
                "(or (and (< 0 0) (and (>= (- 0) 0) true)) (and " +
                "(not (< 0 0)) (and (>= 0 0) true))))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIfScopingQuantifier() throws RecognitionException {
        p = parserInterface.parseProgram("main(int i){int y=i;}" +
                "ensure forall i() i>=y;");
        expected = LOGIC+embed("(declare-fun i$0 () Int)(declare-fun i$1 () Int)" +
                "(assert (not (and true " +
                "(and (forall ((i$1 Int)) (>= i$1 i$0)) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testIfInIf() throws RecognitionException {
        p = parserInterface.parseProgram("main(int i){if(i<0)" +
                "{if(i>0){i=-i;}else{i=1;}}else{}}ensure i>=0;");
        expected = LOGIC+embed("(declare-fun i$0 () Int)(assert (not (and true " +
                "(or (and (< i$0 0) (or (and (> i$0 0) (and (>= (- i$0) 0) true)) " +
                "(and (not (> i$0 0)) (and (>= 1 0) true)))) (and " +
                "(not (< i$0 0)) (and (>= i$0 0) true))))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testSimpleWhile() throws RecognitionException {
        p = parserInterface.parseProgram("main(){while(true){}}");
        expected = LOGIC+embed("(assert (not true))")
                    +embed("(assert (not (=> (not true) true)))")
                    +embed("(assert (not (=> true true)))")
                    +embed("(assert (not (and true true)))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileEnsure() throws RecognitionException {
        p = parserInterface.parseProgram("main(){while(true){}ensure false;}");
        expected = LOGIC+embed("(assert (not (=> false true)))")
                    +embed("(assert (not (=> (not true) (and false true))))")
                    +embed("(assert (not (=> true true)))")
                    +embed("(assert (not (and true true)))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileInvariant() throws RecognitionException {
        p = parserInterface.parseProgram("main(){while(true)invariant false;{}}");
        expected = LOGIC+embed("(assert (not true))")
                    +embed("(assert (not (=> (not true) (=> false true))))")
                    +embed("(assert (not (=> true (=> false (and false true)))))")
                    +embed("(assert (not (and true (and false true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileInvariantEnsure() throws RecognitionException {
        p = parserInterface.parseProgram("main(){while(true)" +
                "invariant false;{}ensure true;}");
        expected = LOGIC+embed("(assert (not (=> true true)))")
                    +embed("(assert (not " +
                        "(=> (not true) (=> false (and true true)))))")
                    +embed("(assert (not (=> true (=> false (and false true)))))")
                    +embed("(assert (not (and true (and false true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileVar() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int y;while(true){}}ensure y==1;");
        expected = LOGIC+embed("(declare-fun y$0 () Int)" +
                        "(assert (not (and (= y$0 1) true)))")
                    +embed("(assert (not (=> (not true) true)))")
                    +embed("(assert (not (=> true true)))")
                    +embed("(assert (not (and true true)))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileVarInvariant() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int y;while(true)" +
                "invariant y>0;{}}ensure y==1;");
        expected = LOGIC+embed("(declare-fun y$0 () Int)" +
                        "(assert (not (and (= y$0 1) true)))")
            +embed("(declare-fun y$0 () Int)(assert (not " +
                "(=> (not true) (=> (> y$0 0) true))))")
            +embed("(declare-fun y$0 () Int)(assert (not (=> true " +
                "(=> (> y$0 0) (and (> y$0 0) true)))))")
            +embed("(assert (not (and true (and (> 0 0) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileVarEnsure() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int y;while(true){}ensure y==1;}" +
                "ensure y==1;");
        expected = LOGIC+embed("(declare-fun y$0 () Int)" +
                        "(assert (not (=> (= y$0 1) (and (= y$0 1) true))))")
                    +embed("(declare-fun y$0 () Int)(assert (not " +
                        "(=> (not true) (and (= y$0 1) true))))")
                    +embed("(assert (not (=> true true)))")
                    +embed("(assert (not (and true true)))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileVarEnsureInvar() throws RecognitionException {
        p = parserInterface.parseProgram("main(){int y;while(true)invariant y>0;" +
                "{}ensure y==1;}ensure y==1;");
        expected = LOGIC
            +embed("(declare-fun y$0 () Int)" +
                        "(assert (not (=> (= y$0 1) (and (= y$0 1) true))))")
            +embed("(declare-fun y$0 () Int)(assert (not (=> (not true) " +
                        "(=> (> y$0 0) (and (= y$0 1) true)))))")
            +embed("(declare-fun y$0 () Int)(assert (not " +
                "(=> true (=> (> y$0 0) (and (> y$0 0) true)))))")
            +embed("(assert (not (and true (and (> 0 0) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileInvarReplace() throws RecognitionException {
        p = parserInterface.parseProgram("main()" +
                "{int y;while(y<0)invariant y>0;{y=y+1;}}");
        expected = LOGIC
            +embed("(assert (not true))")
            +embed("(declare-fun y$0 () Int)(assert (not " +
                "(=> (not (< y$0 0)) (=> (> y$0 0) true))))")
            +embed("(declare-fun y$0 () Int)(assert (not (=> (< y$0 0) " +
                "(=> (> y$0 0) (and (> (+ y$0 1) 0) true)))))")
            +embed("(assert (not (and true (and (> 0 0) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileInvarParam() throws RecognitionException {
        p = parserInterface.parseProgram("main(int y)" +
                "{while(y<0)invariant y>0;{y=y+1;}}");
        expected = LOGIC
            +embed("(assert (not true))")
            +embed("(declare-fun y$0 () Int)(assert (not " +
                "(=> (not (< y$0 0)) (=> (> y$0 0) true))))")
            +embed("(declare-fun y$0 () Int)(assert (not (=> (< y$0 0) " +
                "(=> (> y$0 0) (and (> (+ y$0 1) 0) true)))))")
            +embed("(declare-fun y$0 () Int)(assert (not " +
                "(and true (and (> y$0 0) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileScoping() throws RecognitionException {
        p = parserInterface.parseProgram("main(){bool y;while(true)invariant y;" +
                "{y=!y;int y;y=1;}ensure !y;}");
        expected = LOGIC
            +embed("(declare-fun y$0 () Bool)(assert (not (=> (not y$0) true)))")
            +embed("(declare-fun y$0 () Bool)(assert (not " +
                "(=> (not true) (=> y$0 (and (not y$0) true)))))")
            +embed("(declare-fun y$0 () Bool)(assert (not (=> true " +
                "(=> y$0 (and (not y$0) true)))))")
            +embed("(assert (not (and true (and false true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testTwoWhilesFollowing() throws RecognitionException {
        p = parserInterface.parseProgram("main(){bool y;while(y)invariant y;" +
                "{y=!y;}while(!y){y=false;}ensure false;}ensure y;");
        expected = LOGIC
            +embed("(declare-fun y$0 () Bool)(assert (not (=> false (and y$0 true))))")
            +embed("(declare-fun y$0 () Bool)(assert (not " +
                "(=> (not (not y$0)) (and false true))))")
            +embed("(declare-fun y$0 () Bool)(assert (not (=> (not y$0) true)))")
            +embed("(assert (not true))")
            +embed("(declare-fun y$0 () Bool)(assert (not " +
                "(=> (not y$0) (=> y$0 true))))")
            +embed("(declare-fun y$0 () Bool)(assert (not (=> y$0 " +
                "(=> y$0 (and (not y$0) true)))))")
            +embed("(assert (not (and true (and false true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testWhileInWhile() throws RecognitionException {
        p = parserInterface.parseProgram("main(){bool y;while(y)" +
                "{while(!y){y=false;}}ensure false;}ensure y;");
        expected = LOGIC
            +embed("(declare-fun y$0 () Bool)(assert (not (=> false (and y$0 true))))")
            +embed("(declare-fun y$0 () Bool)(assert (not " +
                "(=> (not y$0) (and false true))))")
            +embed("(assert (not true))")
            +embed("(declare-fun y$0 () Bool)(assert (not (=> (not (not y$0)) true)))")
            +embed("(declare-fun y$0 () Bool)(assert (not (=> (not y$0) true)))")
            +embed("(declare-fun y$0 () Bool)(assert (not (=> y$0 true)))")
            +embed("(assert (not (and true true)))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }
}

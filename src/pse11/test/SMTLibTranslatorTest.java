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
    public void testParamAssume() throws RecognitionException {
        p = parserInterface.parseProgram("main(int i)assume i>0;{}");
        expected = LOGIC+embed("(declare-fun i () Int)" +
                "(assert (not (=> (> i 0) (and true true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testParamEnsure() throws RecognitionException {
        p = parserInterface.parseProgram("main(int i){}ensure i != 0;");
        expected = LOGIC+embed("(declare-fun i () Int)" +
                "(assert (not (and true (and (distinct i 0) true))))");
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
        expected = LOGIC+embed("(declare-fun j () Int)(assert (not (and true " +
                "(and (or (not (< j 4)) (or (not (< j 4)) (< 2 2))) true))))");
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
        expected = LOGIC+embed("(declare-fun x () Int)(assert (not " +
                "(and true (and (forall ((x Int)) (= x x)) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testSingleExists() throws RecognitionException {
        p = parserInterface.parseProgram("main(){}ensure exists x() x==x;");
        expected = LOGIC+embed("(declare-fun x () Int)(assert (not " +
                "(and true (and (exists ((x Int)) (= x x)) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }

    @Test
    public void testSingleFossrAll() throws RecognitionException {
        p = parserInterface.parseProgram("main(int y){y=1;}ensure forall x() (x*x+1)/(x*x+1)==y;");
        expected = LOGIC+embed("(assert (not (and true (and (= (* 2 3) 6) true))))");
        assertEquals(expected, translator.getWPTree(p).toString());
    }
}

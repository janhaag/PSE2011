package test.ast;

import ast.*;
import org.antlr.runtime.RecognitionException;
import parser.ParserInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 */
public class ASTClassesTest {
    private ParserInterface parserInterface;

    @Before
    public void setUp() {
        parserInterface = new ParserInterface();
    }

    @After
    public void tearDown() {
        parserInterface = null;
    }

    @Test
    public void testToStringSimple() throws RecognitionException {
        Program p = parserInterface.parseProgram("main(){}");
        assertEquals("main() {\nassert true;\n}", p.toString());
    }

    @Test
    public void testToStringComplex() throws RecognitionException {
        Program p = parserInterface.parseProgram("axiom forall x() true;" +
                "axiom exists y() false;" +
                "int f(bool i, int[][] f){return 0;}" +
                "main(int i)assume true;{}ensure true;");
        assertEquals("axiom (forall x() true);\n" +
                "axiom (exists y() false);\n" +
                "int f(bool i, int[][] f) {\nreturn 0;\n}\n\n" +
                "main(int i) {\nassume true;\nassert true;\nensure true;\n}", p.toString());
    }

    @Test
    public void testToStringWhileSimple() throws RecognitionException {
        Program p = parserInterface.parseProgram("main(){while(true){}}");
        assertEquals("main() {\nassert true;\nwhile (true)\n{\n}\n}", p.toString());
    }

    @Test
    public void testToStringWhileComplex() throws RecognitionException {
        Program p = parserInterface.parseProgram("main(){while(true)invariant true;{}ensure 1==1;}");
        assertEquals("main() {\nassert true;\nwhile (true)\ninvariant true;\n{\n}" +
                "\nensure (1 == 1);\n}", p.toString());
    }

    @Test
    public void testToStringIfSimple() throws RecognitionException {
        Program p = parserInterface.parseProgram("main(){if(true){}}");
        assertEquals("main() {\nassert true;\nif (true) {\n}\n}", p.toString());
    }

    @Test
    public void testToStringIfComplex() throws RecognitionException {
        Program p = parserInterface.parseProgram("main(){if(true){}else{}}");
        assertEquals("main() {\nassert true;\n" +
                "if (true) {\n} else {\n}\n}", p.toString());
    }

    @Test
    public void testToStringQuantifier() throws RecognitionException {
        Program p = parserInterface.parseProgram("main(){assert forall x(1,1) true;" +
                "assert exists x(1,1) true;}");
        assertEquals("main() {\nassert true;\nassert (forall x(1, 1) true);\n" +
                "assert (exists x(1, 1) true);\n}", p.toString());
    }

    @Test
    public void testToStringVars() throws RecognitionException {
        Program p = parserInterface.parseProgram("main(){bool[] a = array[2];" +
                "a[1] = !true; int i; int j = -1; i = 0;}");
        assertEquals("main() {\nassert true;\nassert (2 > 0);\nbool[] a[2];\n" +
                "assert ((1 >= 0) & (1 < (length(a))));\na[1] = (! true);\n" +
                "int i;\nint j = (- 1);\ni = 0;\n}", p.toString());
    }

    @Test
    public void testToStringFuncCalls() throws RecognitionException {
        Program p = parserInterface.parseProgram("int f(int i){return 1;}" +
                "int h(int i, int j){return 0;}int k(){return 0;}" +
                "main(){int one = f(0)+h(0,0)+k();}");
        assertEquals("int f(int i) {\nreturn 1;\n}\n\n" +
                "int h(int i, int j) {\nreturn 0;\n}\n\n" +
                "int k() {\nreturn 0;\n}\n\n" +
                "main() {\nassert true;\n" +
                "int one = (((f(0)) + (h(0, 0))) + (k()));\n}", p.toString());
    }

    @Test
    public void testArrayTypeEquals() {
        ArrayType type = new ArrayType(new IntegerType());
        assertEquals(type, type);
        assertFalse(type.equals(null));
        assertFalse(type.equals(new IntegerType()));
    }

    @Test
    public void testIdentifierEquals() {
        Identifier identifier = new Identifier("a");
        assertEquals(identifier, identifier);
        assertFalse(identifier.equals(null));
        assertFalse(identifier.equals(new IntegerType()));
    }

    @Test
    public void testPosition() {
        assertSame(0, (new Position()).getLine());
        assertSame(0, (new Position()).getColumn());
        assertSame(1, (new Position(1, 2)).getLine());
        assertSame(2, (new Position(1, 2)).getColumn());
    }
}

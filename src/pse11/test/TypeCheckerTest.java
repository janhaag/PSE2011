package test;

import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parser.IllegalTypeException;
import parser.ParserInterface;

import static org.junit.Assert.*;

/**
 *
 */
public class TypeCheckerTest {
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
    public void testCorrectProgram() {
        boolean success = true;
        try {
            parserInterface.parseProgram("int m(int a, bool c, int[][] d)" +
                    "{int b; a = 4*b%4+2+d[d[1][2]][a];" +
                    "c = (3<length(d))|(4== length(d[3])); return 2;}" +
                    "ensure forall x(a,b) x != 2;" +
                    "main() assume true;{" +
                    "if (true) {bool c; while (c) {}}" +
                    "int[][][] s = array[2][1][2];" +
                    "int w = m(2,true,s[0]);" +
                    "} ensure length(s)!=1;");
        } catch (RecognitionException e) {
            success = false;
        }
        assertTrue(success);
    }

    @Test (expected = IllegalTypeException.class)
    public void testConditionNotBoolean() throws RecognitionException {
        parserInterface.parseProgram("main() {int c; while (c){}}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testAssertConditionNotBoolean() throws RecognitionException {
        parserInterface.parseProgram("main() {assert 1;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testBooleanOnIntegerOperator() throws RecognitionException {
        parserInterface.parseProgram("main() {int i = 1*true;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testIntegerOnBooleanOperator() throws RecognitionException {
        parserInterface.parseProgram("main() {int i = 1|true;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testAssignBooleanToInteger() throws RecognitionException {
        parserInterface.parseProgram("main() {int i = true;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testAssignIntegerToBoolean() throws RecognitionException {
        parserInterface.parseProgram("main() {bool i = 42;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testAssignIntegerToBooleanqe() throws RecognitionException {
        parserInterface.parseProgram("main() {bool i = 42&;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testEqualsDifferentTypes() throws RecognitionException {
        parserInterface.parseProgram("main() {int[][] c = array[3][2];" +
                "int[] d = array[2]; bool i = c==d;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testArrayNotCorrectlyDeclared1() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[] i;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testArrayNotCorrectlyDeclared2() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[] i = array[true];}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testArrayNotCorrectlyDeclared3() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[] i = array[2][3];}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testArrayNotCorrectlyDeclared4() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[][] i = array[2];}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testVariableDeclaredAsArray1() throws RecognitionException {
        parserInterface.parseProgram("main() {bool i = array[6];}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testVariableDeclaredAsArray2() throws RecognitionException {
        parserInterface.parseProgram("main() {bool i = array;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testIllegalNumberOfParameters() throws RecognitionException {
        parserInterface.parseProgram("bool f(){return true;}" +
                                    "main() {bool i = f(true);}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testVariableAlreadyDeclared() throws RecognitionException {
        parserInterface.parseProgram("main() {bool i; bool i;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testArrayAlreadyDeclared() throws RecognitionException {
        parserInterface.parseProgram("main() {bool i; bool[] i = array[7];}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testLengthNoArray() throws RecognitionException {
        parserInterface.parseProgram("main() {bool i; int g = length(i);}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testLengthWrongParameterNumber() throws RecognitionException {
        parserInterface.parseProgram("main() {bool i; int g = length(i, i);}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testWrongArrayIndexType1() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[] i = array[true];}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testWrongArrayIndexType2() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[] i = array[7];" +
                                     "i[true] = true;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testWrongArrayIndexType3() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[] i = array[7];" +
                                     "bool j = i[i];}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testWrongArrayIndexNumber1() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[] i = array[7];" +
                                     "assert i[5][6];}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testWrongArrayIndexNumber2() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[] i = array[7];" +
                                     "i[5][6] = true;}");
    }

    @Test (expected = IllegalTypeException.class)
    public void testWrongArrayIndexNumber3() throws RecognitionException {
        parserInterface.parseProgram("main() {bool[] i = array[5];" +
                                     "i = true;}");
    }
}

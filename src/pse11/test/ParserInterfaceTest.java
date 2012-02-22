package test;

import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parser.ParserInterface;

import static org.junit.Assert.*;

/**
 *
 */
public class ParserInterfaceTest {
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
    public void testParseEmptyProgram() {
        boolean success = true;
        try {
            parserInterface.parseProgram("main(){}");
        } catch (RecognitionException e) {
            success = false;
        }
        assertTrue(success);
    }

    @Test
    public void testParseInvalidProgram1() throws RecognitionException {
        parserInterface.parseProgram("main(){int a = 3+4(*5+2);}");
        assertNotSame(0, parserInterface.getErrors().length);
    }

    @Test
    public void testParseInvalidProgram2() throws RecognitionException {
        parserInterface.parseProgram("main(){int d}");
        assertNotSame(0, parserInterface.getErrors().length);
    }

    @Test
    public void testParseInvalidProgram3() throws RecognitionException {
        parserInterface.parseProgram("int assert(){} main(){}");
        assertNotSame(0, parserInterface.getErrors().length);
    }

    @Test
    public void testParseExpression() {
        boolean success = true;
        try {
            parserInterface.parseExpression("i == f&(a%2 == 2)");
        } catch (RecognitionException e) {
            success = false;
        }
        assertTrue(success);
    }
}

package test.misc;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import interpreter.GlobalBreakpoint;
import interpreter.StatementBreakpoint;

import java.util.ArrayList;

import misc.ExecutionHandler;
import misc.MessageSystem;

import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parser.FunctionCallNotAllowedException;
import parser.IllegalTypeException;
import ast.Assumption;
import ast.Ensure;
import ast.Function;
import ast.FunctionParameter;
import ast.IntegerType;
import ast.Position;
import ast.Program;
import ast.StatementBlock;
import ast.VariableDeclaration;

public class ExecutionHandlerUnitTest {
	private ExecutionHandler executionHandler;

    @Before
    public void setUp() {
        executionHandler = new ExecutionHandler(new MessageSystem());
    }

    @After
    public void tearDown() {
        executionHandler = null;
    }

    @Test
    public void getASTTest() {
    	assertNull(this.executionHandler.getAST());
    }
    
    @Test
    public void setASTTest() {
    	Program ast = new Program(new Position(1, 0), null, null, null);
    	this.executionHandler.setAST(ast);
    	assertEquals(ast, this.executionHandler.getAST());
    }
    
    @Test
    public void getParserInterfaceTest() {
    	assertNotNull(this.executionHandler.getParserInterface());
    }
    
    @Test
    public void getGlobalBreakpointTest() {
    	ArrayList<GlobalBreakpoint> list = new ArrayList<GlobalBreakpoint>();
    	assertEquals(list, this.executionHandler.getGlobalBreakpoints());
    }
    
    @Test
    public void getMessageSystemTest() {
    	assertNotNull(this.executionHandler.getMessageSystem());
    }
    
    @Test
    public void setAndGetPausedTest() {
    	this.executionHandler.setPaused(true);
    	assertTrue(this.executionHandler.getPaused());
    }
    
    @Test
    public void setAndGetParameterValuesTest() {
    	String[] values = {"42", "0", "true"};
    	this.executionHandler.setParameterValues(values);
    	assertEquals(values[0], this.executionHandler.getParameterValues()[0]);
    	assertEquals(values[1], this.executionHandler.getParameterValues()[1]);
    	assertEquals(values[2], this.executionHandler.getParameterValues()[2]);
    }
    
    @Test
    public void addAndGetAndClearAssertionFailureTest() {
    	assertNull(this.executionHandler.getAssertionFailureMessage());
    	this.executionHandler.addAssertionFailureMessage("0", "Error");
    	assertNotNull(this.executionHandler.getAssertionFailureMessage());
    	this.executionHandler.clearAssertionFailureMessage();
    	assertNull(this.executionHandler.getAssertionFailureMessage());
    }
    
    @Test
    public void getAndDestroyProgramExecutionTest() {
    	this.executionHandler.destroyProgramExecution();
    	assertNull(this.executionHandler.getProgramExecution());
    }
  
    @Test
    public void addSuccessMessageTest() {
    	this.executionHandler.addSuccessMessage("Hallo Welt");
    	assertEquals("Hallo Welt", this.executionHandler.getMessageSystem().getMessages().get(0).getText());
    }
    
    @Test
    public void printAssertionFailureMessageTest() {
    	this.executionHandler.addAssertionFailureMessage("0", "Error");
    	this.executionHandler.printAssertionFailureMessage();
    	assertEquals("Error", this.executionHandler.getMessageSystem().getMessages().get(0).getText());
    }
    
    @Test
    public void printAssertionFailureMessageTest2() {
    	this.executionHandler.addAssertionFailureMessage("position", "Wieder Error");
    	this.executionHandler.printAssertionFailureMessage();
    	assertEquals("Wieder Error", this.executionHandler.getMessageSystem().getMessages().get(0).getText());
    }
    
    @Test
    public void parseTest() throws RecognitionException {
    	/* correct syntax */
    	this.executionHandler.parse("main() {}");
    	assertNotNull(this.executionHandler.getAST()); 	
    	
    	/* incorrect syntax */
    	this.executionHandler.setAST(null);
    	this.executionHandler.parse("main() {int i = §!§$}");
    	assertNull(this.executionHandler.getAST()); 
    	
    	/* wrong types */
    	try {
    		this.executionHandler.parse("main() {int i = true;}");
    	}
    	catch (IllegalTypeException expected) {
    	}
    	
    	/* wrong function calls */
       	try {
    		this.executionHandler.parse("int g(int x){return 0;}" +
                    "main() {} ensure g(1);");
    	}
    	catch (FunctionCallNotAllowedException expected) {
    	}
    }
    
    @Test
    public void singleStepTest() {
    	/* no ast */
    	this.executionHandler.singleStep(null, null);
    	assertNull(this.executionHandler.getProgramExecution());
    }
    
    @Test
    public void singleStepTest2() {
    	/* ast without statement */
    	assertNull(this.executionHandler.getAST());
    	Position pos = new Position(1, 0);
    	Program ast = new Program(pos, new Function[0], new Function(
                pos, null, "main", new FunctionParameter[0], 
                new StatementBlock(new VariableDeclaration[0], pos), new Assumption[0],
                new Ensure[0]), null);
    	this.executionHandler.setAST(ast);
    	this.executionHandler.singleStep(null, null);
    	assertNotNull(this.executionHandler.getProgramExecution());  	
    }
    
    @Test
    public void singleStepTest3() {
    	/* with breakpoints */
    	assertNull(this.executionHandler.getAST());
    	Position pos = new Position(1, 0);
    	Program ast = new Program(pos, new Function[0], new Function(
                pos, null, "main", new FunctionParameter[0], 
                new StatementBlock(new VariableDeclaration[0], pos), new Assumption[0],
                new Ensure[0]), null);
    	this.executionHandler.setAST(ast);
    	this.executionHandler.singleStep(new ArrayList<StatementBreakpoint>(), new ArrayList<GlobalBreakpoint>());
    	assertNotNull(this.executionHandler.getProgramExecution()); 
    }
    
    @Test
    public void singleStepTest4() {
    	/* ast with one statement */
    	assertNull(this.executionHandler.getAST());
    	Position pos = new Position(1, 0);
    	VariableDeclaration[] dec = {new VariableDeclaration(pos, "x", null, new IntegerType())};
    	StatementBlock block = new StatementBlock(dec, pos);
    	Program ast = new Program(pos, new Function[0], new Function(
                pos, null, "main", new FunctionParameter[0], block, new Assumption[0],
                new Ensure[0]), null);
    	this.executionHandler.setAST(ast);
    	this.executionHandler.singleStep(null, null);
    	assertNotNull(this.executionHandler.getProgramExecution()); 	
    	this.executionHandler.singleStep(null, null);
    	assertNotNull(this.executionHandler.getProgramExecution()); 	
    }
    
    /*@Test
    public void singleStepTest5() {
    	assertNull(this.executionHandler.getAST());
    	Position pos = new Position(1, 0);
    	NumericLiteral num = new NumericLiteral(pos, "0");
		ArithmeticExpression exp = new ArithmeticExpression(pos, num, num, new Division());
		VariableDeclaration[] dec = {new VariableDeclaration(pos, "x", exp, new IntegerType())};
		StatementBlock block = new StatementBlock(dec, pos);
    	Program ast = new Program(pos, new Function[0], new Function(
                pos, null, "main", new FunctionParameter[0], block, new Assumption[0],
                new Ensure[0]), null);
    	this.executionHandler.setAST(ast);
    	this.executionHandler.singleStep(null, null);
    	assertNotNull(this.executionHandler.getAssertionFailureMessage());
    	assertNull(this.executionHandler.getProgramExecution()); 	
    }*/
    
    @Test
    public void runTest() {
    	/* no ast */
    	this.executionHandler.run(null, null);
    	assertNull(this.executionHandler.getProgramExecution());
    }
    
    @Test
    public void runTest2() {
    	/* ast with one statement without pause */
    	assertNull(this.executionHandler.getAST());
    	Position pos = new Position(1, 0);
    	VariableDeclaration[] dec = {new VariableDeclaration(pos, "x", null, new IntegerType())};
    	StatementBlock block = new StatementBlock(dec, pos);
    	Program ast = new Program(pos, new Function[0], new Function(
                pos, null, "main", new FunctionParameter[0], block, new Assumption[0],
                new Ensure[0]), null);
    	this.executionHandler.setAST(ast);
    	this.executionHandler.run(null, null);
    	assertNotNull(this.executionHandler.getProgramExecution()); 	
    }
    
    @Test
    public void verifyTest() {
    	this.executionHandler.verify("");
    	assertEquals(1, this.executionHandler.getMessageSystem().getMessages().size());
    	assertEquals("mismatched input '<EOF>' expecting 'main'", 
    			this.executionHandler.getMessageSystem().getMessages().get(0).getText());
    }
    
    @Test
    public void verifyTest2() {
    	this.executionHandler.verify("main() {}");
    	assertEquals(1, this.executionHandler.getMessageSystem().getMessages().size());
    	assertEquals("true; ", this.executionHandler.getMessageSystem().getMessages().get(0).getText());
    }
    

}

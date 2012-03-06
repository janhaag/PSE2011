package test.interpreter;


import static org.junit.Assert.*;

import interpreter.ArrayValue;
import interpreter.BooleanValue;
import interpreter.GlobalBreakpoint;
import interpreter.IntegerValue;
import interpreter.Interpreter;
import interpreter.ProgramExecution;
import interpreter.StatementBreakpoint;
import interpreter.Value;

import java.util.ArrayList;
import java.util.HashMap;

import misc.ExecutionHandler;

import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.ArrayType;
import ast.Expression;
import ast.Identifier;
import ast.IntegerType;
import ast.Program;

public class ProgramExecutionTest {
	private ProgramExecution execution;

	@Before
	public void setUp() throws RecognitionException {
		ExecutionHandler executionHandler = new ExecutionHandler(null);
		Program ast = executionHandler.getParserInterface().parseProgram("main(int a, bool b, int[] c) {}");
		Interpreter interpreter = new Interpreter();
		String[] parameter = {"5", "false", "{2,3,4}"};
		ArrayList<StatementBreakpoint> statement = new ArrayList<StatementBreakpoint>();
		ArrayList<GlobalBreakpoint> global = new ArrayList<GlobalBreakpoint>();
		this.execution = new ProgramExecution(ast, interpreter, statement, global, null);
		this.execution = new ProgramExecution(ast, interpreter, statement, global, parameter);
	}
	
	@Test
	public void getCurrentStateTest() {
		assertNotNull(this.execution.getCurrentState());
	}
	
	@Test
	public void getStatementBreakpointTest() {
		ArrayList<StatementBreakpoint> list = new ArrayList<StatementBreakpoint>();
		assertEquals(list, this.execution.getStatementBreakpoints());
	}
	
	@Test
	public void getGlobalBreakpointTest() {
		ArrayList<GlobalBreakpoint> list = new ArrayList<GlobalBreakpoint>();
		assertEquals(list, this.execution.getGlobalBreakpoints());
	}
	
	@Test
	public void setStatementBreakpointTest() {
		ArrayList<StatementBreakpoint> list = new ArrayList<StatementBreakpoint>();
		StatementBreakpoint sbreakpoint = new StatementBreakpoint(0);
		list.add(sbreakpoint);
		this.execution.setStatementBreakpoints(list);
		assertEquals(sbreakpoint, this.execution.getStatementBreakpoints().get(0));
	}
	
	@Test
	public void setGlobalBreakpointTest() {
		ArrayList<GlobalBreakpoint> list = new ArrayList<GlobalBreakpoint>();
		GlobalBreakpoint gbreakpoint = new GlobalBreakpoint(null);
		list.add(gbreakpoint);
		this.execution.setGlobalBreakpoints(list);
		assertEquals(gbreakpoint, this.execution.getGlobalBreakpoints().get(0));
	}
	
	@Test
	public void getVariablesTest() {
		HashMap<Identifier, Value> map = new HashMap<Identifier, Value>();
		map.put(new Identifier("a"), new IntegerValue("5"));
		map.put(new Identifier("b"), new BooleanValue("false"));
		int[] length = {3};
		ArrayValue value = new ArrayValue(new ArrayType(new IntegerType()), length);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		value.setValue("2", list);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		value.setValue("3", list2);
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(2);
		value.setValue("4", list3);
		map.put(new Identifier("c"), value);
		assertEquals(map, this.execution.getVariables());
	}

	@Test
	public void checkBreakpointTest() {
		this.execution.getStatementBreakpoints().add(new StatementBreakpoint(1));
		assertEquals(1, ((StatementBreakpoint) this.execution.checkBreakpoints()).getLine());
		this.execution.getStatementBreakpoints().remove(0);
		
		ExecutionHandler handler = new ExecutionHandler(null);
		Expression exp;
		try {
			exp = handler.getParserInterface().parseExpression("a == 42");
			this.execution.getGlobalBreakpoints().add(new GlobalBreakpoint(exp));
			this.execution.getCurrentState().createVar("a", "42", new IntegerType());
			assertEquals(exp, ((GlobalBreakpoint) this.execution.checkBreakpoints()).getExpression());
		} catch (RecognitionException e) {
		}	
	} 
	
	@After
	public void tearDown() {
		this.execution = null;
	}

}

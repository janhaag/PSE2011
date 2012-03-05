package test.interpreter;


import static org.junit.Assert.*;

import interpreter.GlobalBreakpoint;
import interpreter.Interpreter;
import interpreter.ProgramExecution;
import interpreter.StatementBreakpoint;

import java.util.ArrayList;

import misc.ExecutionHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.Program;

public class ProgramExecutionTest {
	private ProgramExecution execution;

	@Before
	public void setUp() throws Exception {
		ExecutionHandler executionHandler = new ExecutionHandler(null);
		Program ast = executionHandler.getParserInterface().parseProgram("main(int a, bool b, int[] c) {int i = 5;}");
		Interpreter interpreter = new Interpreter();
		String[] parameter = {"5", "false", "{2,3,4}"};
		ArrayList<StatementBreakpoint> statement = new ArrayList<StatementBreakpoint>();
		ArrayList<GlobalBreakpoint> global = new ArrayList<GlobalBreakpoint>();
		this.execution = new ProgramExecution(ast, interpreter, statement, global, parameter);
	}
	
	@Test
	public void getCurrentStateTest() {
		assertNotNull(this.execution.getCurrentState());
	}
	
	@Test
	public void getStatementBreakpointTest() {
		assertNotNull(this.execution.getStatementBreakpoints());
	}
	
	@Test
	public void getGlobalBreakpointTest() {
		assertNotNull(this.execution.getGlobalBreakpoints());
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
		assertNotNull(this.execution.getVariables());
	}

	@Test
	public void checkBreakpointTest() {
		this.execution.getStatementBreakpoints().add(new StatementBreakpoint(1));
		assertNotNull(this.execution.checkBreakpoints());
	}
	
	@After
	public void tearDown() throws Exception {
		this.execution = null;
	}

}

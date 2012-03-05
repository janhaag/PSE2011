package test.interpreter;


import static org.junit.Assert.*;

import interpreter.ArrayValue;
import interpreter.IntegerValue;
import interpreter.Scope;
import interpreter.State;
import interpreter.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;

import misc.ExecutionHandler;

import org.antlr.runtime.RecognitionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.ArrayType;
import ast.FunctionCall;
import ast.Identifier;
import ast.IntegerType;
import ast.Position;
import ast.Program;

public class StateTest {
	private State state;

	@Before
	public void setUp() throws RecognitionException {
		ExecutionHandler handler = new ExecutionHandler(null);
		Program ast = handler.getParserInterface().parseProgram("main() {}");	
		try {
			this.state = new State(null);
		}
		catch (IllegalArgumentException e) {
		}
		this.state = new State(ast);
	}
	
	@Test
	public void getCurrentScopeTest() {
		assertNotNull(this.state.getCurrentScope());
	}
	
	@Test
	public void getCurrentStatementTest() {
		assertNotNull(this.state.getCurrentStatement());
	}

	@Test
	public void adjustStatementTest() {
		this.state.adjustStatement();
		assertNull(this.state.getCurrentStatement());
	}
	
	@Test
	public void getCurrentFunctionTest() {
        assertNotNull(this.state.getCurrentFunction());
    }
	
	@Test
	public void isFunctionScopeTest() {
		assertTrue(this.state.isFunctionScope());
	}
	
	@Test
	public void getReturnValuesTest() {
		IdentityHashMap<FunctionCall, Value> map = new IdentityHashMap<FunctionCall, Value>();
		assertEquals(map, this.state.getReturnValues());
	}
	
	@Test
	public void createFunctionResultTest() {
		Identifier id = new Identifier("foo");
		Position pos = new Position(1, 0);
		FunctionCall func = new FunctionCall(id, null, pos);
		this.state.createFunctionResult(func, new IntegerValue("42"));
		assertNotNull(this.state.getReturnValues().get(func));
	}
	
	@Test
	public void getVariablesTest() {
		HashMap<Identifier, Value> map = new HashMap<Identifier, Value>();
		assertEquals(map, this.state.getVariables());
	}
	
	@Test
	public void createArrayTest() {
		int[] length = {2};
		this.state.createArray("a", new ArrayType(new IntegerType()), length);
		assertNotNull(this.state.getVariables().get(new Identifier("a")));
	}
	
	@Test
	public void createVarTest() {
		this.state.createVar("i", "42", new IntegerType());
		assertNotNull(this.state.getVariables().get(new Identifier("i")));
	}
	
	@Test
	public void setArrayTest() {
		int[] length = {2};
		this.state.createArray("a", new ArrayType(new IntegerType()), length);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		this.state.setArray("a", "42", list);
		assertEquals(new IntegerValue("42"), 
				((ArrayValue) this.state.getVariables().get(new Identifier("a"))).getValues()[1]);
	}
	
	@Test
	public void setVarTest() {
		this.state.createVar("i", "42", new IntegerType());
		this.state.setVar("i", "0");
		assertEquals(new IntegerValue("0"), this.state.getVariables().get(new Identifier("i")));
	}
	
	@Test
	public void createScopeTest() {
		this.state.createScope(null, null);
		assertNotNull(this.state.getCurrentScope());
	}
	
	@Test
	public void destroyScopeTest() {
		Scope scope = this.state.getCurrentScope();
		this.state.createScope(null, null);
		this.state.destroyScope();
		assertEquals(scope, this.state.getCurrentScope());
		this.state.destroyScope();
		assertNotNull(this.state.getCurrentScope());
	}
	
	@After
	public void tearDown() {
		this.state = null;
	}

}

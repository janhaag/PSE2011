package test.interpreter;


import static org.junit.Assert.*;

import interpreter.ArrayValue;
import interpreter.BooleanValue;
import interpreter.IntegerValue;
import interpreter.Scope;
import interpreter.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.ArrayType;
import ast.Assignment;
import ast.BooleanType;
import ast.Function;
import ast.FunctionCall;
import ast.Identifier;
import ast.IntegerType;
import ast.Position;
import ast.StatementBlock;

public class ScopeTest {
	private Scope scope;
	private Scope scope2;
	private Scope scope3;

	@Before
	public void setUp() {
		Position pos = new Position(42, 42);
		Position pos2 = new Position(41, 41);
		Position pos3 = new Position(40, 40);
		Assignment[] assignment = {new Assignment(pos, null, new Identifier("x"))};
		Assignment[] assignment2 = {};
		StatementBlock block = new StatementBlock(assignment, pos2);
		StatementBlock block2 = new StatementBlock(assignment2, pos2);
		Function func = new Function(pos3, new IntegerType(), "foo",
				null, null, null, null);
		this.scope = new Scope(null, block, func);
		this.scope2 = new Scope(null, null, null);
		this.scope2 = new Scope(null, null, func);
		this.scope2 = new Scope(this.scope, block2, null);
		this.scope3 = new Scope(this.scope, null, null);
	}

	@Test
	public void getVariablesTest() {
		HashMap<Identifier, Value> map = new HashMap<Identifier, Value>();
		assertEquals(map, this.scope.getVariables());
		assertEquals(map, this.scope2.getVariables());
	}
	
	@Test
	public void getParentTest() {
		assertEquals(this.scope, this.scope2.getParent());
	}
	
	@Test
	public void isFunctionScopeTest() {
		assertTrue(this.scope.isFunctionScope());
		assertFalse(this.scope2.isFunctionScope());
	}
	
	@Test
	public void getCurrentFunction() {
		assertNotNull(this.scope.getCurrentFunction());
		assertNotNull(this.scope2.getCurrentFunction());
	}
	
	@Test 
	public void getReturnValuesTest() {
		IdentityHashMap<FunctionCall, Value> map = new IdentityHashMap<FunctionCall, Value>();
		assertEquals(map, this.scope.getReturnValues());
	}
	
	@Test
	public void getNextStatementTest() {
		assertNotNull(this.scope.getNextStatement());
		assertNull(this.scope2.getNextStatement());
	}
	
	@Test
	public void existsInScopeTest() {
		assertFalse(this.scope.existsInScope(new Identifier("x")));
	}
	
	@Test
	public void createVarTest() {
		assertNull(this.scope.getVariables().get(new Identifier("i")));
		assertNull(this.scope.getVariables().get(new Identifier("j")));
		this.scope.createVar("i", "42", new IntegerType());
		this.scope.createVar("j", "true", new BooleanType());
		assertNotNull(this.scope.getVariables().get(new Identifier("i")));
		assertNotNull(this.scope.getVariables().get(new Identifier("j")));
	}
	
	@Test
	public void getDepthOfVariableTest() {
		this.scope.createVar("i", "42", new IntegerType());
		assertEquals(0, this.scope.getDepthOfVariable(new Identifier("i")));
		assertEquals(0, this.scope2.getDepthOfVariable(new Identifier("i")));
		this.scope3.createVar("i", "42", new IntegerType());
		assertEquals(1, this.scope3.getDepthOfVariable(new Identifier("i")));
	}
	
	@Test
	public void setVarTest() {
		this.scope.createVar("i", "42", new IntegerType());
		this.scope.createVar("j", "false", new BooleanType());
		this.scope.setVar("i", "32");
		this.scope.setVar("j", "true");
		assertEquals(new IntegerValue("32"), this.scope.getVariables().get(new Identifier("i")));
		assertEquals(new BooleanValue("true"), this.scope.getVariables().get(new Identifier("j")));
	}
	
	@Test
	public void createArrayTest() {
		int[] length = {2};
		this.scope.createArray("a", new ArrayType(new IntegerType()), length);
		assertNotNull(this.scope.getVariables().get(new Identifier("a")));
	}
	
	@Test
	public void setArrayTest() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		int[] length = {2};
		this.scope.createArray("a", new ArrayType(new IntegerType()), length);
		this.scope.setArray("b", "5", list);
		this.scope.setArray("a", "5", list);
		assertEquals(new IntegerValue("5"), ((ArrayValue) this.scope.getVariables().get(new Identifier("a"))).getValues()[0]);
	}
	
	@Test
	public void getCurrentStatementTest() {
		assertNull(this.scope.getCurrentStatement());
	}
	
	@Test
	public void createAndClearFunctionResultTest() {
		FunctionCall funcCall = new FunctionCall(null, null, null);
		this.scope.createFunctionResult(funcCall, new IntegerValue("42"));
		assertNotNull(this.scope.getReturnValues().get(funcCall));
		this.scope.clearFunctionResults();
		assertNull(this.scope.getReturnValues().get(funcCall));
	}
	
	
	@After
	public void tearDown() {
		this.scope = null;
	}

}

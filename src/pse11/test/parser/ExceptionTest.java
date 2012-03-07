package test.parser;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parser.FunctionCallNotAllowedException;
import parser.IllegalTypeException;
import parser.TreeGeneratorException;

import ast.Position;

public class ExceptionTest {
	private FunctionCallNotAllowedException fce;
	private IllegalTypeException ite;
	private TreeGeneratorException tge;

	@Before
	public void setUp() {
		Position pos = new Position(1, 0);
		this.fce = new FunctionCallNotAllowedException("Function call error!", pos);
		this.ite = new IllegalTypeException("Type error!", pos);
		this.tge = new TreeGeneratorException("Tree error!");
	}

	@Test
	public void getFunctionCallErrorPosition() {
		assertEquals(1, this.fce.getErrorPosition().getLine());
		assertEquals(0, this.fce.getErrorPosition().getColumn());
	}
	
	@Test
	public void getIllegalTypeErrorPosition() {
		assertEquals(1, this.ite.getErrorPosition().getLine());
		assertEquals(0, this.ite.getErrorPosition().getColumn());
	}
	
	@Test
	public void createTreeGeneratorExceptionTest() {
		assertNotNull(this.tge);
	}
	
	@After
	public void tearDown() {
		this.fce = null;
		this.ite = null;
		this.tge = null;
	}

}

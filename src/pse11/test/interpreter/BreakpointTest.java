package test.interpreter;


import static org.junit.Assert.*;
import interpreter.AssertionFailureException;
import interpreter.GlobalBreakpoint;
import interpreter.StatementBreakpoint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.Position;

public class BreakpointTest {
	private GlobalBreakpoint globalBreakpoint;
	private StatementBreakpoint statementBreakpoint;
	private AssertionFailureException assertionFailure;
	

	@Before
	public void setUp() {
		this.globalBreakpoint = new GlobalBreakpoint(null);
		this.statementBreakpoint = new StatementBreakpoint(0);
		Position pos = new Position(0, 0);
		this.assertionFailure = new AssertionFailureException("Assertion failed!",
				pos);
	}
	
	/* GlobalBreakpoint tests */
	@Test
	public void getExpressionTest() {
		assertEquals(null, this.globalBreakpoint.getExpression());
	}
	
	@Test
	public void isActiveTest() {
		assertTrue(this.globalBreakpoint.isActive());
	}
	
	@Test 
	public void setActiveTest() {
		this.globalBreakpoint.setActive(false);
		assertFalse(this.globalBreakpoint.isActive());
	}
	
	/* StatementBreakpoint test */
	@Test
	public void getLineTest() {
		assertEquals(0, this.statementBreakpoint.getLine());
	}
	
	/* AssertionFailureException test */
	@Test
	public void getPositionTest() {
		assertEquals(0, this.assertionFailure.getPosition().getLine());
		assertEquals(0, this.assertionFailure.getPosition().getColumn());
	}
	
	@After
	public void tearDown() {
		this.globalBreakpoint = null;
		this.statementBreakpoint = null;
		this.assertionFailure = null;
	}

}

package test.interpreter;


import static org.junit.Assert.*;
import interpreter.GlobalBreakpoint;
import interpreter.StatementBreakpoint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BreakpointTest {
	private GlobalBreakpoint globalBreakpoint;
	private StatementBreakpoint statementBreakpoint;
	

	@Before
	public void setUp() throws Exception {
		this.globalBreakpoint = new GlobalBreakpoint(null);
		this.statementBreakpoint = new StatementBreakpoint(0);
	}
	
	/* GlobalBreakpoint tests */
	@Test
	public void getGlobalBreakpointExpression() {
		assertEquals(null, this.globalBreakpoint.getExpression());
	}
	
	@Test
	public void isGlobalBreakpointActive() {
		assertTrue(this.globalBreakpoint.isActive());
	}
	
	@Test 
	public void setGlobalBreakpointActive() {
		this.globalBreakpoint.setActive(false);
		assertFalse(this.globalBreakpoint.isActive());
	}
	
	/* StatementBreakpoint tests */
	@Test
	public void getStatementBreakpointLine() {
		assertEquals(0, this.statementBreakpoint.getLine());
	}

	@After
	public void tearDown() throws Exception {
		this.globalBreakpoint = null;
		this.statementBreakpoint = null;
	}

}

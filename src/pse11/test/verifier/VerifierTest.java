package test.verifier;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.Assumption;
import ast.Ensure;
import ast.Function;
import ast.FunctionParameter;
import ast.Position;
import ast.Program;
import ast.StatementBlock;
import ast.VariableDeclaration;

import verifier.VerifierInterface;
import verifier.smtlib.z3.Z3;

public class VerifierTest {
	private Z3 z3;
	private Z3 z4;
	private VerifierInterface verifier;

	@Before
	public void setUp() {
		this.z3 = new Z3("${FILE} ${MEMORY_LIMIT} ${TIMEOUT}");
		this.z4 = new Z3("hallo");
		this.verifier = new VerifierInterface(this.z3);
	}

	/* Z3 tests */
	@Test
	public void getDescriptionsTest() {
		assertNull(this.z3.getDescriptions());
	}
	
	@Test
	public void parseVerifierOutputTest() {
		assertEquals(true, this.z3.parseVerifierOutput("unsat (error)").getFirst().getValue1());
	}
	
	@Test
	public void setAndGetTimeoutTest() {
		this.z3.setTimeout("10");
		assertEquals("10", this.z3.getTimeout());
	}
	
	@Test
	public void setAndGetMemoryLimitTest() {
		this.z3.setMemoryLimit("100");
		assertEquals("100", this.z3.getMemoryLimit());
	}
	
	
	/* Verifier test */
	@Test
	public void callTest() {
		Position pos = new Position(1, 0);
		Program ast = new Program(pos, new Function[0], new Function(
                pos, null, "main", new FunctionParameter[0], 
                new StatementBlock(new VariableDeclaration[0], pos), new Assumption[0],
                new Ensure[0]), null);
		try {
			assertEquals("", this.z4.call(ast));
		} catch (IOException expected) {
		} catch (InterruptedException e) {
		}
		
		try {
			this.z3.setTimeout("10");
			this.z3.setMemoryLimit("100");
			this.z3.call(ast);
		} catch (IOException expected) {
		} catch (InterruptedException e) {
		}
	}
	
	/* VerifierInterface tests */
	@Test
	public void setVerifierTimeoutTest() {
		this.verifier.setTimeout("42");
		assertEquals("42", this.z3.getTimeout());
	}
	
	@Test
	public void setVerifierMemorylimitTest() {
		this.verifier.setMemoryLimit("10");
		assertEquals("10", this.z3.getMemoryLimit());
	}
	
	@Test
	public void getVerifierDescriptionsTest() {
		assertNull(this.verifier.getDescriptions());
	}
	
	@After
	public void tearDown() {
		this.z3 = null;
		this.verifier = null;
	}

}

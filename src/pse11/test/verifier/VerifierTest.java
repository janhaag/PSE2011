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

import verifier.smtlib.z3.Z3;

public class VerifierTest {
	private Z3 z3;

	@Before
	public void setUp() {
		this.z3 = new Z3("hallo");
	}

	@Test
	public void getDescriptionsTest() {
		assertNull(this.z3.getDescriptions());
	}
	
	@Test
	public void parseVerifierOutputTest() {
		assertEquals(true, this.z3.parseVerifierOutput("unsat (error)").getFirst().getValue1());
	}
	
	@Test
	public void callTest() {
		Position pos = new Position(1, 0);
		Program ast = new Program(pos, new Function[0], new Function(
                pos, null, "main", new FunctionParameter[0], 
                new StatementBlock(new VariableDeclaration[0], pos), new Assumption[0],
                new Ensure[0]), null);
		try {
			String s = this.z3.call(ast);
			assertEquals("", s);
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
	}
	
	@After
	public void tearDown() {
		this.z3 = null;
	}

}

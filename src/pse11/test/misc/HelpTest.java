package test.misc;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import misc.Help;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelpTest {
	private Help helpInstance;

	@BeforeClass
	public static void init() {
		assertNotNull(Help.getInstance());
		assertSame(Help.getInstance(), Help.getInstance());
	}
	
	@Before
	public void setUp() throws Exception {
		helpInstance = Help.getInstance();
	}

	@Test
	public void testGetTableOfContents() {
		String[] expectedTOC = new String[]{"Introduction", "Interpreting", "Verifying", "Comments", "Program", "Functions", "Statement", "Variables", "Assignment", "If Statement", "While Statement", "Expression", "Identifier", "Literal", "Boolean Operations", "Integer Operations", "Array Operations", "Specifications", "Assert", "Assume", "Ensure", "Invariant", "Axiom", "Quantified Expressions"};
		assertArrayEquals(expectedTOC, helpInstance.getTableOfContents());
	}

	@Test
	public void testGetHelpByTOC() {
		assertNotNull(helpInstance.getHelpByTOC("Introduction"));
		assertNotNull(helpInstance.getHelpByTOC("Quantified Expressions"));
		assertNotNull(helpInstance.getHelpByTOC("foo"));
	}

	@Test
	public void testGetHelpByTag() {
		assertEquals(helpInstance.getHelpByTOC("Introduction"), helpInstance.getHelpByTag("help"));
		assertEquals(helpInstance.getHelpByTOC("Interpreting"), helpInstance.getHelpByTag("run"));
		assertEquals(helpInstance.getHelpByTOC("If Statement"), helpInstance.getHelpByTag("if"));
		String expectedFileNotFound = "<html><head><title>File not found</title></head><body>Helpfile not found.</body></html>";
		assertEquals(expectedFileNotFound, helpInstance.getHelpByTag("foo"));
	}

	@Test
	public void testGetTags() {
		String[] expectedTags = new String[]{"expression", "assign", "verify", "interpret", "run", "validate", "while", "function", "quantifier", "invariant", "help", "division", "if", "name", "loop", "write", "length", "boolean", "ensure", "else", "declaration", "constant", "integer", "return", "forall", "assertion", "main", "statement", "syntax", "assignment", "logical", "program", "exists", "modulo", "assert", "conditional", "bool", "assume", "comment", "axiom", "variable", "identifier", "array", "literal"};
		assertEquals(expectedTags.length, helpInstance.getTags().length);
		for(int i = 0; i < expectedTags.length; i++) {
			assertTrue(Arrays.asList(helpInstance.getTags()).contains(expectedTags[i]));
		}
	}

	@Test
	public void testGetSmallStyle() {
		assertNotNull(helpInstance.getSmallStyle());
	}

	@Test
	public void testGetDefaultStyle() {
		assertNotNull(helpInstance.getDefaultStyle());
	}
}

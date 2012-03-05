package test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import interpreter.StatementBreakpoint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import misc.Editor;
import misc.Keyword;

public class EditorTest {
	private Editor editorInstance;
	
	@Before
	public void setUp() {
		this.editorInstance = new Editor();
	}
	
	@Test
	public void testSetSource() {
		this.editorInstance.setSource("test");
		assertEquals(this.editorInstance.getSource(), "test");
	}
	
	@Test
	public void testKeyWordDetection() throws IllegalArgumentException, 
												IllegalAccessException, 
												InvocationTargetException, 
												SecurityException, 
												NoSuchMethodException {
		String testsource = "if while true false int bool array else return assert assume axiom ensure "
			+ "invariant \n forall \r exists \t main";
		
		Method findKeyWordsMethod = Editor.class.getDeclaredMethod("findKeywords", new Class[]{String.class});
		findKeyWordsMethod.setAccessible(true);
		findKeyWordsMethod.invoke(this.editorInstance, testsource);

		ArrayList<Keyword> testlist = new ArrayList<Keyword>();
		testlist.add(new Keyword(0, 2, "0000FF"));
		testlist.add(new Keyword(3, 5, "0000FF"));
		testlist.add(new Keyword(9, 4, "00FF00"));
		testlist.add(new Keyword(14, 5, "FF0000"));
		testlist.add(new Keyword(20, 3, "0000FF"));
		testlist.add(new Keyword(24, 4, "0000FF"));
		testlist.add(new Keyword(29, 5, "0000FF"));
		testlist.add(new Keyword(35, 4, "0000FF"));
		testlist.add(new Keyword(40, 6, "0000FF"));
		testlist.add(new Keyword(47, 6, "0000FF"));
		testlist.add(new Keyword(54, 6, "0000FF"));
		testlist.add(new Keyword(61, 5, "0000FF"));
		testlist.add(new Keyword(67, 6, "0000FF"));
		testlist.add(new Keyword(74, 9, "0000FF"));
		testlist.add(new Keyword(86, 6, "0000FF"));
		testlist.add(new Keyword(95, 6, "0000FF"));
		testlist.add(new Keyword(104, 4, "0000FF"));
		assertEquals(testlist.size(), this.editorInstance.getColorArray().size());
		for(int i = 0; i < testlist.size(); i++) {
			assertEquals(testlist.get(i), this.editorInstance.getColorArray().get(i));
		}
	}
	
	@Test
	public void testNumberDetection() throws IllegalArgumentException, 
												IllegalAccessException, 
												InvocationTargetException, 
												SecurityException, 
												NoSuchMethodException {
		String testsource = "0 =1 2) 3; [4 5]";
		
		Method findKeyWordsMethod = Editor.class.getDeclaredMethod("findKeywords", new Class[]{String.class});
		findKeyWordsMethod.setAccessible(true);
		findKeyWordsMethod.invoke(this.editorInstance, testsource);
	
		ArrayList<Keyword> testlist = new ArrayList<Keyword>();
		testlist.add(new Keyword(0, 1, "FF8000"));
		testlist.add(new Keyword(3, 1, "FF8000"));
		testlist.add(new Keyword(5, 1, "FF8000"));
		testlist.add(new Keyword(8, 1, "FF8000"));
		testlist.add(new Keyword(12, 1, "FF8000"));
		testlist.add(new Keyword(14, 1, "FF8000"));
		assertEquals(testlist.size(), this.editorInstance.getColorArray().size());
		for(int i = 0; i < testlist.size(); i++) {
			assertEquals(testlist.get(i), this.editorInstance.getColorArray().get(i));
		}
	}
	
	@Test
	public void testSetSourceWithKeywords() {
		this.editorInstance.setSource("if while true false int bool array else return assert assume axiom ensure "
			+ "invariant \n forall \r exists \t main");
		ArrayList<Keyword> testlist = new ArrayList<Keyword>();
		testlist.add(new Keyword(0, 2, "0000FF"));
		testlist.add(new Keyword(3, 5, "0000FF"));
		testlist.add(new Keyword(9, 4, "00FF00"));
		testlist.add(new Keyword(14, 5, "FF0000"));
		testlist.add(new Keyword(20, 3, "0000FF"));
		testlist.add(new Keyword(24, 4, "0000FF"));
		testlist.add(new Keyword(29, 5, "0000FF"));
		testlist.add(new Keyword(35, 4, "0000FF"));
		testlist.add(new Keyword(40, 6, "0000FF"));
		testlist.add(new Keyword(47, 6, "0000FF"));
		testlist.add(new Keyword(54, 6, "0000FF"));
		testlist.add(new Keyword(61, 5, "0000FF"));
		testlist.add(new Keyword(67, 6, "0000FF"));
		testlist.add(new Keyword(74, 9, "0000FF"));
		testlist.add(new Keyword(86, 6, "0000FF"));
		testlist.add(new Keyword(95, 6, "0000FF"));
		testlist.add(new Keyword(104, 4, "0000FF"));
		assertEquals(testlist.size(), this.editorInstance.getColorArray().size());
		for(int i = 0; i < testlist.size(); i++) {
			assertEquals(testlist.get(i), this.editorInstance.getColorArray().get(i));
		}
	}
	
	@Test
	public void removeUnexistingStatementBreakpoint() {
		assertEquals(0, this.editorInstance.removeBreakpoint(0));
	}
	
	@Test
	public void addStatementBreakpoint() {
		this.editorInstance.addBreakpoint(0);
		ArrayList<StatementBreakpoint> testlist = new ArrayList<StatementBreakpoint>();
		testlist.add(new StatementBreakpoint(0));
		assertEquals(testlist.size(), this.editorInstance.getStatementBreakpoints().size());
	}
	
	@Test
	public void removeStatementBreakpoint() {
		this.editorInstance.addBreakpoint(0);
		this.editorInstance.addBreakpoint(1);
		this.editorInstance.removeBreakpoint(1);
		assertEquals(1, this.editorInstance.getStatementBreakpoints().size());
	}
	
	@Test
	public void testUndo() {
		this.editorInstance.undo();
		this.editorInstance.setSource("t");
		assertEquals("t", this.editorInstance.getSource());
		this.editorInstance.setSource("te");
		assertEquals("te", this.editorInstance.getSource());
		this.editorInstance.setSource("tes");
		assertEquals("tes", this.editorInstance.getSource());
		this.editorInstance.undo();
		assertEquals("te", this.editorInstance.getSource());
		this.editorInstance.setSource("tes");
		assertEquals("tes", this.editorInstance.getSource());
		this.editorInstance.setSource("test");
		assertEquals("test", this.editorInstance.getSource());
	}
	
	@Test
	public void testRedo() {
		this.editorInstance.redo();
		this.editorInstance.setSource("t");
		assertEquals("t", this.editorInstance.getSource());
		this.editorInstance.setSource("te");
		assertEquals("te", this.editorInstance.getSource());
		this.editorInstance.setSource("tes");
		assertEquals("tes", this.editorInstance.getSource());
		this.editorInstance.undo();
		assertEquals("te", this.editorInstance.getSource());
		this.editorInstance.redo();
		assertEquals("tes", this.editorInstance.getSource());
		this.editorInstance.setSource("test");
		assertEquals("test", this.editorInstance.getSource());
	}
	
	@After
	public void tearDown() {
		this.editorInstance = null;
	}
}

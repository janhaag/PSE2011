package test.misc;


import static org.junit.Assert.*;

import misc.Keyword;
import misc.Pair;

import org.eclipse.swt.graphics.RGB;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MiscTest {
	private Keyword key;
	private Pair pair;

	@Before
	public void setUp() {
		try {
			this.key = new Keyword(0, -10, null);
		}
		catch (IllegalArgumentException expected) {
		}
		this.key = new Keyword(0, 5, "FFFFFF");
		this.pair = new Pair(3, 5);
	}
	
	/* Keyword tests */
	@Test
	public void getStartTest() {
		assertEquals(0, this.key.getStart());
	}
	
	@Test
	public void getLengthTest() {
		assertEquals(5, this.key.getLength());
	}
	
	@Test
	public void getColorTest() {
		RGB rgb = new RGB(255, 255, 255);
		assertEquals(rgb, this.key.getColor());
	}

	@Test
	public void equalsTest() {
		assertFalse(this.key.equals("hallo"));
		assertTrue(this.key.equals(this.key));
		Keyword key2 = new Keyword(5, 10, "FFFFFF");
		assertFalse(this.key.equals(key2));
		Keyword key3 = new Keyword(0, 10, "FFFFFF");
		assertFalse(this.key.equals(key3));
		Keyword key4 = new Keyword(0, 5, "000000");
		assertFalse(this.key.equals(key4));
	}
	
	/* Pair tests */
	@Test
	public void getValue1Test() {
		assertEquals(3, this.pair.getValue1());
	}
	
	@Test
	public void getValue2Test() {
		assertEquals(5, this.pair.getValue2());
	}
	
	@After
	public void tearDown() {
		this.key = null;
		this.pair = null;
	}

}

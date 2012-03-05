package test.interpreter;


import static org.junit.Assert.*;

import interpreter.ArrayValue;
import interpreter.BooleanValue;
import interpreter.IntegerValue;
import interpreter.Value;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast.ArrayType;
import ast.BooleanType;
import ast.IntegerType;
import ast.Type;

public class ValueTest {
	private ArrayValue intArrayValue;
	private ArrayValue boolArrayValue;
	private IntegerValue intValue;
	private BooleanValue boolValue;

	@Before
	public void setUp() {
		int[] length = {2, 2};
		this.intArrayValue = new ArrayValue(new ArrayType(new ArrayType(new IntegerType())),
				length);
		this.boolArrayValue = new ArrayValue(new ArrayType(new ArrayType (new BooleanType())),
				length);
		this.intValue = new IntegerValue("42");
		this.boolValue = new BooleanValue("true");
	}

	/* IntgerValue tests */	
	@Test 
	public void getValueOfIntegerValue() {
		BigInteger a = new BigInteger("42");
		assertEquals(a, this.intValue.getValue());
	}
	
	@Test
	public void setValueOfIntegerValue() {
		BigInteger b = new BigInteger("0");
		this.intValue.setValue(null);
		assertEquals(b, this.intValue.getValue());
		this.intValue.setValue("hallo");
		assertEquals(b, this.intValue.getValue());
		BigInteger c = new BigInteger("42");
		this.intValue.setValue("42");
		assertEquals(c, this.intValue.getValue());
	}
	
	@Test
	public void integerValueToString() {
		assertEquals("42", this.intValue.toString());
	}
	
	@Test
	public void integerValueEquals() {
		assertTrue(this.intValue.equals(this.intValue));
		assertFalse(this.intValue.equals(null));
		assertFalse(this.intValue.equals(42));
		IntegerValue newIntValue = new IntegerValue("42");
		assertTrue(this.intValue.equals(newIntValue));
	}
	
	/* BooleanValue tests */
	@Test 
	public void getValueOfBooleanValue() {
		assertEquals(true, this.boolValue.getValue());
	}
	
	@Test
	public void setValueOfBooleanValue() {
		this.boolValue.setValue(null);
		assertEquals(false, this.boolValue.getValue());
		this.boolValue.setValue("true");
		assertEquals(true, this.boolValue.getValue());
	}
	
	@Test
	public void booleanValueToString() {
		assertEquals("true", this.boolValue.toString());
	}
	
	@Test
	public void booleanValueEquals() {
		assertTrue(this.boolValue.equals(this.boolValue));
		assertFalse(this.boolValue.equals(null));
		assertFalse(this.boolValue.equals(true));
		BooleanValue newBoolValue = new BooleanValue("true");
		assertTrue(this.boolValue.equals(newBoolValue));
		BooleanValue newBoolValue2 = new BooleanValue("false");
		assertFalse(this.boolValue.equals(newBoolValue2));
	}
	
	/* ArrayValue tests */	
	@Test 
	public void getValueOfArrayValue() {
		Value[] values = new Value[4];
		int[] length = {2, 2};
		values[0] = new ArrayValue(new ArrayType(new IntegerType()), 
				length, 1);
		values[1] = new ArrayValue(new ArrayType(new IntegerType()), 
				length, 1);
		values[2] = new IntegerValue(null);
		assertEquals(values[0], this.intArrayValue.getValues()[0]);
		assertEquals(values[1], this.intArrayValue.getValues()[1]);
	}
	
	 @Test
	public void setValueOfArrayValue() {
		 List<Integer> list = new ArrayList<Integer>();
		 list.add(0);
		 list.add(1);
		 IntegerValue newIntValue = new IntegerValue("42");
		 this.intArrayValue.setValue("42", list);
		 assertEquals(newIntValue, ((ArrayValue) this.intArrayValue.getValues()[0]).getValues()[1]);
		 List<Integer> list2 = new ArrayList<Integer>();
		 list2.add(-1);
		 list2.add(5);
		 this.intArrayValue.setValue("42", list2);
		 assertEquals(newIntValue, ((ArrayValue) this.intArrayValue.getValues()[0]).getValues()[0]);
		 BooleanValue newBoolValue = new BooleanValue("true");
		 this.boolArrayValue.setValue("true", list);
		 assertEquals(newBoolValue, ((ArrayValue) this.boolArrayValue.getValues()[0]).getValues()[1]);
	 }
	
	@Test
	public void arrayValueToString() {
		assertEquals("{{0,0},{0,0}}", this.intArrayValue.toString());
		assertEquals("{{false,false},{false,false}}", this.boolArrayValue.toString());
	}
	
	@Test
	public void arrayValueEquals() {
		assertTrue(this.intArrayValue.equals(this.intArrayValue));
		assertFalse(this.intArrayValue.equals(null));
		assertFalse(this.intArrayValue.equals(42));
		int[] length = {3, 3};
		ArrayValue newArrayValue = new ArrayValue(new ArrayType(new IntegerType()), 
				length);
		assertFalse(this.intArrayValue.equals(newArrayValue));
		int[] length2 = {2, 2};
		ArrayValue newArrayValue2 = new ArrayValue(new ArrayType(new IntegerType()), 
				length2);
		assertFalse(this.intArrayValue.equals(newArrayValue2));
		ArrayValue newArrayValue3 = new ArrayValue(new ArrayType(new ArrayType (new IntegerType())), 
				length2);
		assertTrue(this.intArrayValue.equals(newArrayValue3));
	}
	
	/* Value test */
	@Test 
	public void getTypeOfValue() {
		Type type = new IntegerType();
		assertEquals(type, this.intValue.getType());
	}
	
	@After
	public void tearDown() {
		this.intArrayValue = null;
		this.boolArrayValue = null;
		this.intValue = null;
		this.boolValue = null;
	}

}

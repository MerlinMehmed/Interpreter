package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talentboost.interpreter.variables.StringVar;

public class StringVarTest {

	@Test
	public void nullStringTest() {
		StringVar empty = new StringVar("empty", null);
		assertEquals(null, empty.getValue());
	}

	@Test
	public void getValueTest() {
		StringVar str = new StringVar("str", "value");
		assertEquals("value", str.getValue());
	}
	
	@Test
	public void getTypeTest() {
		StringVar str = new StringVar("str", "value");
		assertEquals("string", str.getType());
	}
}

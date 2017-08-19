package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.variables.NumberVar;

public class IntVarTest {

	NumberVar num;
	
	@Before
	public void setUp() {
		this.num = new NumberVar("num", 5);
	}
	
	@Test
	public void getValueTest() {
		assertEquals("5", num.getValue());
	}
	
	@Test
	public void getTypeTest() {
		assertEquals("number", num.getType());
	}

}

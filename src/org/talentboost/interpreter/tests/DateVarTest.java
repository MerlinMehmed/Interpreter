package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.variables.DateVar;

public class DateVarTest {

	DateVar date;
	
	@Before
	public void setUp() {
		this.date = new DateVar("date", Date.valueOf("2017-06-05"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void wrongDateTest() {
		new DateVar("date", Date.valueOf("2017-60-05"));
	}
	
	@Test
	public void getValueTest() {
		assertEquals("2017-06-05", date.getValue());
	}
	@Test
	public void getTypeTest() {
		assertEquals("date", date.getType());
	}
}

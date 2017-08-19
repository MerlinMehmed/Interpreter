package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.commands.CountWordsCmd;

public class CountWordsCmdTest {

	CountWordsCmd count;
	
	@Before
	public void setUp() {
		this.count = new CountWordsCmd();
	}
	
	@Test(expected = NullPointerException.class)
	public void emptyStringTest() {
		String[] input = {};
		count.doProcess(input);
	}

	@Test
	public void oneWordInputTest() {
		String[] input = {"abra"};
		String output = count.doProcess(input);
		assertEquals("1", output);
	}
	
	@Test
	public void twoWordInputTest() {
		String[] input = {"abra", "cadabra"};
		String output = count.doProcess(input);
		assertEquals("2", output);
	}
}

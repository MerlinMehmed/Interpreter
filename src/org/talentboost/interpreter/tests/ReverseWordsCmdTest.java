package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.commands.ReverseWordsCmd;

public class ReverseWordsCmdTest {

	ReverseWordsCmd rev;
	
	@Before
	public void setUp() {
		this.rev = new ReverseWordsCmd();
	}
	
	@Test
	public void twoWordsReverseTest() {
		String[] in = {"Abra", "mini"};
		String output = rev.doProcess(in);
		assertEquals("mini Abra", output);
	}
	
	@Test
	public void threeWordsReverseTest() {
		String[] in = {"Abra", "mini", "blue"};
		String output = rev.doProcess(in);
		assertEquals("blue mini Abra", output);
	}
	
	@Test
	public void oneReverseWordsTest() {
		String[] in = {"Abra"};
		String output = rev.doProcess(in);
		assertEquals("Abra", output);
	}

}

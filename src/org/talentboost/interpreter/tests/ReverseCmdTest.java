package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.commands.ReverseCmd;

public class ReverseCmdTest {

	ReverseCmd rev;

	@Before
	public void setUp() {
		this.rev = new ReverseCmd();
	}
	
	@Test
	public void reverseCmdTest() {
		String[] in = {"Abra", "mini"};
		String output = rev.doProcess(in);
		assertEquals("inim arbA", output);
	}
	
	@Test
	public void secondReverseTest() {
		String[] in = {"Abra", "mini", "blue"};
		String output = rev.doProcess(in);
		assertEquals("eulb inim arbA", output);
	}
	
	@Test
	public void thirdReverseTest() {
		String[] in = {"Abra"};
		String output = rev.doProcess(in);
		assertEquals("arbA", output);
	}
		
	@Test
	public void emptyStrReverseTest() {
		String[] in = {};
		String output = rev.doProcess(in);
		assertEquals("", output);
	}
}

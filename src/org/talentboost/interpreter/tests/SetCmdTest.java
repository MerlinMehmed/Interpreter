package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.AlreadyExistingVariableException;
import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.commands.SetCmd;


public class SetCmdTest {

	Memory mem;
	SetCmd set;
	
	@Before
	public void setUp() {
		this.mem = new Memory();
		this.set = new SetCmd(mem);
	}
	
	@Test
	public void setNumberVarTest() {
		String[] inp = {"alice", "number", "5"};
		String out = set.doProcess(inp);
		assertEquals("OK", out);
	}

	
	@Test
	public void setStringVarTest() {
		String[] inp = {"humpty", "string", "dumpy"};
		String out = set.doProcess(inp);
		assertEquals("OK", out);
	}
	
	@Test
	public void setDateVarTest() {
		String[] inp = {"bday", "date", "2017-08-04"};
		String out = set.doProcess(inp);
		assertEquals("OK", out);
	}
	
	@Test
	public void setSecondNumberVarTest() {
		String[] inp = {"abby", "number", "524"};
		String out = set.doProcess(inp);
		assertEquals("OK", out);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setInvalidVarTypeTest() {
		String[] inp = {"bday", "datee", "2017-08-04"};
		set.doProcess(inp);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setInvalidVarValueTest() {
		String[] inp = {"bday", "date", "today"};
		set.doProcess(inp);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setInvalidVarValue2Test() {
		String[] inp = {"bday", "number", "today"};
		set.doProcess(inp);
	}
	
	@Test
	public void setExistingVarTest() {
		String[] inp1 = {"bday", "number", "12"};
		set.doProcess(inp1);
		String[] inp = {"bday", "number", "12"};
		String out = set.doProcess(inp);
		assertEquals("Err", out);
	}
}

package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.AlreadyExistingVariableException;
import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.commands.GetCmd;
import org.talentboost.interpreter.variables.DateVar;
import org.talentboost.interpreter.variables.NumberVar;
import org.talentboost.interpreter.variables.StringVar;
import org.talentboost.interpreter.variables.Variable;

public class GetCmdTest {

	Memory mem;
	GetCmd get;
	
	@Before
	public void setUp() throws AlreadyExistingVariableException {
		this.mem = new Memory();
		this.get = new GetCmd(mem);

		//Add some variables to test
		Variable alice = new NumberVar("alice", 5);
		mem.create(alice);
		Variable humpty = new StringVar("humpty", "dumpty");
		mem.create(humpty);
		Variable bday = new DateVar("bday", Date.valueOf("2017-08-04"));
		mem.create(bday);
		Variable abby = new NumberVar("abby", 12);
		mem.create(abby);
	}
	
	@Test
	public void getIntVarTest() {
		String[] input = {"alice"};
		String output = get.doProcess(input);
		assertEquals("[number] 5", output);
	}
	
	@Test
	public void getStringVarTest() {
		String[] input = {"humpty"};
		String output = get.doProcess(input);
		assertEquals("[string] dumpty", output);
	}
	
	@Test
	public void getDateVarTest() {
		String[] input = {"bday"};
		String output = get.doProcess(input);
		assertEquals("[date] 2017-08-04", output);
	}
	
	@Test
	public void getAbbyIntVarTest() {
		String[] input = {"abby"};
		String output = get.doProcess(input);
		assertEquals("[number] 12", output);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getNotExistingVarTest() {
		String[] input = {"life"};
		get.doProcess(input);
	}
}

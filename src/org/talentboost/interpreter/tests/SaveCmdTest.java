package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.commands.SaveCmd;
import org.talentboost.interpreter.commands.SetCmd;

public class SaveCmdTest {

	Memory mem;
	SaveCmd save;
	
	@Before
	public void setUp() {
		this.mem = new Memory();
		this.save = new SaveCmd(mem);
	}
	
	@Test
	public void saveCommandTest() {
		SetCmd set = new SetCmd(mem);
		String[] input = {"humpty", "string", "dumpty"};
		String result = set.doProcess(input);
		assertEquals("OK", result);
		
		String[] input2 = {"brother", "number", "22"};
		String result2 = set.doProcess(input2);
		assertEquals("OK", result2);
		
		String[] input3 = {"bday", "date", "1991-02-13"};
		String result3 = set.doProcess(input3);
		assertEquals("OK", result3);
				
		SaveCmd save = new SaveCmd(mem);
		String[] inp = {"saved"};
		String r = save.doProcess(inp);
		assertEquals("OK", r);
		
	}
}

package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.commands.LoadCmd;
import org.talentboost.interpreter.commands.SaveCmd;
import org.talentboost.interpreter.commands.SetCmd;

public class LoadCmdTest {

	Memory mem;
	LoadCmd load;
	
	@Before
	public void setUp() {
		this.mem = new Memory();
		this.load = new LoadCmd(mem);
	}
	
	@Test
	public void existingFileTest() {
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
		
		String[] in = {"saved.txt"};
		assertEquals("OK",load.doProcess(in));
		assertEquals(true, mem.contains("brother"));
		assertEquals(true, mem.contains("humpty"));
		assertEquals(true, mem.contains("bday"));
		assertEquals(false, mem.contains("dumpty"));
	}

	@Test
	public void notExistingFileTest() {
		String[] inp = {"unsaved.txt"};
		assertEquals("Err",load.doProcess(inp));
	}

}

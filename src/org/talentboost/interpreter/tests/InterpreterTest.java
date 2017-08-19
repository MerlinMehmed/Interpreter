package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.Interpret;
import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.commands.Commands;
import org.talentboost.interpreter.commands.GetCmd;
import org.talentboost.interpreter.commands.SetCmd;

public class InterpreterTest {

	final Map<String, Commands> cmdMap = new HashMap<String, Commands>();
	Interpret interpreter;
	Memory mem;
			
	@Before
	public void setUp() {
		this.mem = new Memory();
		Commands get = new GetCmd(mem);
		cmdMap.put(get.cmdName(), get);
		Commands set = new SetCmd(mem);
		cmdMap.put(set.cmdName(), set);
		this.interpreter = new Interpret(cmdMap);
	}
	
	@Test
	public void simpleSetTest() {
		String line = "set humpty string dumpty";
		String result = interpreter.process(line);
		assertEquals("OK", result);
	}
	
	@Test
	public void simpleGetTest() {
		String line = "set humpty string dumpty";
		interpreter.process(line);
		
		String line2 = "get humpty";
		String result = interpreter.process(line2);
		assertEquals("[string] dumpty", result);
	}

}

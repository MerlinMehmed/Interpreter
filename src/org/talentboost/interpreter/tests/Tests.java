package org.talentboost.interpreter.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.talentboost.interpreter.AlreadyExistingVariableException;
import org.talentboost.interpreter.Interpret;
import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.commands.Commands;
import org.talentboost.interpreter.commands.GetCmd;
import org.talentboost.interpreter.commands.ReverseCmd;
import org.talentboost.interpreter.commands.SetCmd;
import org.talentboost.interpreter.variables.NumberVar;
import org.talentboost.interpreter.variables.Variable;

public class Tests {

	Variable var;
	Memory mem;
	
	@Before
	public void setUp() {
		this.var = new NumberVar("alice", 5);
		this.mem = new Memory();
	}


	@Test
	public void interpreterTest() throws AlreadyExistingVariableException {
		mem.create(var);
		final Map<String, Commands> cmdMap = new HashMap<String, Commands>();
		Commands get = new GetCmd(mem);
		cmdMap.put(get.cmdName(), get);
		Commands set = new SetCmd(mem);
		cmdMap.put(set.cmdName(), set);
		Interpret interpreter = new Interpret(cmdMap);
		String line = "set humpty string dumpty";
		String result = interpreter.process(line);
		assertEquals("OK", result);
	}
	
	@Test
	public void interpreterReverseTest() {
		final Map<String, Commands> cmdMap = new HashMap<String, Commands>();
		Commands get = new GetCmd(mem);
		cmdMap.put(get.cmdName(), get);
		Commands set = new SetCmd(mem);
		cmdMap.put(set.cmdName(), set);
		Commands rev = new ReverseCmd();
		cmdMap.put(rev.cmdName(), rev);
		Interpret interpreter = new Interpret(cmdMap);
		String line = "reverse abra kimi";
		String result = interpreter.process(line);
		assertEquals("imik arba", result);
	}
}

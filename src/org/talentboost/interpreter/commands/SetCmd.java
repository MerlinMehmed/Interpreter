package org.talentboost.interpreter.commands;

import org.talentboost.interpreter.AlreadyExistingVariableException;
import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.Parser;
import org.talentboost.interpreter.variables.Variable;

public final class SetCmd implements Commands {
	
	private static final String CMD_NAME = "set";
	private Memory memory;
	
	public SetCmd(Memory memory) {
		this.memory = memory;
	}

	@Override
	public String doProcess(String[] input) {
		Parser parser = new Parser();
		Variable var = parser.parse(input);
		try {
			memory.create(var);
		} catch (AlreadyExistingVariableException e) {
			return "Err";
		}
		return "OK";
	}

	@Override
	public int expectedArgCount() {
		return 3;
	}

	@Override
	public String cmdName() {
		return CMD_NAME;
	}
}

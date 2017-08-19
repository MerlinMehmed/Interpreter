package org.talentboost.interpreter.commands;

import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.variables.Variable;

public final class GetCmd implements Commands {

	private static final String CMD_NAME = "get";
	private Memory memory;
	
	public GetCmd(Memory memory) {
		this.memory = memory;
	}

	@Override
	public String doProcess(String[] input) {
		if(!memory.contains(input[0])) {
			throw new IllegalArgumentException();
		}
		Variable var = memory.find(input[0]);
		String output = "[" + var.getType() + "] " + var.getValue();
		return output;
	}

	@Override
	public int expectedArgCount() {
		return 1;
	}

	@Override
	public String cmdName() {
		return CMD_NAME;
	}

}

package org.talentboost.interpreter.commands;

import java.io.*;

import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.variables.Variable;

public final class SaveCmd implements Commands {

	private static final String CMD_NAME = "save";
	private Memory memory;
	
	public SaveCmd(Memory memory) {
		this.memory = memory;
	}
	
	@Override
	public String doProcess(String[] input) {
		File fileIn = new File(input[0] + ".txt");
		try (PrintWriter writer = new PrintWriter(fileIn)) {
			for(Variable var: memory.getVars()) {
				writer.println(var.getName() + " " + var.getType() + " " + var.getValue());
			}
		} catch(IOException e) {
			return "Err";
		}
		return "OK";
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

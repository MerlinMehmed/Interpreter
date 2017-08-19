package org.talentboost.interpreter.commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.talentboost.interpreter.Memory;

public final class LoadCmd implements Commands {
	private static final String CMD_NAME = "load";
	private Memory memory;
	
	public LoadCmd(Memory memory) {
		this.memory = memory;
	}
	
	@Override
	public String doProcess(String[] input) {
		SetCmd set = new SetCmd(memory);

		try(FileReader fr = new FileReader(input[0]);
			BufferedReader reader = new BufferedReader(fr)) {
			String line;
			while((line = reader.readLine()) != null) {
				String[] varInfo = line.split(" ");
				set.doProcess(varInfo);
			}
		} catch(FileNotFoundException e) {
			return "Err";
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

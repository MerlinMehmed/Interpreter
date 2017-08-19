/*package org.talentboost.interpreter.commands;

import org.talentboost.interpreter.Memory;

public abstract class Command {
	protected Memory memory;
	
	public Command() {
		
	}
	
	public Command(Memory memory) {
		this.memory = memory;
	}

	protected final String process (String[] args) throws IllegalArgumentException {
		if(args.length != expectedArgCount()) {
			throw new IllegalArgumentException();
		}
		
		return doProcess(args);
	}
	protected abstract int expectedArgCount();
	public abstract String doProcess(String[] input);
	public abstract String cmdName();
}
*/
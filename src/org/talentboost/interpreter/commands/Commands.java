package org.talentboost.interpreter.commands;

public interface Commands {

	public int expectedArgCount();
	public String doProcess(String[] input);
	public String cmdName();
}

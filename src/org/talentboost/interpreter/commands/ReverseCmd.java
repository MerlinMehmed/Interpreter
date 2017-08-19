package org.talentboost.interpreter.commands;

public final class ReverseCmd implements Commands {
	
	private static final String CMD_NAME = "reverse";
	
	@Override
	public String doProcess(String[] input) {
		String answer = String.join(" ", input);
		StringBuilder strBuilder = new StringBuilder(answer);
		StringBuilder output = strBuilder.reverse();
		return output.toString();
	}

	@Override
	public int expectedArgCount() {
		return 0;
	}

	@Override
	public String cmdName() {
		return CMD_NAME;
	}

}

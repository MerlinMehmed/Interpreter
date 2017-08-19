package org.talentboost.interpreter.commands;

public final class ReverseWordsCmd implements Commands {

	public final static String CMD_NAME = "reverse-words";
	
	@Override
	public int expectedArgCount() {
		return 0;
	}

	@Override
	public String doProcess(String[] input) {
		StringBuilder answer = new StringBuilder();
		for(int i = input.length - 1; i >= 0; i--) {
			answer.append(input[i] + " ");
		}
		return answer.toString().trim();
	}

	@Override
	public String cmdName() {
		return CMD_NAME;
	}

}

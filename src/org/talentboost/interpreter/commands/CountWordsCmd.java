package org.talentboost.interpreter.commands;


public final class CountWordsCmd implements Commands {

	private final static String CMD_NAME="count-words";

	@Override
	public String doProcess(String[] input) {
		if (input == null || input.length == 0) {
			throw new NullPointerException();
		}
		int length = input.length;
		return String.valueOf(length);
	}

	@Override
	public String cmdName() {
		return CMD_NAME;
	}

	@Override
	public int expectedArgCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}

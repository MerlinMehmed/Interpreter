package org.talentboost.interpreter.variables;

import org.talentboost.interpreter.Visitor;

public final class NumberVar extends Variable {

	private int value;
	
	public NumberVar(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getValue() {
		return String.valueOf(value);
	}
	
	public String getType() {
		return "number";
	}

	@Override
	public void accept(String op, Visitor v) {
		v.visit(op, this);
	}
}

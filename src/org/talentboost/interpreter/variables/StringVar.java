package org.talentboost.interpreter.variables;

import org.talentboost.interpreter.Visitor;

public final class StringVar extends Variable {

	private String value;
	
	public StringVar(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	public String getType() {
		return "string";
	}

	@Override
	public void accept(String op, Visitor v) {
		v.visit(op, this);
	}
}

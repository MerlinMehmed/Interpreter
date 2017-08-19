package org.talentboost.interpreter.variables;

import org.talentboost.interpreter.Visitor;

public abstract class Variable {
	protected String name;
	
	public String getName() {
		return this.name;
	}
	
	public abstract String getType();
	public abstract String getValue();
	public abstract void accept(String op, Visitor v);
}

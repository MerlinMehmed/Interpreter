package org.talentboost.interpreter.variables;

import java.util.Date;

import org.talentboost.interpreter.Visitor;

public final class DateVar extends Variable {

	private Date value;
	
	public DateVar(String name, Date value) {
		try {
			value.getTime();
		} catch(IllegalArgumentException e) {
			System.out.println("Invalid date");
		}
		this.name = name;
		this.value = value;
	}

	public String getValue() {
		return String.valueOf(value);
	}
	
	public String getType() {
		return "date";
	}

	@Override
	public void accept(String op, Visitor v) {
		v.visit(op, this);
	}
	
}
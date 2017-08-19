package org.talentboost.interpreter;

import org.talentboost.interpreter.variables.DateVar;
import org.talentboost.interpreter.variables.NumberVar;
import org.talentboost.interpreter.variables.StringVar;
import org.talentboost.interpreter.variables.Variable;

public class NumberVisitor implements Visitor{

	private String lhs;
	private String result;
	
	public NumberVisitor(Variable var) {
		this.lhs = var.getValue();
	}
	
	@Override
	public void visit(String op, NumberVar rhs) {
		if(op.equals("+")) {
			result = Integer.toString((Integer.parseInt(lhs) + Integer.parseInt(rhs.getValue())));
		} else if (op.equals("-")) {
			result = Integer.toString((Integer.parseInt(lhs) - Integer.parseInt(rhs.getValue())));
		} else if (op.equals("*")) {
			result = Integer.toString((Integer.parseInt(lhs) * Integer.parseInt(rhs.getValue())));
		} else {
			System.out.println("No such operation");
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void visit(String op, StringVar rhs) {
		System.out.println("No such operation");
		throw new IllegalArgumentException();
	}

	@Override
	public void visit(String op, DateVar rhs) {
		System.out.println("No such operation");
		throw new IllegalArgumentException();
	}

	@Override
	public String getResult() {
		return result;
	}

}

package org.talentboost.interpreter;

import java.time.LocalDate;

import org.talentboost.interpreter.variables.DateVar;
import org.talentboost.interpreter.variables.NumberVar;
import org.talentboost.interpreter.variables.StringVar;
import org.talentboost.interpreter.variables.Variable;

public class DateVisitor implements Visitor {

	private LocalDate lhs;
	private String result;
	
	public DateVisitor(Variable var) {
		this.lhs = LocalDate.parse(var.getValue());
	}
	
	@Override
	public void visit(String op, NumberVar rhs) {
		if(op.equals("+")) {
			result = lhs.plusDays(Integer.parseInt(rhs.getValue())).toString();
		} else if(op.equals("-")) {
			result = lhs.minusDays(Integer.parseInt(rhs.getValue())).toString();
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

package org.talentboost.interpreter;

import org.talentboost.interpreter.variables.Variable;

public class VisitorParser {
	public Visitor parse(Variable var) {
		Visitor visitor;
		switch(var.getType()) {
		case "number":
			visitor = new NumberVisitor(var);
			break;
		case "string":
			visitor = new StringVisitor(var);
			break;
		case "date":
			visitor = new DateVisitor(var);
			break;
		default:
			System.out.println("No such variable type");
			throw new IllegalArgumentException();
		}
		return visitor;
	}
}

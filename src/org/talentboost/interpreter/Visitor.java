package org.talentboost.interpreter;

import org.talentboost.interpreter.variables.DateVar;
import org.talentboost.interpreter.variables.NumberVar;
import org.talentboost.interpreter.variables.StringVar;

public interface Visitor {
	public void visit(String op, NumberVar rhs);
	public void visit(String op, StringVar rhs);
	public void visit(String op, DateVar rhs);
	public String getResult();
}

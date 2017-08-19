package org.talentboost.interpreter;

import java.sql.Date;

import org.talentboost.interpreter.variables.DateVar;
import org.talentboost.interpreter.variables.NumberVar;
import org.talentboost.interpreter.variables.StringVar;
import org.talentboost.interpreter.variables.Variable;

public final class Parser {
	public Variable parse(String[] input) throws IllegalArgumentException {
		if(input[1].equals("number")) {
			Variable var = new NumberVar(input[0], Integer.valueOf(input[2]));
			return var;
		} else if(input[1].equals("string")) {
			Variable var = new StringVar(input[0], input[2]);
			return var;
		} else if(input[1].equals("date")){
			Variable var = new DateVar(input[0], Date.valueOf(input[2]));
			return var;
		} else {
			throw new IllegalArgumentException();
		}
	}
}

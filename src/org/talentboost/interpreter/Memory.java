package org.talentboost.interpreter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.talentboost.interpreter.variables.Variable;

public final class Memory {
	private Map<String, Variable> variables = new HashMap<String, Variable>();
	
	public Variable find(String name) {
		return variables.get(name);
	}
	
	public void create(Variable var) throws AlreadyExistingVariableException {
		if(contains(var.getName())) {
			throw new AlreadyExistingVariableException();
		}
		variables.put(var.getName(), var);
	}
	
	public Boolean contains(String name) {
		return variables.containsKey(name);
	}
	
	public Collection<Variable> getVars() {
		return variables.values();
	}

}

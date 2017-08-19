package org.talentboost.interpreter.commands;

import org.talentboost.interpreter.Memory;
import org.talentboost.interpreter.Visitor;
import org.talentboost.interpreter.VisitorParser;
import org.talentboost.interpreter.variables.Variable;

public class CalcCmd implements Commands {

	private static final String CMD_NAME = "calc";
	private Memory memory;
	
	public CalcCmd(Memory memory) {
		this.memory = memory;
	} 
	
	@Override
	public String doProcess(String[] input) {
		Variable lhs = memory.find(input[1]);
		Variable rhs = memory.find(input[3]);
		String op = input[2];
		
		VisitorParser parser = new VisitorParser();
		Visitor visitor = parser.parse(lhs);
		rhs.accept(op, visitor);
		
		String res = visitor.getResult();
		
		if(!memory.contains(input[0])) {
			String type = lhs.getType();
			String[] resVar = {input[0], type, res};
			SetCmd set = new SetCmd(memory);
			set.doProcess(resVar);
		}
		
		return "OK";
	}

	@Override
	public int expectedArgCount() {
		return 4;
	}

	@Override
	public String cmdName() {
		return CMD_NAME;
	}

}

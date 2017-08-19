package org.talentboost.interpreter;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.talentboost.interpreter.commands.CalcCmd;
import org.talentboost.interpreter.commands.Commands;
import org.talentboost.interpreter.commands.CountWordsCmd;
import org.talentboost.interpreter.commands.GetCmd;
import org.talentboost.interpreter.commands.LoadCmd;
import org.talentboost.interpreter.commands.ReverseCmd;
import org.talentboost.interpreter.commands.ReverseWordsCmd;
import org.talentboost.interpreter.commands.SaveCmd;
import org.talentboost.interpreter.commands.SetCmd;

public class App {
	
	private static Memory mem = new Memory();
	private static final List<Commands> cmds = 
			Arrays.asList(new Commands[] { new ReverseCmd(), new GetCmd(mem), new SetCmd(mem), new CountWordsCmd(), 
					new LoadCmd(mem), new SaveCmd(mem), new ReverseWordsCmd(), new CalcCmd(mem)});
	private static final Map<String, Commands> cmdMap = mapGen();
	
	private static Map<String, Commands> mapGen() {
		final Map<String, Commands> commandMap = new HashMap<String, Commands>();
		
		for(Commands cmd : cmds) {
			commandMap.put(cmd.cmdName(), cmd);
		}
		
		return commandMap;
	}

	 public static void main(String[] args) {
		 InputStream instr = System.in;
		 Interpret interpreter = new Interpret(cmdMap);
		 interpreter.processStream(instr);
	 }
}

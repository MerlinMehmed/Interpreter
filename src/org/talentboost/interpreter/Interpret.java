package org.talentboost.interpreter;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

import org.talentboost.interpreter.commands.Commands;

public class Interpret {
	private final Map<String, Commands> cmdMap;
	
	public Interpret(Map<String, Commands> cmdMap){
		this.cmdMap = cmdMap;
	}
	
	public String process(String line) {
		try (Scanner linescan = new Scanner(line)){
			String command = linescan.next();
			String args = linescan.nextLine().trim();
			String[] cmdArgs = args.split(" ");
			
			Commands cmd = cmdMap.get(command);
			if (cmd != null) {
				String result = cmd.doProcess(cmdArgs);
				return result;
			} else {
				return "Unknown command " + cmd;
			}
		}
	}
	
	public void processStream (InputStream instr) {
		try(Scanner streamscan = new Scanner(instr)) {
			while(streamscan.hasNextLine()) {
				String line = streamscan.nextLine();
				System.out.println(process(line));
			}
		}
	}

}

package interpreter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommandList {	

	private static Map<String, String> commandList;
	
	/**
	 * getCommands will return a Set of the available commands.
	 * 
	 * 
	 * @return - A Set<String> of the available commands.
	 */
	public static Set<String> getCommands() {

		if(commandList == null) {
			commandList = buildCommandList0();
		}		
		
		return commandList.keySet();
	}

	/**
	 * This method returns a list of the available command descriptions.
	 * 
	 * @return A List<String> of the available command description.
	 */
	public static List<String> getCommandDescriptions(int option) {

		if (option == 0)
			commandList = buildCommandList0();	
		else if (option == 1)
			commandList = buildCommandList1();
		
		List<String> commands = new ArrayList<String>();

		for (String command : commandList.values()) {
			commands.add(command);
		}
		Collections.sort(commands);
		return commands;
	}

	private static Map<String, String> buildCommandList0() {

		Map<String, String> commandList = new HashMap<String, String>();

		commandList.put("e", "- (right arrow): moves player east.");
		commandList.put("w", "- (left arrow): moves player west.");
		commandList.put("u", "- (up arrow) moves player up.");
		commandList.put("s", "- (down arrow) moves player down.");
		commandList.put("shift", "- (shift): interact with object.");
		commandList.put("exit", "- quit: allows a player to exit the system.");
		commandList.put("commands", "- commands: lists all the commands useable by a player.");

		return commandList;		
	}
	
	private static Map<String, String> buildCommandList1() {
		
		Map<String, String> commandList = new HashMap<String, String>();
		
		commandList.put("commands", "- commands: lists all the commands useable by a player.");
		commandList.put("rock", "- rock: throws rock in game with Ruth");
		commandList.put("paper", "- paper: throws paper in game with Ruth");
		commandList.put("scissors", "- scissors: throws scissors in game with Ruth");

		return commandList;		
	}

}

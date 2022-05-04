package interpreter.command.impl;

import interpreter.CommandList;
import world.Player;

public class CommandCommands extends AbstractCommand {
	
	Player player;
	int _option;

	public CommandCommands(Player player, int option) {
		this.player = player;
		_option = option;		
	}

	@Override
	public void execute() {
		String result = "";
		for (String command : CommandList.getCommandDescriptions(_option)) {
			result += command + "\n";
		}
		player.sendToPlayer(result);
	}
}

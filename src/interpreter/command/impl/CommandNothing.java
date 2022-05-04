package interpreter.command.impl;

import world.Player;

public class CommandNothing extends AbstractCommand {

	Player player;
	String target;

	public CommandNothing() {

	}

	public CommandNothing(Player player) {
		this.player = player;
	}

	public CommandNothing(Player player, String target) {
		this.player = player;
		this.target = target;
	}

	@Override
	public void execute() {
		
		String message = player.getName() + ", please try a different word";
		
		player.sendToPlayer(message);			
	}

}

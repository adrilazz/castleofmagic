package interpreter;

import java.util.List;

import interpreter.command.Command;
import interpreter.command.impl.*;
import world.Player;

public class CommandInstantiator {
	
	public static Command instantiate(Player player, List<String> parsedCommandSequence) {
		
		Command command = new CommandNothing(player);
		
		String commandWord = parsedCommandSequence.get(0);

		if (player.getRoomId() == 732)
		{
			if (commandWord.equals("commands"))
				 command = new CommandCommands(player, 1);
			else if (commandWord.equals("rock"))
				command = new CommandRockPapperScissors(player, "rock");
			else if (commandWord.equals("paper"))
				command = new CommandRockPapperScissors(player, "paper");
			else if (commandWord.equals("scissors"))
				command = new CommandRockPapperScissors(player, "scissors");
		}
		//pls lamice be carefull with what you implement, what u did before was breaking the game
		else if (player.getRoomId() == -10) { //random room
			if (commandWord.equals("Madrid"))
				command = new CommandGuessTheCapital(player, "Madrid");
			else if (commandWord.equals("Paris"))
				command = new CommandGuessTheCapital(player, "Paris");
			else if (commandWord.equals("London"))
				command = new CommandGuessTheCapital(player, "London");
		}
		else {
			if (commandWord.equals("commands"))
				 command = new CommandCommands(player, 0);
			else if (commandWord.equals("n") || commandWord.equals("north"))
				command = new CommandMove(player, "n");
			else if (commandWord.equals("s") || commandWord.equals("south"))
				command = new CommandMove(player, "s");
			else if (commandWord.equals("e") || commandWord.equals("east"))
				command = new CommandMove(player, "e");
			else if (commandWord.equals("w") || commandWord.equals("west"))
				command = new CommandMove(player, "w");
			else if (commandWord.equals("u") || commandWord.equals("up"))
				command = new CommandMove(player, "u");
			else if (commandWord.equals("d") || commandWord.equals("down"))
				command = new CommandMove(player, "d");
			else if (commandWord.equals("1") || commandWord.equals("interact"))
				command = new CommandMove(player, "1");
		}
		return command;
	}
}

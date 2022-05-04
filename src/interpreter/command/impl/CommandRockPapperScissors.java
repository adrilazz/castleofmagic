package interpreter.command.impl;

import java.util.Random;

import world.Player;

public class CommandRockPapperScissors extends AbstractCommand{

	private  int _option; // 0 piedra, 1 papel, 2 tijera
	private Player _player;
	
	public CommandRockPapperScissors(Player player, String str)
	{
		if (str.contentEquals("rock"))
			_option = 0;
		else if (str.contentEquals("paper"))
			_option = 1;
		else if (str.contentEquals("scissors"))
			_option = 2;
		_player = player;
	}
	
	@Override
	public void execute() {
	}

	public String toString() {
		return "RPS";
	}
	
	public boolean run() {
		Random ran = new Random(); 
		int x = ran.nextInt(3);
		
		String ru = "scissors";
		
		if (x == 0)
			ru = "rock";
		else if (x == 1)
			ru = "paper";
		
		_player.sendToPlayer("");
		_player.sendToPlayer("Ruth chose " + ru);
		
		if ((x == 0 && _option == 1) || (x == 1 && _option == 2) || (x == 2 && _option == 0))
		{
			_player.sendToPlayer("You won!!");
			_player.sendToPlayer("");
			_player.sendToPlayer("Ruth: You shall pass.");
			return true;
		}
		
		_player.sendToPlayer("Try again");
		return false;
	}
}

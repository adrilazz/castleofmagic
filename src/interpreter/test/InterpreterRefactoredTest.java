package interpreter.test;

import interpreter.InterpreterRefactored;
import world.Player;

public class InterpreterRefactoredTest {

	public static void main(String[] args) {

		InterpreterRefactored interpreter = new InterpreterRefactored();
		
		Player player = new Player("Charlie");
		
		String textCommand = 
				//"say piss off";
				//"say";

				//"emote piss off";
				//"emote";

				//
				"commands";
		
		interpreter.processCommand(player, textCommand);
	}
}

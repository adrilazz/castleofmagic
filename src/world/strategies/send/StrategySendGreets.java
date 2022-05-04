package world.strategies.send;

import java.util.Scanner;

import world.Mobile;
import world.Room;
import world.World;
import world.strategies.StrategyReactToSend;

public class StrategySendGreets extends StrategyReactToSend {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3799964071795494047L;

	public StrategySendGreets() {

	}

	@Override
	public void reactToSend(String sent, Mobile mob) {
		
		Scanner sentStuff = new Scanner(sent);
		String aPlayer = sentStuff.next().trim();
		String nextWord = sentStuff.next().trim();
		if (nextWord.equalsIgnoreCase("enters")) {
			if (World.getInstance().playerExists(aPlayer)) {
				((Room) mob.getLocation()).sendToRoom(mob.getName()
						+ " waves to " + aPlayer + ".");
			}
		} else if (nextWord.equalsIgnoreCase("exits")){
			if (World.getInstance().playerExists(aPlayer)) {
				((Room) mob.getLocation()).sendToRoom(mob.getName()
						+ " waves goodbye to " + aPlayer + ".");
			}
		}
		
		sentStuff.close();
	}

	@Override
	public StrategyReactToSend cloneStrategy() {

		return new StrategySendGreets();
	}
}

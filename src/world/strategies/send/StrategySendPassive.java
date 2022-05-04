package world.strategies.send;

import java.util.Scanner;

import world.Mobile;
import world.Room;
import world.World;
import world.strategies.StrategyReactToSend;

public class StrategySendPassive extends StrategyReactToSend {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6093630352576037706L;

	public StrategySendPassive() {

	}

	@Override
	public void reactToSend(String sent, Mobile mob) {
		
		Scanner sentStuff = new Scanner(sent);
		String aPlayer = sentStuff.next().trim();
		if (sentStuff.next().trim().equalsIgnoreCase("enters")){
			if (World.getInstance().playerExists(aPlayer)
					&& World.getInstance().playerIsLoggedOn(aPlayer)) {
				((Room) mob.getLocation()).sendToRoom(mob.getName()
						+ " see's you, but doesn't appear to be threatening.");
			}
		}
		
		sentStuff.close();
	}

	@Override
	public StrategyReactToSend cloneStrategy() {

		return new StrategySendPassive();
	}
}

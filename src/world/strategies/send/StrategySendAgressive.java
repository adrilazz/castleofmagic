package world.strategies.send;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

import world.CombatManager;
import world.Mobile;
import world.Player;
import world.Room;
import world.World;
import world.strategies.StrategyReactToSend;

public class StrategySendAgressive extends StrategyReactToSend {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6275788458575929478L;
	private Mobile mySelf;
	private Player toAttack;

	public StrategySendAgressive() {

	}

	@Override
	public void reactToSend(String sent, Mobile mob) {
		
		Scanner sentStuff = new Scanner(sent);
		String aPlayer = sentStuff.next().trim();
		if (sentStuff.next().trim().equalsIgnoreCase("enters")) {
			if (World.getInstance().playerExists(aPlayer)
					&& World.getInstance().playerIsLoggedOn(aPlayer)) {

				mySelf = mob;
				Room room = (Room) World.getInstance().getDatabaseObject(
						mySelf.getRoomId());
				room.remove(mySelf.getName());
				room.add(mySelf);
				mySelf.setLocation(room);

				((Room) mySelf.getLocation()).refreshPlayers();
				((Room) mySelf.getLocation()).refreshMobiles();

				toAttack = World.getInstance().getPlayer(aPlayer);
				((Room) mob.getLocation()).sendToRoom(mob.getName()
						+ " moves into attack position..");
				Timer attackTimer = new Timer(10000, new AttackTimerListener());
				attackTimer.setRepeats(false);
				attackTimer.start();
			}
		}
		
		sentStuff.close();
	}

	private class AttackTimerListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			System.out.println(mySelf + " " + toAttack + " "
					+ mySelf.getRoomId() + " " + toAttack.getRoomId());
			if (mySelf == null || toAttack == null) {

			} else if (mySelf.getRoomId() == toAttack.getRoomId()) {
				CombatManager attackStart = new CombatManager(toAttack, mySelf);
			}
		}
	}

	@Override
	public StrategyReactToSend cloneStrategy() {

		return new StrategySendAgressive();
	}
}

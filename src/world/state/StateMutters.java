package world.state;

import java.util.Random;

import world.Direction;
import world.Mobile;
import world.Room;
import world.World;
import world.strategies.attack.StrategyAttackNoncombatant;
import world.strategies.roomchange.StrategyRoomChangeDefault;
import world.strategies.send.StrategySendGreets;

public class StateMutters extends StateGenericImpl implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -264938416479419232L;

	private String chatterText;
	private transient Thread thread;
	private Mobile mobile;

	public StateMutters() {

		 attack = new StrategyAttackNoncombatant();
		 send = new StrategySendGreets();
		 roomChange = new StrategyRoomChangeDefault();
	}

	public StateMutters(String chatterText) {
		this();
		this.chatterText = chatterText;
		this.thread = new Thread(this);
		this.thread.start();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new StateMutters();
	}

	/**
	 * This method sets the conversation text of the Mutter.
	 * 
	 * @param text
	 *            - The text the Mutter will send to others as conversation or
	 *            chatter.
	 */
	public void setChatterText(String chatterText) {
		this.chatterText = chatterText;
	}

	/**
	 * This method sets the mobile for the Mutter.
	 */
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	/**
	 * This run() method runs every 20 seconds and repeats the chatter text of
	 * the mutter to the room. It then leaves the room if its random number
	 * equals an exit that exits in the room.
	 */
	@Override
	public void run() {
		try {
			while (true) {

				synchronized (World.getInstance().getLockObject()) {
					while (World.getInstance().threadsLocked()) {
						try {
							World.getInstance().getLockObject().wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				if (this.mobile != null) {

					Room currentRoom = (Room) mobile.getLocation();
					if (currentRoom == null) {
						System.out.println("Mutter room not sent.");
					}

					((Room) mobile.getLocation()).sendToRoom(chatterText);

					boolean moved = false;
					while (!moved) {
						Random timeToMove = new Random();
						int moveNum = timeToMove.nextInt(4);

						switch (moveNum) {
						case 0:
							if (((Room) this.mobile.getLocation())
									.getExitDestination(Direction.NORTH) != null) {

								((Room) this.mobile.getLocation())
										.sendToRoom(this.mobile.getName()
												+ " exits North.");
								this.mobile.moveToRoom(((Room) this.mobile
										.getLocation())
										.getExitDestination(Direction.NORTH));
								((Room) this.mobile.getLocation())
										.sendToRoom(this.mobile.getName()
												+ " arrives from the South.");
								moved = true;
							}
							break;
						case 1:
							if (((Room) this.mobile.getLocation())
									.getExitDestination(Direction.SOUTH) != null) {

								((Room) this.mobile.getLocation())
										.sendToRoom(this.mobile.getName()
												+ " exits South.");
								this.mobile.moveToRoom(((Room) this.mobile
										.getLocation())
										.getExitDestination(Direction.SOUTH));
								((Room) this.mobile.getLocation())
										.sendToRoom(this.mobile.getName()
												+ " arrives from the North.");
								moved = true;
							}
							break;
						case 2:
							if (((Room) this.mobile.getLocation())
									.getExitDestination(Direction.EAST) != null) {

								((Room) this.mobile.getLocation())
										.sendToRoom(this.mobile.getName()
												+ " exits East.");
								this.mobile.moveToRoom(((Room) this.mobile
										.getLocation())
										.getExitDestination(Direction.EAST));
								((Room) this.mobile.getLocation())
										.sendToRoom(this.mobile.getName()
												+ " arrives from the West.");
								moved = true;
							}
							break;
						case 3:
							if (((Room) this.mobile.getLocation())
									.getExitDestination(Direction.WEST) != null) {

								((Room) this.mobile.getLocation())
										.sendToRoom(this.mobile.getName()
												+ " exits West.");
								this.mobile.moveToRoom(((Room) this.mobile
										.getLocation())
										.getExitDestination(Direction.WEST));
								((Room) this.mobile.getLocation())
										.sendToRoom(this.mobile.getName()
												+ " arrives from the East.");
								moved = true;
							}
							break;
						default:
							break;
						}
					}
				}
				Thread.sleep(20000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

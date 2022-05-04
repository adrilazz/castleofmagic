package world.state;

import world.Mobile;
import world.Room;
import world.World;
import world.strategies.attack.StrategyAttackNoncombatant;
import world.strategies.roomchange.StrategyRoomChangeDefault;
import world.strategies.send.StrategySendNothing;

public class StateDamian extends StateGenericImpl implements Runnable {

	private static final long serialVersionUID = -264938416479419232L;

	private String chatterText;
	private transient Thread thread;
	private Mobile mobile;

	public StateDamian() {

		 attack = new StrategyAttackNoncombatant();
		 send = new StrategySendNothing();
		 roomChange = new StrategyRoomChangeDefault();
	}

	public StateDamian(String chatterText) {
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
	 * READ ME !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * This run() method implements the behavior of the NPC
	 * 
	 * In this case, for Damian, if there is a player in the room 
	 * it starts a conversation.
	 * 
	 */
	@Override
	public void run() {
		while (true) {
			try {
				synchronized (World.getInstance().getLockObject()) {
					while (World.getInstance().threadsLocked()) {
						try {
							World.getInstance().getLockObject().wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				while (!((Room) mobile.getLocation()).isPlayerInRoom()){
					Thread.sleep(1000); 
				}
	
				((Room) mobile.getLocation()).sendToRoom("");
				((Room) mobile.getLocation()).sendToRoom("Damian: Hey! Someone help me! Please!");
				Thread.sleep(2000); 
				((Room) mobile.getLocation()).sendToRoom("You: Hello? Who are you? What's going on?");
				Thread.sleep(2000); 
				((Room) mobile.getLocation()).sendToRoom("Damian: Oh! Please! Listen to me! My little daughter Wendy has been kidnaped, I need your help!!");
				Thread.sleep(3000); 
				((Room) mobile.getLocation()).sendToRoom("You: Wendy... Could it be...?");
				Thread.sleep(3000); 
				((Room) mobile.getLocation()).sendToRoom("Damian: Hurry up! But first find a way to get out of this forest...");
				
				while (((Room) mobile.getLocation()).isPlayerInRoom()){
					Thread.sleep(1000); 
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}

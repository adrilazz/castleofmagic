package world.state;

import java.io.Serializable;

import world.Mobile;
import world.Movable;

public  abstract class State4Mobile implements Serializable  {

	public State4Mobile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * attackBehavior will be used for aggressive MOB's.  If a player enters a room this class
	 * will be called to determine if the MOB will attack the player or not.
	 * 
	 * @param me The MOB using the strategy
	 * @param enemy The potential enemy
	 */
	public abstract void attackBehavior(Mobile me, Movable enemy);
	
	/**
	 * reactToSend will be used whenever a player enters the room a mobile is currently in. If
	 * the aggressive calls for the MOB to attack, it will tell the player he/she is about to be
	 * attacked. If the strategy is set up to simply greet the MOB will greet.
	 * 
	 * @param sent The player name will be used from the string sent
	 * @param mob The MOB sending the text to the player
	 */
	public abstract void reactToSend(String sent, Mobile mob);

	/**
	 * onRoomChange is used for MOB's who move around in the world. Some MOB's will not move and
	 * stay stationary. This will method will be used for when a MOB moves to a room, and based
	 * on there strategy will either attack a human player, say something, etc.
	 */
	public abstract void onRoomChange();
	
	public abstract State4Mobile cloneState4Mobile();

}

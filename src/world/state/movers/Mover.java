package world.state.movers;

import world.Mobile;
import world.Room;
import world.World;
import world.state.State4Mobile;
import world.state.StateGenericImpl;
import world.strategies.attack.StrategyAttackNoncombatant;
import world.strategies.roomchange.StrategyRoomChangeDefault;
import world.strategies.send.StrategySendNothing;

public abstract class Mover extends StateGenericImpl implements Runnable {

	private static final long serialVersionUID = -264938416479419232L;

	private transient Thread thread;
	protected Mobile mobile;

	public Mover() {
		attack = new StrategyAttackNoncombatant();
		send = new StrategySendNothing();
		roomChange = new StrategyRoomChangeDefault();
		this.thread = new Thread(this);
		this.thread.start();
	}

	@Override
	public State4Mobile cloneState4Mobile() {
		return null;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	@Override
	public void run() {
	}		
}

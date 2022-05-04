package world.state;

import world.Mobile;
import world.Movable;
import world.strategies.StrategyAttackBehaviour;
import world.strategies.StrategyOnRoomChange;
import world.strategies.StrategyReactToSend;

public class StateGenericImpl extends State4Mobile {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7554048009829308018L;
	
	protected StrategyAttackBehaviour attack;
	protected StrategyReactToSend send;
	protected StrategyOnRoomChange roomChange;

	public StateGenericImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attackBehavior(Mobile me, Movable enemy) {
		attack.attackBehavior(me, enemy);
	}

	@Override
	public void reactToSend(String sent, Mobile mob) {
		send.reactToSend(sent, mob);
	}

	@Override
	public void onRoomChange() {
		roomChange.onRoomChange();
	}

	@Override
	public State4Mobile cloneState4Mobile() {
		// TODO Auto-generated method stub
		return null;
	}
}

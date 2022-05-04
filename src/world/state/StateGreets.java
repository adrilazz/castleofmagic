package world.state;

import world.strategies.attack.StrategyAttackNoncombatant;
import world.strategies.roomchange.StrategyRoomChangeDefault;
import world.strategies.send.StrategySendGreets;

public class StateGreets extends StateGenericImpl {
	
	private static final long serialVersionUID = 3039773453796280139L;
		
	public StateGreets() {

		 attack = new StrategyAttackNoncombatant();
		 send = new StrategySendGreets();
		 roomChange = new StrategyRoomChangeDefault();
	}


	@Override
	public State4Mobile cloneState4Mobile() {

		return new StateGreets();
	}
}

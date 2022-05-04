package world.state;

import world.strategies.attack.StrategyAttackCombatant;
import world.strategies.roomchange.StrategyRoomChangeDefault;
import world.strategies.send.StrategySendAgressive;

public class StateAgressive extends StateGenericImpl {
	
	private static final long serialVersionUID = 3039773453796280139L;
	
	public StateAgressive() {

		 attack = new StrategyAttackCombatant();
		 send = new StrategySendAgressive();
		 roomChange = new StrategyRoomChangeDefault();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new StateAgressive();
	}
}

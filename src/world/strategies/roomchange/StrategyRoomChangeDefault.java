package world.strategies.roomchange;

import world.strategies.StrategyOnRoomChange;

public class StrategyRoomChangeDefault extends StrategyOnRoomChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4223487205991004710L;

	public StrategyRoomChangeDefault() {
		
	}

	@Override
	public void onRoomChange() {

		// Does nothing when it changes rooms. Shouldn't be changing rooms
		// anyway.
	}

	@Override
	public StrategyOnRoomChange cloneStrategy() {

		return new StrategyRoomChangeDefault();
	}
}

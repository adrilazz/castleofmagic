package world.strategies.roomchange;

import world.Mobile;
import world.strategies.StrategyOnRoomChange;

public class StrategyRoomChangeMutters extends StrategyOnRoomChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7881841340116322477L;
	private Mobile mobile;

	public StrategyRoomChangeMutters() {
		
	}

	public StrategyRoomChangeMutters(Mobile mob) {
	
		mobile = mob;		
	}

	@Override
	public void onRoomChange() {

		// TODO not impplemented yet.
		//System.out.println(this.mobile.getName() + " changes room.");
	}

	@Override
	public StrategyOnRoomChange cloneStrategy() {

		return new StrategyRoomChangeMutters();
	}
}

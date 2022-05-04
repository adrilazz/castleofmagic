package world.strategies;

import java.io.Serializable;

public abstract class StrategyOnRoomChange implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3341084937280815904L;

	public abstract void onRoomChange();

	public abstract StrategyOnRoomChange cloneStrategy();
}

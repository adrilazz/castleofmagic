package world.strategies;

import java.io.Serializable;

import world.Mobile;

public abstract class StrategyReactToSend   implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1486999206981070030L;

	public abstract void reactToSend(String sent, Mobile mob);

	public abstract StrategyReactToSend cloneStrategy();
}

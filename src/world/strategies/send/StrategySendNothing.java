package world.strategies.send;

import world.Mobile;
import world.strategies.StrategyReactToSend;

public class StrategySendNothing extends StrategyReactToSend {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4551994157900109129L;

	public StrategySendNothing() {

	}

	@Override
	public void reactToSend(String sent, Mobile mob) {
		
	}

	@Override
	public StrategyReactToSend cloneStrategy() {

		return new StrategySendNothing();
	}
}

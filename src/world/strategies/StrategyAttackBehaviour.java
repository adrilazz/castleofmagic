package world.strategies;

import java.io.Serializable;

import world.Mobile;
import world.Movable;

public abstract class StrategyAttackBehaviour  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7531598655067542151L;

	public abstract void attackBehavior(Mobile me, Movable enemy);
	
	public abstract StrategyAttackBehaviour cloneStrategy();
}

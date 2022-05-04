package world.strategies.attack;

import world.Mobile;
import world.Movable;
import world.strategies.StrategyAttackBehaviour;

public class StrategyAttackCombatant extends StrategyAttackBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5046414840820367896L;

	public StrategyAttackCombatant() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attackBehavior(Mobile me, Movable enemy) {

		me.resolveAttack(enemy);
	}

	@Override
	public StrategyAttackBehaviour cloneStrategy() {
		return new StrategyAttackCombatant();
	}
}

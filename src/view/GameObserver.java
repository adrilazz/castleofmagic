package view;

import model.CombatCommand;

public interface GameObserver {

	public void combat(CombatCommand combatCommand);
	public void image(String id);
	public void deleteButton();
}

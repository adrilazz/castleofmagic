package interpreter.command.impl;

import interpreter.command.Command;
import world.World;

public abstract class AbstractCommand implements Command {
	
	World world;

	public AbstractCommand() {
		world = World.getInstance();
	}

	@Override
	public abstract void execute();
	
	public boolean run() {
		return false;
	}
}
package interpreter.command;

public interface Command {
	
	public void execute();
	public String toString();
	public boolean run();
}

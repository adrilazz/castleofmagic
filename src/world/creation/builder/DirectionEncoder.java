package world.creation.builder;

import world.Direction;

public class DirectionEncoder {
	
	public static Direction convertDirection(String direction) {

		Direction dir = null;
		
		if (direction.equals("north") || direction.equals("n")) {
			dir = Direction.NORTH;
		} 
		else if (direction.equals("south") || direction.equals("s")) {
			dir = Direction.SOUTH;
		} 
		else if (direction.equals("east") || direction.equals("e")) {
			dir = Direction.EAST;
		} 
		else if (direction.equals("west") || direction.equals("w")) {
			dir = Direction.WEST;
		} 
		else if (direction.equals("up") || direction.equals("u")) {
			dir = Direction.UP;
		} 
		else if (direction.equals("down") || direction.equals("d")) {
			dir = Direction.DOWN;
		} 
		else if (direction.equals("1") || direction.equals("iteract")) {
			dir = Direction.INTERACT;
		}

		return dir;		
	}
}

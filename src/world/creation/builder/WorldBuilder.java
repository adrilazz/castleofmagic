package world.creation.builder;

import world.World;

public interface WorldBuilder {
	
	public World getWorld();
	
	public void buildRoom(String id, String name, String description);

	public void buildExit(String roomFrom, String whichWay, String roomTo);
	
	public void nestRooms(String outerRoom, String roomWithin);
	
	public void addGear(String where, Object gear);

	public void addMobile(String where, Object mobile);

	public void addStatToMobile(String name, String trait, int value);
	
	public void populateWith(String howMany, Object mobile);
	
	public void populate();
}

package world.location;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import world.DatabaseObject;
import world.Room;

public abstract class LocationAbstractCompiler implements LocationComp {

	protected List<Location> locations;

	public LocationAbstractCompiler() {
		// TODO Auto-generated constructor stub
	}
	
	public Location findLocation4room(Room room) {
		
		boolean found = false;
		
		Location correspondingLocation = null;
		
		Iterator<Location> it = locations.iterator();
		
		while(it.hasNext() && !found) {
			Location loc = it.next();
			found = loc.getName().equalsIgnoreCase(room.getName());
			if(found) {
				correspondingLocation = loc;
			}			
		}
		
		return correspondingLocation;		
	}
	
	public abstract Location compileWorld(List<DatabaseObject> databaseArray);

	public abstract Location compileWorld(Map<String, Room> roomSet);

}

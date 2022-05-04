package world.adapter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import world.DatabaseObject;
import world.Room;
import world.location.Location;
import world.location.LocationAbstractCompiler;

public class LocationCompiler extends LocationAbstractCompiler {
	
	public LocationCompiler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Location compileWorld( List<DatabaseObject> databaseArray) {
		
		locations = new LinkedList<Location>();		
		
		for(DatabaseObject dbo : databaseArray) {
			
			if(dbo instanceof Room) {

				Room room = (Room)dbo;
				
				List<Room> roomsNested = room.listRooms();
				
				for(Room nested : roomsNested) {

					Location correspondingLocation = this.findLocation4room(nested);
					locations.remove(correspondingLocation);
				}
				
				Location loc4room = new LocationAdapter(room);
				locations.add(loc4room);	
			}				
		}
		
		return locations.get(0);
	}

	@Override
	public Location compileWorld(Map<String,Room> roomSet) {
		
		locations = new LinkedList<Location>();		
		
		for(String key : roomSet.keySet()) {
			
			Room room = roomSet.get(key);
			
			List<Room> roomsNested = room.listRooms();
			
			for(Room nested : roomsNested) {

				Location correspondingLocation = this.findLocation4room(nested);
				locations.remove(correspondingLocation);
			}
			
			Location loc4room = new LocationAdapter(room);
			locations.add(loc4room);					
		}
		
		return locations.get(0);
	}
}

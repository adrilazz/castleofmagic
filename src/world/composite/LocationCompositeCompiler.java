package world.composite;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import world.DatabaseObject;
import world.Room;
import world.location.Location;
import world.location.LocationAbstractCompiler;

public class LocationCompositeCompiler  extends LocationAbstractCompiler{
	
	public LocationCompositeCompiler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Location compileWorld(List<DatabaseObject> databaseArray) {		

		List<Room> compRooms = this.convertToRoomList(databaseArray);
		
		return this.compileLocation4World(compRooms);		
	}

	@Override
	public Location compileWorld(Map<String,Room> roomSet) {		

		List<Room> compRooms = this.convertToRoomList(roomSet);
		
		return this.compileLocation4World(compRooms);		
	}	
	
	public Location compileLocation4World(List<Room> rooms) {

		locations = new LinkedList<Location>();		
		
		for(Room room : this.getLeafRooms(rooms)) {

			Location loc4room = new LocationLeaf(room);
			locations.add(loc4room);				
		}
		
		for(Room room : this.getCompositeRooms(rooms)) {

			Location loc = this.buildLocation4CompositeRoom(room);
			locations.add(loc);		
		}
		
		return locations.get(1);
		
	}


	public List<Room> getLeafRooms(List<Room> roomSet){

		List<Room> leafRooms = new LinkedList<Room>();		

		for(Room room : roomSet) {
			
			if(room.listRooms().isEmpty()) {
				leafRooms.add(room);
			}
		}
		
		return leafRooms;
	}
	
	public List<Room> getCompositeRooms(List<Room> roomSet){

		List<Room> compRooms = new LinkedList<Room>();		

		for(Room room : roomSet) {

			if(!room.listRooms().isEmpty()) {
				compRooms.add(room);
			}
		}
		
		return compRooms;
	}
	
	public List<Room> convertToRoomList(List<DatabaseObject> databaseArray){

		List<Room> compRooms = new LinkedList<Room>();		

		for(DatabaseObject dbo : databaseArray) {

			if(dbo instanceof Room) {

				Room room = (Room)dbo;
				compRooms.add(room);
			}
		}
		
		return compRooms;		
	}

	public List<Room> convertToRoomList(Map<String,Room> roomSet){

		List<Room> compRooms = new LinkedList<Room>();		

		for(String key : roomSet.keySet()) {
			
			Room room = roomSet.get(key);
			compRooms.add(room);
		}
		
		return compRooms;		
	}
	
	public Location buildLocation4CompositeRoom(Room room) {

		List<Room> roomsNested = room.listRooms();	

		Location loc4room = new LocationComposite(room);

		for(Room nested : roomsNested) {

			Location correspondingLocation = this.findLocation4room(nested);
			
			if(correspondingLocation != null) {
				loc4room.add(correspondingLocation);
				locations.remove(correspondingLocation);
			}
			else {
				Location loc = this.buildLocation4CompositeRoom(nested);
				loc4room.add(loc);				
			}
		}
		
		return loc4room;
	}
}

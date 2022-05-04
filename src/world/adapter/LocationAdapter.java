package world.adapter;

import java.util.LinkedList;
import java.util.List;

import world.Room;
import world.location.Location;
import world.visitor.LocationVisitor;

public class LocationAdapter implements Location {
	
	Room room;

	public LocationAdapter() {

	}

	public LocationAdapter(Room r) {

		room = r;
	}

	@Override
	public String getName() {
		return room.getName();
	}
	
	public Room getRoom() {
		return room;
	}

	@Override
	public void add(Location loc) {
		
		Room room2add = ((LocationAdapter)loc).getRoom();

		room.add(room2add);		
	}

	@Override
	public void remove(Location loc) {
		
		Room room2remove = ((LocationAdapter)loc).getRoom();
		
		room.listRooms().remove(room2remove);		
	}

	@Override
	public Location getChild(int which) {
		
		Room roomRequested = room.listRooms().get(which);

		return new LocationAdapter(roomRequested);
	}
	
	@Override
	public String provideDescription() {

		return room.generateDescription();
	}
	
	@Override
	public List<Location> getChildren() {
		
		List<Location> locations = new LinkedList<Location>();		
		
		for(Room roomRequested : room.listRooms()) {
			locations.add(new LocationAdapter(roomRequested));
		}
		
		return locations;
	}

	public String toString() {
		
		StringBuffer out = new StringBuffer();
		
		out.append(this.getName());

		out.append(" [");
		
		for(Location nested : this.getChildren()) {

			out.append(nested.getName());
			out.append(" ");
		}

		out.append("]\n");

		for(Location nested : this.getChildren()) {

			out.append(nested.toString());
		}
		
		return out.toString();
	}

	@Override
	public void accept(LocationVisitor vis) {
		// TODO Auto-generated method stub
		
	}
}

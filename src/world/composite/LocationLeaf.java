package world.composite;

import java.util.List;

import world.Room;
import world.location.Location;
import world.visitor.LocationVisitor;

public class LocationLeaf implements Location {

	Room room;

	public LocationLeaf() {

	}

	public LocationLeaf(Room r) {

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
	public String provideDescription() {

		return room.generateDescription();
	}

	@Override
	public void accept(LocationVisitor vis) {
		vis.visit(this);				
	}

	public String toString() {
		
		StringBuffer out = new StringBuffer();

		out.append("ACTUAL-ROOM: ");
		out.append(this.getName());			
		out.append("\n");
		
		return out.toString();
	}
	
	//  from here down, methods only used for the composite nodes!

	@Override
	public void add(Location loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Location loc) {
		// TODO Auto-generated method stub

	}

	@Override
	public Location getChild(int which) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Location> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}
}

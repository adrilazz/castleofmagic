package world.composite;

import java.util.LinkedList;
import java.util.List;

import world.Room;
import world.location.Location;
import world.visitor.LocationVisitor;

public class LocationComposite implements Location {

	Room room;
	List<Location> nestedLocations;

	public LocationComposite() {
		
		nestedLocations = new LinkedList<Location>();		
	}

	public LocationComposite(Room r) {
		
		this();

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
		nestedLocations.add(loc);
	}

	@Override
	public void remove(Location loc) {		
		nestedLocations.remove(loc);		
	}

	@Override
	public Location getChild(int which) {

		return nestedLocations.get(which);
	}
	
	@Override
	public String provideDescription() {

		return room.generateDescription();
	}
	
	@Override
	public List<Location> getChildren() {
		
		return nestedLocations;
	}

	@Override
	public void accept(LocationVisitor vis) {
		vis.visit(this);		

		for(Location nestedLoc : this.getChildren()) {
			nestedLoc.accept(vis);
		}
	}

	public String toString() {
		
		StringBuffer out = new StringBuffer();

		out.append("\n");
		out.append(this.getName());

		out.append("\n\t[\n");
		
		for(Location nested : this.getChildren()) {

			out.append("\t\t");
			out.append(nested.getName());
			out.append("\n");
		}

		out.append("]\n");

		for(Location nested : this.getChildren()) {

			out.append(nested.toString());
		}
		
		return out.toString();
	}
}

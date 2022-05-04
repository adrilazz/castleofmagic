package world.visitor.inventory;

import java.util.List;

import world.Gear;
import world.Movable;
import world.Room;
import world.composite.LocationComposite;
import world.composite.LocationLeaf;
import world.visitor.LocationVisitor;

public class LocationInventoryVisitor implements LocationVisitor {	

	StringBuffer out;

	public LocationInventoryVisitor() {
		out = new StringBuffer();
	}

	@Override
	public void visit(LocationLeaf loc) {
		
		Room room = loc.getRoom();
		List<Gear> what = room.listGear();
		
		if(!what.isEmpty()) {

			out.append(loc.getName());
			out.append("\n");
			
			for(Gear mov : what) {

				out.append("\t");
				out.append(mov.getName());
				out.append("\n");
			}
		}
	}

	@Override
	public void visit(LocationComposite loc) {
		
	}
	
	public String getPrintOut() {
		return out.toString();
	}
}

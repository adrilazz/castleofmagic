package world.visitor.census;

import java.util.List;

import world.Movable;
import world.Room;
import world.composite.LocationComposite;
import world.composite.LocationLeaf;
import world.visitor.LocationVisitor;

public class LocationCensusVisitor implements LocationVisitor {	

	StringBuffer out;

	public LocationCensusVisitor() {
		out = new StringBuffer();
	}

	@Override
	public void visit(LocationLeaf loc) {
		
		Room room = loc.getRoom();
		List<Movable> who = room.listMovables();

		
		if(!who.isEmpty()) {

			out.append(loc.getName());
			out.append("[");
			
			for(Movable mov : who) {

				out.append(mov.getName());
				out.append(" / ");
			}

			out.append("]");
			out.append("\n");
		}
	}

	@Override
	public void visit(LocationComposite loc) {
		
	}
	
	public String getPrintOut() {
		return out.toString();
	}
}

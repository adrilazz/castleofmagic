package world.visitor;

import world.composite.LocationComposite;
import world.composite.LocationLeaf;

public interface LocationVisitor {
	
	public void visit(LocationLeaf loc);
	public void visit(LocationComposite loc);

}

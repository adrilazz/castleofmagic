package world.creation.factorymethod;

import world.Mobile;
import world.state.State4Mobile;

public class MobileFactoryImpl implements MobileFactory {
	
	public MobileFactoryImpl() {
		
	}
	
	
	/**
	 * createMobile is called when the MUD world is created. It will take in a
	 * string for a name, string as a description, a starting room and a
	 * strategy for that specific MOB. If the MOB already exists it return null.
	 * If it doesn't exist it will create a new MOB, add it to the current
	 * world, set the strategy, and set the location.
	 * 
	 * @param name
	 *            The name for the MOB
	 * @param description
	 *            The description for the MOB
	 * @param strategy
	 *            The strategy for the specific MOB
	 * 
	 * @return The created MOB, or null if duplicate
	 */
	public Mobile createMobile(String name, String description, 
			String whichState, String message4strategy) {
		
		Mobile temp = new Mobile(name);
		
		State4Mobile specificState = StateEncoder.buildState(whichState, message4strategy, temp);		

		temp.setState(specificState);
		temp.setDescription(description);
		
		return temp;
	}
}

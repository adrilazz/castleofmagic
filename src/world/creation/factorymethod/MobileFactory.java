package world.creation.factorymethod;

import world.Mobile;

public interface MobileFactory {
	
	public Mobile createMobile(String name, String description, 
			String whichStrategy, String message4strategy);

}
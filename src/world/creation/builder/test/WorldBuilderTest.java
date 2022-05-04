package world.creation.builder.test;

import world.Armor;
import world.Mobile;
import world.Weapon;
import world.creation.builder.WorldBuilder;
import world.creation.builder.WorldBuilderImpl;
import world.creation.factorymethod.ElementFactory;
import world.creation.factorymethod.ElementFactoryImpl;
import world.creation.factorymethod.MobileFactory;
import world.creation.factorymethod.MobileFactoryImpl;

public class WorldBuilderTest {

	public static void main(String[] args) {
		
		//
		//   Running this class should show message in the console
		//     indicating that the corresponding elements
		//     have been created in the World
		//
		
		WorldBuilder builder = new WorldBuilderImpl();
		
		String idClassroom = "ID0";
		
		builder.buildRoom(idClassroom, "ClassRoom", "A classroom.");

		String idCorridor = "ID1";

		builder.buildRoom(idCorridor, "Corridor", "A corridor.");
		
		builder.buildExit(idClassroom, "n", idCorridor);	
		
		String idFac = "IDFac";
		
		builder.buildRoom(idFac, "Faculty", "A faculty.");
		
		builder.nestRooms(idFac, idClassroom);
		builder.nestRooms(idFac, idCorridor);
		
		//
		
		ElementFactory elementFactory = new ElementFactoryImpl();
		
		Weapon weapon = elementFactory.buildWeapon("Chalk", "A writing implement", 1, 3);		
		
		builder.addGear(idClassroom, weapon);
		

		Armor armor = elementFactory.buildArmor("LabCoat", "A white garment.", 1, 'H');		
		
		builder.addGear(idClassroom, armor);
		
		// 
		
		MobileFactory mobileFactory = new MobileFactoryImpl();
		
		Mobile lecturer = mobileFactory.createMobile("Joe", "Software Engineering lecturer.", "G", "");
		
		builder.addMobile(idClassroom, lecturer);
		
	}
}

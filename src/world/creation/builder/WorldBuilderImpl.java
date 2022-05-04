package world.creation.builder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import world.Direction;
import world.Gear;
import world.GearContainer;
import world.Mobile;
import world.Room;
import world.Trait;
import world.World;
import world.composite.LocationCompositeCompiler;
import world.location.Location;
import world.location.LocationComp;

public class WorldBuilderImpl implements WorldBuilder {
	
	World worldBeingBuilt;
	
	Map<String,Room> roomSet;
	Map<String,GearContainer> gearContainerSet;
	Map<String,Mobile> mobileSet;

	Map<String,Mobile> mobilePopulators;
	
	Random picker;

	public WorldBuilderImpl() {
		roomSet = new HashMap<String,Room>();
		gearContainerSet = new HashMap<String,GearContainer>();
		mobileSet = new HashMap<String,Mobile>();
		
		mobilePopulators = new HashMap<String,Mobile>();
		
		worldBeingBuilt = World.getInstance();
		
		picker = new Random(System.currentTimeMillis());
	}
	
	@Override
	public World getWorld() {
		
		LocationComp compiler = new LocationCompositeCompiler();
		
		Location worldComposite = compiler.compileWorld(roomSet);
		
		worldBeingBuilt.setWorldEntity(worldComposite);
		
		return worldBeingBuilt;
	}

	@Override
	public void buildRoom(String id, String name, String description) {
		Room room = new Room(name, id);
		room.setDescription(description);
		roomSet.put(id, room);
		//
		worldBeingBuilt.addToWorld(room);
	}

	@Override
	public void buildExit(String roomFrom, String whichWay, String roomTo) {

		Room room1 = roomSet.get(roomFrom);
		Room room2 = roomSet.get(roomTo);

		Direction dir = DirectionEncoder.convertDirection(whichWay);
		
		room1.setExitDestination(dir, room2);
	}

	@Override
	public void nestRooms(String outerRoom, String roomWithin) {
		
		Room room1 = roomSet.get(outerRoom);
		Room room2 = roomSet.get(roomWithin);
		room1.add(room2);		
	}

	@Override
	public void addGear(String where, Object gear) {

		Room room = roomSet.get(where);
		
		if(room != null) {

			room.add((Gear)gear);
			if(gear instanceof GearContainer) {
				GearContainer container = (GearContainer)gear;
				gearContainerSet.put(container.getName(), container);
			}
		}
		else {
			GearContainer container = gearContainerSet.get(where);
			if(container != null) {
				container.addGear((Gear)gear);				
			}
			else {
				Mobile mobile = mobileSet.get(where);
				if(mobile != null) {
					mobile.addGear((Gear)gear);				
				}
				else {
					
				}				
			}			
		}	
	}

	@Override
	public void addMobile(String where, Object mobile) {

		Room room = roomSet.get(where);
		
		if(room != null) {

			if(mobile instanceof Mobile) {
				Mobile mobileRep = (Mobile)mobile;
				mobileSet.put(mobileRep.getName(), mobileRep);

				//System.out.println(mobileRep.getName() + " created, now adding to room.");

				mobileRep.setLocation(room);
				mobileRep.moveToRoom(room);
				mobileRep.setStart(room);

				// happens within moveToRoom()
				//room.add(mobileRep);	

				//
				worldBeingBuilt.createMobile(mobileRep);
			}
		}		
	}

	@Override
	public void addStatToMobile(String name, String trait, int value) {

		Mobile mobileRep = mobileSet.get(name);

		Trait thisOne = this.identifyTrait(trait);
		
		mobileRep.setStat(value,thisOne);
	}
	
	private Trait identifyTrait(String trait) {
		
		Trait thisOne = null;
		
		if(trait.equalsIgnoreCase("agility")) {
			 thisOne = Trait.AGILITY;			
		}

		if(trait.equalsIgnoreCase("agility")) {
			 thisOne = Trait.AGILITY;			
		}

		if(trait.equalsIgnoreCase("agility")) {
			 thisOne = Trait.AGILITY;			
		}

		if(trait.equalsIgnoreCase("STRENGTH")) {
			 thisOne = Trait.STRENGTH;			
		}

		if(trait.equalsIgnoreCase("TOUGHNESS")) {
			 thisOne = Trait.TOUGHNESS;			
		}

		if(trait.equalsIgnoreCase("INTELLECT")) {
			 thisOne = Trait.INTELLECT;			
		}

		if(trait.equalsIgnoreCase("HITPOINTS")) {
			 thisOne = Trait.HITPOINTS;			
		}

		if(trait.equalsIgnoreCase("MAXHITPOINTS")) {
			 thisOne = Trait.MAXHITPOINTS;			
		}

		if(trait.equalsIgnoreCase("TECHNIQUE")) {
			 thisOne = Trait.TECHNIQUE;			
		}

		if(trait.equalsIgnoreCase("MAXTECHNIQUE")) {
			 thisOne = Trait.MAXTECHNIQUE;			
		}
		
		return thisOne;		
	}

	@Override
	public void populateWith(String howMany, Object mobile) {
		
		mobilePopulators.put(howMany, (Mobile)mobile);		
	}
	
	private String getRoomAtRandom() {
		
		List<String> listOfRoomTags = new LinkedList<String>(roomSet.keySet());
		
		int choice = picker.nextInt(listOfRoomTags.size());
		
		return listOfRoomTags.get(choice);
	}

	@Override
	public void populate() {
		
		for(String key : mobilePopulators.keySet()) {

			String howMany = key.substring(6);
			int number = Integer.parseInt(howMany);
			
			Mobile prototype = mobilePopulators.get(key);
			
			for(int n = 0; n < number; n++) {
				
				String whichRoom = this.getRoomAtRandom();				

				Mobile prototypeClone = prototype.clone();
				
				prototypeClone.setName(prototype.getName()+n);
				
				this.addMobile(whichRoom, prototypeClone);				
			}			
		}		
	}
}


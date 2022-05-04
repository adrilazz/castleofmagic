package world.creation.factorymethod;

import world.Armor;
import world.GearContainer;
import world.HealthOrb;
import world.Weapon;

public class ElementFactoryImpl implements ElementFactory {
	
	public ElementFactoryImpl() {
		
	}

	public Weapon buildWeapon(String name, String description, int level, int damage) {

		return new Weapon(name,	description, level, damage);
	}

	public GearContainer buildGearContainer(String name, String description, int maxSize, boolean canCarry) {

		return  new GearContainer(name,	description, maxSize, canCarry);
	}

	public Armor buildArmor(String name, String description, int level, char typeChar) {
		return new Armor(name,	description, level, typeChar);
	}

	public HealthOrb buildHealthOrb(String name, String description, int healthPoints) {
		return new HealthOrb(name,	description, healthPoints);	
	}
}

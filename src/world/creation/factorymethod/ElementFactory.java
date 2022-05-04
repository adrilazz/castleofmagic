package world.creation.factorymethod;

import world.Armor;
import world.GearContainer;
import world.HealthOrb;
import world.Weapon;

public interface ElementFactory {

	public Weapon buildWeapon(String name, String description, int level, int damage);

	public GearContainer buildGearContainer(String name, String description, int maxSize, boolean canCarry);

	public Armor buildArmor(String name, String description, int level, char typeChar);

	public HealthOrb buildHealthOrb(String name, String description, int healthPoints);

}
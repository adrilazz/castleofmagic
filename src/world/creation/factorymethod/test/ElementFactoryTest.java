package world.creation.factorymethod.test;

import world.Weapon;
import world.creation.factorymethod.ElementFactory;
import world.creation.factorymethod.ElementFactoryImpl;

public class ElementFactoryTest {

	public static void main(String[] args) {
		
		ElementFactory factory = new ElementFactoryImpl();
		
		String name = "Laser Pistol";
		String description = "A clunky old laser pistol; reliable, but ugly.";
		int level = 1;
		int damage = 3;
		
		Weapon weapon1 = factory.buildWeapon(name, description, level, damage);
		
		System.out.println(weapon1.getName());
		System.out.println(weapon1.getDescription());
		System.out.println(weapon1.getItemLevel());
		System.out.println(weapon1.getDamage());
	}
}

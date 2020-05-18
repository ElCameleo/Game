package item.weapon;

import item.Item;

public class Weapon extends Item {
	
	private float attack;

	public Weapon(String name, float attack) {
		super(name);
		this.attack = attack;
	}

}

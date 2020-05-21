package item.weapon;

import item.Item;

public class Weapon extends Item {
	
	private float attack;
	private int durability;
	public Weapon(String name, float attack, int durability) {
		super(name);
		this.attack = attack;
		this.durability = durability;
	}
	public String getNmae() {
		return(this.name);
	}
	public float getAttack() {
		return(this.attack);
	}
	public int getDurability() {
		return(this.durability);
	}
}

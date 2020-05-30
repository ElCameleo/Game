package item.weapon;

import item.Item;

public class Weapon extends Item {
	
	private float attack;
	private int durability;
	public int coolDown;
	public int count;
	public Weapon(String name, float attack, int durability, int coolDown) {
		super(name);
		this.attack = attack;
		this.durability = durability;
		this.coolDown = coolDown;
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
	
	public void update () {
		this.count++;
	}
	
	public boolean canAttack () {
		return count > coolDown;
	}
	
	public void resetCount () {
		count = 0;
	}
}

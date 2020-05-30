package item.weapon;

import item.Item;

public class Weapon extends Item {
	
	public float attack;
	public int durability;
	public int coolDown;
	public int count;
	public float radius;
	public Weapon(String name, float attack, int durability, int coolDown, float radius, int price) {
		super(name, price);
		this.attack = attack;
		this.durability = durability;
		this.coolDown = coolDown;
		this.radius = radius;
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
	
	public int getDPS () {
		return (int) (((float)attack) * 60 / coolDown);
	}
}

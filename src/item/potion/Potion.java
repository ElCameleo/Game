package item.potion;

import item.Item;
import main.Game;

public abstract class Potion extends Item {
	
	protected Game game;
	public String description;
	public Potion(String name, Game game, int price, String description) {
		super(name, price);
		this.game = game;
		this.description = description;
	}
	
	public abstract void apply ();
	
	public int getPrice () {
		return price;
	}

}

package item.potion;

import item.Item;
import main.Game;

public abstract class Potion extends Item {
	
	protected Game game;
	int price;
	public Potion(String name, Game game, int price) {
		super(name);
		this.game = game;
		this.price = price;
	}
	
	public abstract void apply ();

}

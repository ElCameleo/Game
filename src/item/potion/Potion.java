package item.potion;

import item.Item;
import main.Game;

public abstract class Potion extends Item {
	
	protected Game game;

	public Potion(String name, Game game) {
		super(name);
		this.game = game;
	}
	
	public abstract void apply ();

}

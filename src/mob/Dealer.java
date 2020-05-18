package mob;

import java.util.ArrayList;

import item.Hand;
import item.Item;
import item.Spear;
import item.Sword;
import javafx.scene.paint.Color;
import main.Game;
import utils.Vector;

public class Dealer extends Mob {
	
	private ArrayList<Item> store = new ArrayList<>();

	public Dealer(Game game, Vector position) {
		super(game, "DEALER", position, new Vector(1, 1), Color.LIGHTGOLDENRODYELLOW, 0f);
		store.add(new Hand());
		store.add(new Spear());
		store.add(new Sword());
	}

	@Override
	public Vector move() {
		return new Vector(0, 0);
	}
	
	public ArrayList<Item> getStore() {
		return store;
	}

}

package mob;

import java.util.ArrayList;

import item.Item;
import item.weapon.Hand;
import item.weapon.Spear;
import item.weapon.Sword;
import javafx.scene.paint.Color;
import main.Game;
import utils.Vector;

public class Dealer extends Mob {
	
	private ArrayList<Item> store = new ArrayList<>();

	public Dealer(Game game, Vector position) {
		super(game, "DEALER", position, new Vector(1, 1), Color.LIGHTGOLDENRODYELLOW, 0f, 1);
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

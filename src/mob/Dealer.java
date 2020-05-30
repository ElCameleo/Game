
package mob;

import java.util.ArrayList;

import item.potion.*;
import item.Item;
import javafx.scene.paint.Color;
import main.Assets;
import main.Game;
import utils.Vector;

public class Dealer extends Mob {

	public class Possession {
		public int compteur = 5;
		public Potion potion;
		public Possession (Potion potion) {
			this.potion = potion;
		}
	}
	
	private ArrayList<Possession> store = new ArrayList<>();
	public Dealer(Game game, Vector position) {
		super(game, "DEALER", position, new Vector(1, 1), Assets.DEALER, 0f, 1, null);
		FillStore();
	}

	@Override
	public Vector move() {
		return new Vector(0, 0);
	}
	
	public ArrayList<Possession> getStore() {
		return this.store;
	}
	
	public void FillStore() {
		this.store.add(new Possession(new LifePotion(game)));
		this.store.add(new Possession(new LifePotion(game)));
		this.store.add(new Possession(new LifePotion(game)));
	}
	
}

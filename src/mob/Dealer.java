
package mob;

import java.util.ArrayList;

import item.potion.*;
import item.Item;
import javafx.scene.paint.Color;
import main.Game;
import utils.Vector;

public class Dealer extends Mob {
	int cpt;	
	int cpt2;
	int cpt3;
	private ArrayList<Item> store = new ArrayList<>();
	public Dealer(Game game, Vector position) {
		super(game, "DEALER", position, new Vector(1, 1), Color.LIGHTGOLDENRODYELLOW, 0f, 1);
		FillStore();
	}

	@Override
	public Vector move() {
		return new Vector(0, 0);
	}
	
	public ArrayList<Item> getList() {
		return (this.store);
	}
	
	public void FillStore() {
		LifePotion lp = new LifePotion(game,2);
		MegaLifePotion mlp = new MegaLifePotion(game,5);
		PowerPotion pp = new PowerPotion(game,3);

		for(int i=0; i<5; i++) {
			this.store.add(lp);
			this.store.add(mlp);
			this.store.add(pp);
		}
	}
	
	
	public int[] itemCount(ArrayList<Item> store) {
		for(Item obj : store) {
			if(obj instanceof LifePotion) {
				cpt++;
			}
			if(obj instanceof MegaLifePotion) {
				cpt2++;
			}
			if(obj instanceof PowerPotion) {
				cpt3++;
			}
		}
		int[] compteur = {cpt,cpt2,cpt3};
		return(compteur);
	}
	
}

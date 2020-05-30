
package mob;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import item.Item;
import item.potion.BoostWeapon1;
import item.potion.BoostWeapon2;
import item.potion.BoostWeapon3;
import item.potion.LifePotion1;
import item.potion.LifePotion2;
import item.potion.LifePotion3;
import item.potion.SpeedPotion1;
import item.potion.SpeedPotion2;
import item.weapon.Ax;
import item.weapon.DarkSword;
import item.weapon.DindonSword;
import item.weapon.EternitySword;
import item.weapon.ExplosiveFist;
import item.weapon.Hand;
import item.weapon.Spear;
import item.weapon.Sword;
import main.Assets;
import main.Game;
import utils.Vector;

public class Dealer extends Mob {
	
	public ArrayList<Item> store = new ArrayList<>();
	public Dealer(Game game, Vector position) {
		super(game, "DEALER", position, new Vector(1, 1), Assets.DEALER, 0f, 1, new Hand());
		FillStore();
	}

	@Override
	public Vector move() {
		return new Vector(0, 0);
	}
	
	public ArrayList<Item> getStore() {
		return this.store;
	}
	
	public List<Item> getItemList () {
		switch (game.level) {
			case 1: return Arrays.asList(new LifePotion1(game), new SpeedPotion1(game), new Spear(), new Sword());
			case 2: return Arrays.asList(new LifePotion1(game), new SpeedPotion1(game), new BoostWeapon1(game), new Ax(), new Sword());
			case 3: return Arrays.asList(new LifePotion2(game), new SpeedPotion2(game), new BoostWeapon1(game), new Ax(), new DarkSword());
			case 4: return Arrays.asList(new LifePotion2(game), new SpeedPotion2(game), new BoostWeapon2(game), new DarkSword(), new ExplosiveFist());
			case 5: return Arrays.asList(new LifePotion3(game), new SpeedPotion2(game), new BoostWeapon3(game), new DarkSword(), new DindonSword());
		}
		return null;
		
	}
	
	public void FillStore() {
		List<Item> list = getItemList();
		for (int i = 0 ; i < 3 ; i++) {
			int index = (int) (Math.random() * list.size());
			Item item = list.get(index);
			store.add(item);
		}
	}
	
}

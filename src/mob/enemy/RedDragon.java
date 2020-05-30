package mob.enemy;

import item.weapon.MegaFire;
import main.Assets;
import main.Game;
import utils.Vector;

public class RedDragon extends Enemy {

	public RedDragon(Game game, Vector position) {
		super(game, "RED_DRAGON", position, new Vector(2.5f, 2.5f), Assets.RED_DRAGON, 0.02f, 100, 3, new MegaFire());
	}

}

package mob.enemy;

import item.weapon.Fire;
import main.Assets;
import main.Game;
import utils.Vector;

public class BlackDragon extends Enemy {

	public BlackDragon(Game game, Vector position) {
		super(game, "BLACK_DRAGON", position, new Vector(2.5f, 2.5f), Assets.BLACK_DRAGON, 0.025f, 60, 3, new Fire());
	}

}

package mob.enemy;

import item.weapon.Fire;
import main.Assets;
import main.Game;
import utils.Vector;

public class WhiteDragon extends Enemy {

	public WhiteDragon(Game game, Vector position) {
		super(game, "WHITE_DRAGON", position, new Vector(2.5f, 2.5f), Assets.WHITE_DRAGON, 0.02f, 30, 3, new Fire());
	}

}

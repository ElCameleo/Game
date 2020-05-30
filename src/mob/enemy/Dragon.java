package mob.enemy;

import item.weapon.Fire;
import main.Assets;
import main.Game;
import utils.Vector;

public class Dragon extends Enemy {

	public Dragon(Game game, Vector position) {
		super(game, "Boss1", position, new Vector(2.5f, 2.5f), Assets.DRAGON, 0.04f, 30, 3, new Fire());
	}

}

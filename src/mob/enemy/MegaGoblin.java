package mob.enemy;

import item.weapon.Ax;
import main.Assets;
import main.Game;
import utils.Vector;

public class MegaGoblin extends Enemy {

	public MegaGoblin(Game game, Vector position) {
		super(game, "MEGA_GOBLIN", position, new Vector(2.5f, 2.5f), Assets.MEGA_GOBLIN, 0.01f, 50, 3, new Ax());
	}

}

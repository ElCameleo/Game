package mob.enemy;

import item.weapon.Mouth;
import main.Assets;
import main.Game;
import utils.Vector;

public class Spider extends Enemy {

	public Spider(Game game, Vector position) {
		super(game, "SPIDER", position, new Vector(1.5f, 1.5f), Assets.SPIDER, 0.02f, 20, 1.8f, new Mouth());
		// TODO Auto-generated constructor stub
	}

}

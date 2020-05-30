package mob.enemy;

import item.weapon.Sword;
import main.Assets;
import main.Game;
import utils.Vector;

public class Skeleton extends Enemy {

	public Skeleton(Game game, Vector position) {
		super(game, "SKELETON", position, new Vector(1, 1), Assets.SKELETON, 0.03f, 32, 3, new Sword());
		// TODO Auto-generated constructor stub
	}

}

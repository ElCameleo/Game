package mob.enemy;

import item.weapon.Ax;
import main.Assets;
import main.Game;
import utils.Vector;

public class Minotaure extends Enemy {

	public Minotaure(Game game, Vector position) {
		super(game, "MINOTAURE", position, new Vector(2.5f, 2.5f), Assets.MINOTAURE, 0.04f, 80, 3, new Ax());
	}

}

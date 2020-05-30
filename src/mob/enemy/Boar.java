package mob.enemy;

import item.weapon.Mouth;
import main.Assets;
import main.Game;
import utils.Vector;

public class Boar extends Enemy {
	public Boar(Game game, Vector position) {
		super(game, "Enemy2", position, new Vector(1, 1), Assets.BOAR, 0.06f, 8, 1.3f, new Mouth());
	}
}

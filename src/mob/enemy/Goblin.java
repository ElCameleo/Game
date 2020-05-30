package mob.enemy;

import item.weapon.Cutter;
import main.Assets;
import main.Game;
import utils.Vector;

public class Goblin extends Enemy {

	public Goblin(Game game, Vector position) {
		super(game, "GOBLIN", position, new Vector(1, 1), Assets.GOBLIN, 0.04f, 6, 1, new Cutter());
	}

}

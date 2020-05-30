package mob.enemy;

import item.weapon.Spell;
import main.Assets;
import main.Game;
import utils.Vector;

public class Wizard extends Enemy {
	public Wizard(Game game, Vector position) {
		super(game, "WIZARD", position, new Vector(1, 1), Assets.WIZARD, 0.02f, 4, 2.2f, new Spell());
	}
}

package mob.enemy;

import item.weapon.Hand;
import main.Assets;
import main.Game;
import utils.Vector;

public class Zombie extends Enemy {

	public Zombie(Game game, Vector position) {
		super(game, "Zombie", position, new Vector(1, 1), Assets.ZOMBIE, 0.01f, 40, 3.5f, new Hand());
		// TODO Auto-generated constructor stub
	}

}

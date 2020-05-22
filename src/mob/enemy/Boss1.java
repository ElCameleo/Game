package mob.enemy;

import javafx.scene.paint.Color;
import main.Game;
import utils.Vector;

public class Boss1 extends Enemy {

	public Boss1(Game game, Vector position) {
		super(game, "Boss1", position, new Vector(1.5f, 1.5f), Color.PURPLE, 0.1f, 30, 3);
	}

}

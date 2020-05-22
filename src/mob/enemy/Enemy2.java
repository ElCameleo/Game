package mob.enemy;

import javafx.scene.paint.Color;
import main.Game;
import utils.Vector;

public class Enemy2 extends Enemy {
	public Enemy2(Game game, Vector position) {
		super(game, "Enemy2", position, new Vector(0.7f, 0.7f), Color.GREENYELLOW, 0.1f, 8, 1.3f);
	}
}

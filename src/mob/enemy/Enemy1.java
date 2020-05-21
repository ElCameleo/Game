package mob.enemy;

import javafx.scene.paint.Color;
import main.Game;
import utils.Vector;

public class Enemy1 extends Enemy {

	public Enemy1(Game game, Vector position, Color color, float speed, float life) {
		super(game, "Enemy1", position, new Vector(0.5f, 0.5f), Color.GREEN, 0.1f, 6, 1);
	}

}

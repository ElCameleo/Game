package mob.enemy;

import javafx.scene.paint.Color;
import main.Game;
import utils.Vector;

public class Enemy3 extends Enemy {
	public Enemy3(Game game, Vector position) {
		super(game, "Enemy3", position, new Vector(0.8f, 0.8f), Color.DARKORANGE, 0.1f, 12, 1.8f);
	}
}

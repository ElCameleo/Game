package mob.enemy;

import javafx.scene.paint.Color;
import main.Game;
import mob.Mob;
import utils.Vector;

public abstract class Enemy extends Mob {
	
	private float difficulty;

	public Enemy(Game game, String name, Vector position, Vector size, Color color, float speed, float life, float difficulty) {
		super(game, name, position, size, color, speed, life);
		this.difficulty = difficulty;
	}

	@Override
	public Vector move() {
		return new Vector(0, 0);
	}

}

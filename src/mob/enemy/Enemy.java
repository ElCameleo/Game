package mob.enemy;

import java.util.ArrayList;

import item.weapon.Spear;
import javafx.scene.paint.Color;
import main.Game;
import mob.Mob;
import pathfinding.PathFinding;
import utils.Vector;

public abstract class Enemy extends Mob {
	
	public float difficulty;
	private ArrayList<Vector> path;
	private int pathPos = 0;

	public Enemy(Game game, String name, Vector position, Vector size, Color color, float speed, float life, float difficulty) {
		super(game, name, position, size, color, speed, life, new Spear());
		this.difficulty = difficulty;
		calculatePath();
	}
	
	public void calculatePath () {
		path = PathFinding.getPath(position.toInt(), game.player.getPosition().toInt());
		pathPos = 0;
	}

	@Override
	public Vector move() {
		float dirX = 0, dirY = 0;
		if (path != null) {
			if (Vector.dist(position, path.get(pathPos)) < 3 && path.size() - 1 != pathPos) {
				pathPos++;
			}
			if (position.x < path.get(pathPos).x) dirX += speed;
			if (position.y < path.get(pathPos).y) dirY += speed;
			if (position.x > path.get(pathPos).x) dirX -= speed;
			if (position.y > path.get(pathPos).y) dirY -= speed;
		}
		
		return new Vector(dirX, dirY);
	}

}

package mob.enemy;

import java.util.ArrayList;

import item.weapon.Spear;
import item.weapon.Weapon;
import javafx.scene.image.WritableImage;
import main.Game;
import mob.DamageZone;
import mob.Mob;
import pathfinding.PathFinding;
import utils.Vector;

public abstract class Enemy extends Mob {
	
	public float difficulty;
	private ArrayList<Vector> path;
	private int pathPos = 0;

	public Enemy(Game game, String name, Vector position, Vector size, WritableImage img, float speed, float life, float difficulty, Weapon weapon) {
		super(game, name, position, size, img, speed, life, weapon);
		this.difficulty = difficulty;
		calculatePath();
	}
	
	public void calculatePath () {
		path = PathFinding.getPath(position.toInt(), game.player.getPosition().toInt());
		pathPos = 0;
	}

	@Override
	public Vector move() {
		
		// Movement
		
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
		
		// Attack
		
		if (Vector.dist(game.player.getPosition(), position) < 1.2 * size.x) {
			if (weapon.canAttack()) {
	    		weapon.resetCount();
	    		game.handler.add(new DamageZone(game, this));
			}
		}
		
		return new Vector(dirX, dirY);
	}
	
	@Override
	public Vector getZone () {
		return Vector.middle(game.player.getPosition(), position);
	}

}

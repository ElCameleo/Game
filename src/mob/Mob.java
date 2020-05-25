package mob;

import item.weapon.Weapon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import main.GameObject;
import main.Renderer;
import utils.Border;
import utils.Vector;

public abstract class Mob extends GameObject {
	
	private Color color;
	protected float speed;
	public Weapon weapon;
	public float life, maxLife;
	public float attack;
	
	protected enum Direction { LEFT , RIGHT , UP , DOWN };
	protected Direction direction = Direction.RIGHT;
	
	public Mob(Game game, String name, Vector position, Vector size, Color color, float speed, float life, Weapon weapon) {
		super(game, name, position, size);
		this.color = color;
		this.speed = speed;
		this.life = life;
		this.maxLife = life;
		this.weapon = weapon;
	}
	
	@Override
	public boolean checkIfDead() {
		return life <= 0;
	}

	@Override
	public void update() {
		Vector newPos = move();
		position.add(newPos);
		Border border = calculBorders();
		if (!game.world.canMoveTo(border) || !game.handler.canMoveTo(this)) {
			position.add(newPos.multiply(-1));
		}
		
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.setFill(color);
		gc.fillRect((position.x - size.x/2) * Renderer.CELLSIZE , (position.y - size.y/2) * Renderer.CELLSIZE, size.x * Renderer.CELLSIZE, size.y * Renderer.CELLSIZE);
	}
	
	public abstract Vector move();
	
	public void addLife (float life) {
		this.life += life;
		if (this.life > maxLife) this.life = maxLife;
	}
	
	public void isHit (Weapon weapon) {
		life -= weapon.getAttack();
	}

	public Vector getZone() {
		Vector zonePos = position.clone();
		switch (direction) {
			case LEFT: zonePos.x -= 1; break;
			case RIGHT: zonePos.x += 1; break;
			case UP: zonePos.y -= 1; break;
			case DOWN: zonePos.y += 1; break;
		}
		return zonePos;
	}

}

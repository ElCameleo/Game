package mob;

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

	public Mob(Game game, String name, Vector position, Vector size, Color color, float speed) {
		super(game, name, position, size);
		this.color = color;
		this.speed = speed;
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

}

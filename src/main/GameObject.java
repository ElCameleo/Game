package main;

import javafx.scene.canvas.GraphicsContext;
import utils.Border;
import utils.Vector;

public abstract class GameObject {
	
	public String name;
	protected Vector position;
	protected Vector size;
	protected Game game;
	
	public GameObject(Game game, String name, Vector position, Vector size) {
		this.game = game;
		this.name = name;
		this.position = position;
		this.size = size;
	}
	
	public Border calculBorders () {
		return new Border(
			new Vector(position.x - size.x/2, position.y - size.y/2),
			new Vector(position.x + size.x/2, position.y - size.y/2),
			new Vector(position.x - size.x/2, position.y + size.y/2),
			new Vector(position.x + size.x/2, position.y + size.y/2)
		);
	}
	
	public abstract void update();
	
	public abstract void render(GraphicsContext gc);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}

	public Vector getSize() {
		return size;
	}

	public void setSize(Vector size) {
		this.size = size;
	}
	
	

}

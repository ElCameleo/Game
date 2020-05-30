package utils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Renderer;
import mob.Mob;

public class Border {
	
	public Vector topLeft;
	public Vector topRight;
	public Vector downLeft;
	public Vector downRight;
	
	public Border(Vector topLeft, Vector topRight, Vector downLeft, Vector downRight) {
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.downLeft = downLeft;
		this.downRight = downRight;
	}
	
	
	public Border (int x, int y, int w, int h) {
		topLeft = new Vector(x, y);
		topRight = new Vector(x + w, y);
		downLeft = new Vector(x, y + h);
		downRight = new Vector(x + w, y + h);
	}
	
	public Border toScreenSize () {
		return new Border(
			topLeft.multiply(Renderer.CELLSIZE),
			topRight.multiply(Renderer.CELLSIZE),
			downLeft.multiply(Renderer.CELLSIZE),
			downRight.multiply(Renderer.CELLSIZE)
		);
	}
	
	public void render (GraphicsContext gc) {
		gc.setStroke(Color.RED);
		gc.setLineWidth(15);
		gc.strokeRect(topLeft.x, topLeft.y, topRight.x - topLeft.x, downLeft.y - topLeft.y);
	}
	
	public void fill (GraphicsContext gc, Color color) {
		gc.setFill(color);
		gc.fillRect(topLeft.x * Renderer.CELLSIZE, topLeft.y * Renderer.CELLSIZE, (topRight.x - topLeft.x) * Renderer.CELLSIZE, (downLeft.y - topLeft.y) * Renderer.CELLSIZE);
	}


}

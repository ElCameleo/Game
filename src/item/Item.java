package item;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Renderer;
import utils.Vector;

public abstract class Item {

	public String name;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Vector calculTopLeft (float x, float y) {
		return new Vector(
			Renderer.WIDTH - Renderer.Item.PADDING_RIGHT - x * (Renderer.Item.SIZE + Renderer.Item.PADDING),
			Renderer.Item.PADDING_UP + y * (Renderer.Item.SIZE + Renderer.Item.PADDING)
		);	
	}
	
	public boolean inBagClick (float mouseX, float mouseY, float x, float y) {
		Vector pos = calculTopLeft (x, y);
		return mouseX > pos.x && mouseX < pos.x + Renderer.Item.SIZE &&
				mouseY > pos.y && mouseY < pos.y + Renderer.Item.SIZE;
	}
	
	public void render(GraphicsContext gc, float x, float y) {
		gc.setStroke(Color.ANTIQUEWHITE);
		gc.setFill(Color.MAGENTA);
		
		Vector pos = calculTopLeft (x, y);
		
		gc.fillRect(pos.x, pos.y, Renderer.Item.SIZE, Renderer.Item.SIZE);
		gc.strokeRect(pos.x, pos.y, Renderer.Item.SIZE, Renderer.Item.SIZE);
		gc.strokeText(name, pos.x + Renderer.Item.SIZE/2, pos.y + Renderer.Item.SIZE/2);
	}
}

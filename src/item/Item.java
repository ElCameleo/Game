package item;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Renderer;

public abstract class Item {

	public String name;
	
	public Item(String name) {
		this.name = name;
	}
	
	public void render(GraphicsContext gc, float x, float y) {
		gc.setStroke(Color.ANTIQUEWHITE);
		gc.setFill(Color.MAGENTA);
		
		float top = Renderer.Item.PADDING_UP + y * (Renderer.Item.SIZE + Renderer.Item.PADDING);
		float left = Renderer.WIDTH - Renderer.Item.PADDING_RIGHT - x * (Renderer.Item.SIZE + Renderer.Item.PADDING);
		
		gc.fillRect(left, top, Renderer.Item.SIZE, Renderer.Item.SIZE);
		gc.strokeRect(left, top, Renderer.Item.SIZE, Renderer.Item.SIZE);
		gc.strokeText(name, left + Renderer.Item.SIZE/2, top + Renderer.Item.SIZE/2);
	}
}

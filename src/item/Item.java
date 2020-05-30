package item;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Renderer;
import utils.Vector;

public abstract class Item {

	public String name;
	public int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
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
		gc.setStroke(Color.WHITE);
		gc.setFill(Color.GREY);
		
		Vector pos = calculTopLeft (x, y);
		
		gc.fillRect(pos.x, pos.y, Renderer.Item.SIZE, Renderer.Item.SIZE);
		gc.strokeRect(pos.x, pos.y, Renderer.Item.SIZE, Renderer.Item.SIZE);
		gc.setFont(new Font("Verdana", 10));
		gc.setFill(Color.WHITE);
		gc.fillText(name, pos.x + Renderer.Item.SIZE/2, pos.y + Renderer.Item.SIZE/2);
	}
}

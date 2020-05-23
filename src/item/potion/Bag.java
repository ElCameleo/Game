package item.potion;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import main.Game;
import utils.Vector;

public class Bag extends ArrayList<Potion> {
	
	public static int MAX_SIZE = 8;
	private Game game;
	
	public Bag (Game game) {
		this.game = game;
		game.scene.addEventFilter(MouseEvent.MOUSE_PRESSED, (mouseEvent) -> {
			float mouseX = (float) mouseEvent.getSceneX();
			float mouseY = (float) mouseEvent.getSceneY();
			for (int i = 0 ; i < this.size() ; i++) {
				if (this.get(i).inBagClick(mouseX, mouseY, getIndex(i).x, getIndex(i).y)) {
					this.get(i).apply();
					this.remove(this.get(i));
				}
			}
		});
		
		this.addPotion(new LifePotion(game));
		this.addPotion(new LifePotion(game));
		this.addPotion(new LifePotion(game));
		this.addPotion(new LifePotion(game));
		this.addPotion(new LifePotion(game));
	}
	
	public boolean addPotion (Potion potion) {
		if (this.size() < MAX_SIZE) {
			this.add(potion);
			return true;
		}
		return false;
	}
	
	public Vector getIndex (int index) {
		return new Vector (index % 2, 2 + index / 2);
	}
	
	public void render(GraphicsContext gc) {
		for (int i = 0 ; i < this.size() ; i++) {
			this.get(i).render(gc, getIndex(i).x, getIndex(i).y);
		}
	}

}

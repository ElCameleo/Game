package utils;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class SpriteSheet {
	
	private Image image;
	private int width, height, decX, decY;

	public SpriteSheet(String url, int width, int height, int decX, int decY) {
		this.width = width;
		this.height = height;
		this.decX = decX;
		this.decY = decY;
		this.image = new Image(url, width, height, false, true);
	}
	
	public WritableImage get(int x, int y) {
		return new WritableImage (image.getPixelReader(), x * decX, y * decY, decX, decY);
	}

}

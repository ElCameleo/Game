package utils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FillStroke {
	
	public static void setColor (GraphicsContext gc, Color color) {
		gc.setFill(color);
		gc.setStroke(color);
	}	
	
	public static void rect (GraphicsContext gc, float x, float y, float width, float height) {
		gc.fillRect(x, y, width, height);
		gc.strokeRect(x, y, width, height);
	}
}

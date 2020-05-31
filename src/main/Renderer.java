package main;

import javafx.stage.Screen;

public class Renderer {
	
	public static final float WIDTH = (float) Screen.getPrimary().getVisualBounds().getWidth();
	public static final float HEIGHT = (float) Screen.getPrimary().getVisualBounds().getHeight();
	public static final float CELLSIZE = 60;
	
	public static class Item {
		
		public static float SIZE = 50;
		public static float PADDING_RIGHT = 80;
		public static float PADDING_UP = 50;
		public static float PADDING = 40;
		
	}

}

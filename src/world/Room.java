package world;

import generator.RoomGenerator;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Renderer;
import utils.Vector;

public class Room {
	
	public static float SIZE = 21;
	public static float CORRIDOR_SIZE = 0;
	public static enum RoomType { START, END, BOSS, NORMAL, LOOT };
	public RoomType type;
	
	public Integer[][] grid;
	public Integer difficulty;
	
	public Room (RoomGenerator room) {
		this.grid = room.getSurface();
		this.difficulty = room.getDifficulty();
		this.type = room.getType();
	}
	
	public boolean isGround (Vector pos) {
		return grid[(int) pos.x][(int) pos.y] == 1;
	}
	
	public void render (GraphicsContext gc) {
		
		switch (type) {
			case START: gc.setFill(Color.LIGHTGREEN); break;
			case END: gc.setFill(Color.LIGHTPINK); break;
			case LOOT: gc.setFill(Color.LIGHTGOLDENRODYELLOW); break;
			case BOSS: gc.setFill(Color.LIGHTGRAY); break;
			case NORMAL: gc.setFill(Color.WHITE); break;
		}
		
		for (int i = 0 ; i < grid.length ; i++) {
			for (int j = 0 ; j < grid.length ; j++) {
				if (grid[i][j] == 1) {
					gc.fillRect(i * Renderer.CELLSIZE, j * Renderer.CELLSIZE, Renderer.CELLSIZE, Renderer.CELLSIZE);
				} 
				//gc.strokeRect(i * Renderer.CELLSIZE, j * Renderer.CELLSIZE, Renderer.CELLSIZE, Renderer.CELLSIZE);
			}
		}
	}
	
}

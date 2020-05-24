package world;

import generator.RoomGenerator;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import main.Renderer;
import utils.Border;
import utils.FillStroke;
import utils.Vector;

public class Room {
	
	public static float SIZE = 21;
	public static enum RoomType { 
		START("S"), END("E"), BOSS("B"), NORMAL("N"), LOOT("L"), EMPTY("."); 
		String string;
		RoomType(String s){
			string = s;
		}
		public String toString() {
			return this.string;
		}
	};
	public RoomType type;
	
	public Integer[][] grid;
	public Integer difficulty;
	
	private Spawner spawner;
	private Game game;
	private Vector delta;
	
	public Room (RoomGenerator room, Game game, Vector delta) {
		this.grid = room.getSurface();
		this.difficulty = room.getDifficulty();
		this.type = room.getType();
		this.game = game;
		this.delta = delta;
	}
	
	public void populate () {
		spawner = new Spawner(game, this, delta);
	}
	
	public boolean isGround (Vector pos) {
		return grid[(int) pos.x][(int) pos.y] == 1;
	}
	
	public Border getBorder (Vector topLeft) {
		return new Border (
			topLeft,
			new Vector (topLeft.x + Renderer.WIDTH, topLeft.y),
			new Vector (topLeft.x, topLeft.y + Renderer.HEIGHT),
			new Vector (topLeft.x + Renderer.WIDTH, topLeft.y + Renderer.HEIGHT)
		);
	}
	
	public void render (GraphicsContext gc) {
		
		switch (type) {
			case START: FillStroke.setColor(gc, Color.GREEN); break;
			case END: FillStroke.setColor(gc, Color.LIGHTPINK); break;
			case LOOT: FillStroke.setColor(gc, Color.BLUE); break;
			case BOSS: FillStroke.setColor(gc, Color.RED); break;
			case NORMAL: FillStroke.setColor(gc, Color.WHITE); break;
		}
		
		for (int i = 0 ; i < grid.length ; i++) {
			for (int j = 0 ; j < grid.length ; j++) {
				if (grid[i][j] == 1) {
					FillStroke.rect(gc, i * Renderer.CELLSIZE, j * Renderer.CELLSIZE, Renderer.CELLSIZE, Renderer.CELLSIZE);
				} 
			}
		}
	}
	
}

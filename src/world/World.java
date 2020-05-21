package world;

import generator.WorldGenerator;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Renderer;
import utils.Border;
import utils.Vector;

public class World {
	
	public static float SIZE = 5;
	public Room[][] rooms;
	
	public World () {
		rooms = WorldGenerator.create();
	}
	
	public boolean canMoveTo (Border border) {
		return isGround(border.topLeft) && isGround(border.topRight) && isGround(border.downLeft) && isGround(border.downRight) ;
	}
	
	public boolean isGround (Vector pos) {
		Vector roomPos = getRoomPositionAt(new Vector(pos.x, pos.y));
		Vector posInRoom = new Vector(pos.x - roomPos.x * Room.SIZE, pos.y - roomPos.y * Room.SIZE);
		if (pos.x < 0 || pos.y < 0 || roomPos.x < 0 || roomPos.x >= World.SIZE || roomPos.y < 0 || roomPos.y >= World.SIZE) return false;
		return rooms[(int) roomPos.x][(int) roomPos.y].isGround(posInRoom);
	}
	
	public Vector getRoomPositionAt (Vector pos) {
		pos.multiply(1 / Room.SIZE);
		return new Vector((int) pos.x, (int) pos.y);
	}
	
	public void render (GraphicsContext gc) {
		gc.setStroke(Color.GREY);
		gc.setFill(Color.WHITE);
		for (int i = 0 ; i < rooms.length ; i++) {
			for (int j = 0 ; j < rooms.length ; j++) {
				gc.save();
				gc.translate(i * Room.SIZE * Renderer.CELLSIZE, j * Room.SIZE * Renderer.CELLSIZE);
				rooms[i][j].render(gc);
				gc.restore();
			}
		}
	}

}

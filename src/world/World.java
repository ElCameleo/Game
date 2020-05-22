package world;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import main.Renderer;
import utils.Border;
import utils.Collision;
import utils.Vector;

public class World {
	
	public static float SIZE = 5;
	public Room[][] rooms;
	public Room roomStart, roomEnd;
	public Game game;
	
	public World (Game game, Room[][] rooms, Room roomStart, Room roomEnd) {
		this.rooms = rooms;
		this.roomStart = roomStart;
		this.roomEnd = roomEnd;
		this.game = game;
	}
	
	public void populate () {
		for (int i = 0 ; i < rooms.length ; i++) {
			for (int j = 0 ; j < rooms.length ; j++) {
				rooms[i][j].populate();
			}
		}
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
	
	public Vector getRoomVector (Room room) {
		for (int i = 0 ; i < rooms.length ; i++) {
			for (int j = 0 ; j < rooms.length ; j++) {
				if (rooms[i][j] == room) return new Vector (i, j);
			}
		}
		return null;
	}
	
	public Vector getStartPosition () {
		Vector roomPos = getRoomVector(roomStart);
		return new Vector (
			(float) (roomPos.x + 0.5) * Room.SIZE,
			(float) (roomPos.y + 0.5) * Room.SIZE
		);
	}
	
	public void render (GraphicsContext gc) {
		Border cameraBorder = game.camera.getBorders();
		for (int i = 0 ; i < rooms.length ; i++) {
			for (int j = 0 ; j < rooms.length ; j++) {
				Border roomBorder = rooms[i][j].getBorder(new Vector (i * Room.SIZE * Renderer.CELLSIZE, j * Room.SIZE * Renderer.CELLSIZE));
				if (Collision.rect(cameraBorder, roomBorder)) {
					gc.save();
					gc.translate(i * Room.SIZE * Renderer.CELLSIZE, j * Room.SIZE * Renderer.CELLSIZE);
					rooms[i][j].render(gc);
					gc.restore();
				}
			}
		}
	}

}

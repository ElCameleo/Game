package world;

import java.util.ArrayList;

import utils.Vector;

public class Spawner {
	
	public static float CHUNK_SIZE = 3;
	
	public ArrayList<Vector> availableZone;
	private Room room;
	
	public Spawner (Room room) {
		this.room = room;
		createAvailableZones();
		//addEnemy(room);
	}
	
	public int getEnnemyNumberByRoomLevel () {
		return 3;
	}
	
	public void createAvailableZones () {
		for (int i = 0 ; i < CHUNK_SIZE ; i++) {
			for (int j = 0 ; j < CHUNK_SIZE ; j++) {
				Vector pos = new Vector ((int) (i * Room.SIZE / CHUNK_SIZE), (int) (j * Room.CORRIDOR_SIZE / CHUNK_SIZE));
				if (room.isGround(pos)) availableZone.add(pos);
			}
		}
	}

}

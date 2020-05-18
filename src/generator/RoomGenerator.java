package generator;

import utils.Vector;
import world.Room;

public class RoomGenerator {
	
	public static int[][] create () {
		int[][] room = new int[(int) Room.GET_TOTAL_SIZE()][(int) Room.GET_TOTAL_SIZE()];
		for (int i = 0 ; i < room.length ; i++) {
			for (int j = 0 ; j < room.length ; j++) {
				room[i][j] = Room.IN_ROOM_SPACE(new Vector(i, j)) ? 1 : 0;
			}
		}
		return room;
	}

}

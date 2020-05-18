package generator;

import world.Room;
import world.World;

public class WorldGenerator {

	public static Room[][] create () {
		Room[][] world = new Room[(int) World.SIZE][(int) World.SIZE];
		for (int i = 0 ; i < world.length ; i++) {
			for (int j = 0 ; j < world.length ; j++) {
				world[i][j] = new Room();
			}
		}
		return world;
	}

}

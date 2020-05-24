package pathfinding;

import utils.Vector;
import world.Room;
import world.World;

public class Path {
	
	private static BFS graph;
	
	public static void init (World world) {
		graph = new BFS();
		int[][] worldGrid = world.getTotalArray();
		for (int i = 0 ; i < worldGrid.length ; i++) {
			for (int j = 0 ; j < worldGrid.length ; j++) {
				graph.addEdge(i, j, worldGrid[i][j]);
			}
		}
		graph.bfs(Path.VectToInt(new Vector(0, 0)));
		graph.bfs(Path.VectToInt(new Vector(1, 1)));
		graph.bfs(Path.VectToInt(new Vector(2, 2)));
		graph.bfs(Path.VectToInt(new Vector(3, 3)));
	}
	
	public static Vector intToVect (int index) {
		return new Vector((int) (index / (Room.SIZE * World.SIZE)), index % (Room.SIZE * World.SIZE));
	}
	
	public static int VectToInt (Vector vect) {
		return (int) (vect.x * (World.SIZE * Room.SIZE) + vect.y);
	}

}

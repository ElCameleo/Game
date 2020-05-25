package pathfinding;

import utils.Vector;
import world.Room;
import world.World;

public class Path {
	
	private static BFS graph;
	
	private static void check (int[][] world, int x, int y, int decX, int decY) {
		if ((world[x + decX][y + decY] == 1)) {
            graph.addEdge(Path.VectToInt(new Vector(x, y)), Path.VectToInt(new Vector(x + decX, y + decY)));
        } 
	}
	
	public static void init (World world) {
		graph = new BFS();
		
		
		
		int[][] worldGrid = world.getTotalArray();
		for (int i = 0 ; i < worldGrid.length ; i++) {
			for (int j = 0 ; j < worldGrid.length ; j++) {
		        
		        if (worldGrid[i][j] == 1) {
		            
		           check(worldGrid, i, j, -1, -1);
		           check(worldGrid, i, j,  0, -1);
		           check(worldGrid, i, j, +1, -1);
		           check(worldGrid, i, j, -1,  0);
		           check(worldGrid, i, j, +1,  0);
		           check(worldGrid, i, j, -1, +1);
		           check(worldGrid, i, j,  0, +1);
		           check(worldGrid, i, j, +1, +1);
		        }
			}
		}
		graph.bfs(Path.VectToInt(new Vector(10, 10)));

	}
	
	public static Vector intToVect (int index) {
		return new Vector((int) (index / (Room.SIZE * World.SIZE)), index % (Room.SIZE * World.SIZE));
	}
	
	public static int VectToInt (Vector vect) {
		return (int) (vect.x * (World.SIZE * Room.SIZE) + vect.y);
	}

}

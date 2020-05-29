package pathfinding;

import java.util.ArrayList;

import utils.Vector;
import world.World;

public class PathFinding {
	
	private static int[][] GRID;
	private static AStar aStar;
	
	public static void init (World world) {		
		GRID = world.getTotalArray();
		aStar = new AStar();
	}
	
	public static ArrayList<Vector> getPath (Vector start, Vector end) {
		return aStar.getShortestPath (GRID, start, end);
	}
}

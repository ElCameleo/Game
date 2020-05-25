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
		        
		        if (worldGrid[i][j] == 1){
		            
		            // Diagonale haut gauche
		            if ((worldGrid[i-1][j-1] == 1) && ((worldGrid[i-1][j] != 0) || (worldGrid[i][j-1] != 0))){
		                graph.addEdge(Path.VectToInt(new Vector(i, j)), Path.VectToInt(new Vector(i-1, j-1)), 1);
		            } 

		            // Ouest        
		            else if (worldGrid[i][j-1] == 1){
		                graph.addEdge(Path.VectToInt(new Vector(i, j)), Path.VectToInt(new Vector(i, j-1)), 1);
		            } 

		            // Diagonale bas gauche        
		            else if ((worldGrid[i+1][j-1] == 1) && ((worldGrid[i][j-1] != 0) || (worldGrid[i+1][j] != 0))){
		                graph.addEdge(Path.VectToInt(new Vector(i, j)), Path.VectToInt(new Vector(i+1, j-1)), 1);
		            } 

		            // Nord        
		            else if (worldGrid[i-1][j] == 1){
		                graph.addEdge(Path.VectToInt(new Vector(i, j)), Path.VectToInt(new Vector(i-1, j)), 1);
		            } 

		            // Est        
		            else if (worldGrid[i][j+1] == 1){
		                graph.addEdge(Path.VectToInt(new Vector(i, j)), Path.VectToInt(new Vector(i, j+1)), 1);
		            }

		            // Diagonale haut droit        
		            else if ((worldGrid[i-1][j+1] == 1) && ((worldGrid[i-1][j] != 0) || (worldGrid[i][j+1] != 0))){
		                graph.addEdge(Path.VectToInt(new Vector(i, j)), Path.VectToInt(new Vector(i-1, j+1)), 1);
		            } 

		            // Sud        
		            else if (worldGrid[i+1][j] == 1){
		                graph.addEdge(Path.VectToInt(new Vector(i, j)), Path.VectToInt(new Vector(i+1, j)), 1);
		            } 

		            // Diagonale bas droit        
		            else if ((worldGrid[i+1][j+1] == 1) && ((worldGrid[i+1][j] != 0) || (worldGrid[i][j+1] != 0))){
		                graph.addEdge(Path.VectToInt(new Vector(i, j)), Path.VectToInt(new Vector(i+1, j+1)), 1);
		            }
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

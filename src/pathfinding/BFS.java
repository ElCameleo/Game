package pathfinding;

import java.util.ArrayDeque; 
import java.util.ArrayList; 
import java.util.Deque;

import world.Room;
import world.World; 
  
public class BFS {

    private static class Node { 
        int lastVertex; // the ending vertex 
          
        public Node(int lastVertex) { 
            this.lastVertex = lastVertex; 
        } 
    } 
      
    private static final int numVertex = (int) (Room.SIZE * Room.SIZE * World.SIZE * World.SIZE); // number of edges (9 because the test has 9 edges)
    public ArrayList<Node>[] edges = new ArrayList[numVertex]; 
      
    public BFS() { 
        for (int i = 0; i < edges.length; i++) { 
            edges[i] = new ArrayList<Node>(); 
        } 
    } 
      
    public void addEdge(int u, int v) { 
        edges[u].add(new Node(v)); 
        edges[v].add(new Node(u));
    } 
      
    public void bfs(int src) { 
  
        // initialize distances from given source 
        int[] dist = new int[numVertex]; 
        for (int i = 0; i < numVertex; i++) { 
            dist[i] = Integer.MAX_VALUE; 
        } 
          
        // double ended queue to do BFS 
        Deque<Integer> queue = new ArrayDeque<Integer>(); 
        dist[src] = 0; 
        queue.addLast(src); 
        while (!queue.isEmpty()) { 
            int v = queue.removeFirst(); 
            for (int i = 0; i < edges[v].size(); i++) { 
            	 System.out.println(dist[edges[v].get(i).lastVertex] + " " + (dist[v]+1));
                // checking for optimal distance 
                if ((dist[edges[v].get(i).lastVertex]) > (dist[v] + 1)) { 
                    // update the distance 
                    dist[edges[v].get(i).lastVertex] = dist[v] + 1; 
  
                    // put 0 weight edges to front and 1 
                    // weight edges to back so that vertices 
                    // are processed in increasing order of weight 
    
                    queue.addLast(edges[v].get(i).lastVertex); 
                } 
            } 
        } 
        for (int i = 0; i < dist.length; i++) { 
            System.out.print(dist[i] + " "); 
        } 
        System.out.println();
    }
}
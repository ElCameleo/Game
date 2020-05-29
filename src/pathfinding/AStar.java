package pathfinding;


import java.util.ArrayList;

import utils.Vector;

public class AStar {
	
	private int maxIteration = 1000;
	
	public class Point {
		public int value, cost, f, h;
		public Vector position;
		public ArrayList<Vector> parents = new ArrayList<>();
		public Point(Vector position, int value) {
			this.position = position;
			this.value = value;
			cost = -1;
			f = -1;
			h = -1;
		}
		public void heuristic(Point end) {
			h = (int) (Math.abs(position.x - end.position.x) + Math.abs(position.y - end.position.y));
		}
		public boolean equal(Point point) {
			return this.position.equal(point.position);
		}
	}
	
	public class Matrice {
		public Point[][] matrice;
		public Point start, end;
		public int size;
		public Matrice (int[][] world, Vector start, Vector end) {
			size = world.length;
			matrice = new Point[size][size];
			for (int i = 0 ; i < size ; i++) {
				for (int j = 0 ; j < size ; j++) {
					matrice[i][j] = new Point(new Vector(i, j), world[i][j]);
				}
			}
			this.start = matrice[(int) start.x][(int) start.y];
			this.end = matrice[(int) end.x][(int) end.y];
		}
		private void checkDirection (Path path, Point point, int x, int y, int decX, int decY) {
			if (x + decX != 0 && y + decY != 0 && x + decX != size - 1 && y + decY != size - 1) {
				if (this.matrice[x-1][y].value == 1) {
					Point neighbour = this.matrice[x + decX][y + decY];
					neighbour.heuristic(end);
					neighbour.cost++;
					neighbour.parents = new ArrayList<>(point.parents);
					neighbour.parents.add(point.position);
					neighbour.f  = neighbour.cost + neighbour.h;
					path.add(neighbour);
				}
			}
		}
		public void checkNeighbour(Point point, Path path) {
			int x = (int) point.position.x;
			int y = (int) point.position.y;
			checkDirection (path, point, x, y, 0,  1);
			checkDirection (path, point, x, y, 0, -1);
			checkDirection (path, point, x, y,  1, 0);
			checkDirection (path, point, x, y, -1, 0);
			checkDirection (path, point, x, y, -1, 1);
			checkDirection (path, point, x, y, -1, -1);
			checkDirection (path, point, x, y, 1, 1);
			checkDirection (path, point, x, y, 1, -1);
			point.value = 2;
			path.remove(point);
		}
	}
	
	public class Path extends ArrayList<Point> {
		public Path (Point start) {
			super();
			add(start);
		}
		public void addPath (Point point) {
			if (this.contains(point) && this.get(this.indexOf(point)).f < point.f) {
				this.get(this.indexOf(point)).parents = point.parents;
			} else { 
				this.add(point);
			}
		}
		public int best () {
			int max = 0;
			for (int i = 0; i < this.size() ; i++) {
				if (this.get(max).f > this.get(i).f) {
					max = i;
				}
			}
			return max;
			
		}
	}

	public ArrayList<Vector> getShortestPath (int[][] world, Vector start, Vector end) {
		Matrice matrice = new Matrice(world, start, end);
		Path path = new Path(matrice.start);
		int best = 0;
		Point point = path.get(0);
		matrice.checkNeighbour(point, path);
		int count = 0;
		do {
			best = path.best();
			if (path.isEmpty()) return null;
			point = path.get(best);
			matrice.checkNeighbour(point, path);
			count++;
			if (count > maxIteration) break;
		} while ((!point.equal(matrice.end)) && (!path.isEmpty()));
		if ((path.isEmpty()) && (!point.equal(matrice.end))) {
			return null;
		} else {
			ArrayList<Vector> finalPath = point.parents;
			finalPath.add(point.position);
			return finalPath;
		}
	}

}

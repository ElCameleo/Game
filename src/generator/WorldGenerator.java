package generator;

import java.util.Random;

import world.Room;
import world.World;

public class WorldGenerator {

	private Integer[][] map;
	private RoomGenerator[][] etage;
	private Integer[][] visual;

	private int x;
	private int y;
	
	public WorldGenerator(int x, int y) {
		map =  new Integer[x][y];
		this.x = x;
		this.y = y;
		for(int i=0;i<x;i++) {
			for(int j=0; j<y;j++){
				map[i][j] = 0;
			}
		}
		
		Random r = new Random();		
		int sx = r.nextInt((int) World.SIZE);
		int sy = r.nextInt((int) World.SIZE);
		int[] premiereSalle = {3,5,6,7,9,10,11,12,13,14,15};
		map[sx][sy] = premiereSalle[r.nextInt(11)];
		next(map[sx][sy],sx,sy);
	}
		
	
	private Integer[] getRooms(int  dirPrecedente) {
	Integer[] res = {};
 		switch(dirPrecedente) {
 		case 1:
 			Integer[] l1 = {1,3,9,5,7,13,11,15};
 			res = l1;
 		break;
 		case 2:
 			Integer[] l2 = {2,3,6,10,7,14,11,15};
 			res = l2;
 		break;
 		case 3:
 			Integer[] l3 = {4,6,12,5,7,14,13,15};
 			res = l3 ;
 		break;
 		case 4:
 			Integer[] l4 = {8,12,9,10,14,13,11,15};
 			res = l4;
 		break;
 		}
 		return res;
	}
	
	
	private void correctOut(int dir, int x, int y) {

		int tab[][] = {
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15},
				{ 0, 0, 2, 0, 4, 0, 6, 0, 8, 0,10, 0,12, 0,14},
				{ 0, 0, 1, 0, 0, 4, 5, 0, 0, 8, 9, 0, 0,12,13},
				{ 0, 0, 0, 0, 1, 2, 3, 0, 0, 0, 0, 8, 9,10,11},
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7}
				};
		
		
		map[x][y] = tab[dir][map[x][y]-1];
	
	}

	

	private void next(int typeSalle, int x, int y) {
		if(typeSalle==3||typeSalle==9||typeSalle==5||typeSalle==7||typeSalle==13||typeSalle==11||typeSalle==15) {
			generate(3,x-1,y);
		}
		if(typeSalle==3||typeSalle==6||typeSalle==10||typeSalle==7||typeSalle==14||typeSalle==11||typeSalle==15) {
			generate(4,x,y+1);
		}
		if(typeSalle==6||typeSalle==12||typeSalle==5||typeSalle==7||typeSalle==14||typeSalle==13||typeSalle==15){
			generate(1,x+1,y);
		}
		if(typeSalle==12||typeSalle==9||typeSalle==10||typeSalle==14||typeSalle==13||typeSalle==11||typeSalle==15) {
			generate(2,x,y-1);
		}
		
	}
	
	private void generate(int precedent,int x, int y) {
		Random r = new Random();	
		Integer[] l = getRooms(precedent);
		int v = l[r.nextInt(l.length)];
		if(x<0) {
			correctOut(1,0,y);

		}
		else if(x>=this.x) {
			correctOut(3,this.x-1,y);

		}
		else if(y<0) {
			correctOut(4,x,0);

		}
		else if(y>=this.y) {
			correctOut(2,x,this.y-1);

		}
		else if(map[x][y]==0){
			map[x][y] = v;	
			next(v,x,y);

		}
		else{
			boolean s = false;
			for(int i=0;i<l.length;i++) {
				s = s || map[x][y] == l[i]; 
			}
			if(!s){
				switch(precedent) {
				case 1:
					correctOut(3,x-1,y);
				break;
				case 2:
					correctOut(4,x,y+1);
				break;
				case 4:
					correctOut(2,x,y-1);
				break;
				case 3:
					correctOut(1,x+1,y);
				break;
				}

			}
		} 
	}
	
	@Override
	public String toString() {
		String s ="";
		String car[] = {" ."," ╨"," ╞"," ╚"," ╥"," ║"," ╔"," ╠"," ╡"," ╝"," ═"," ╩"," ╗"," ╣"," ╦"," ╬"};		
	
		for(int i=0;i<x;i++) {
			for(int j=0; j<y;j++){
				s = s + car[map[i][j]];
			}
			s += "\n";
		}
		return s;
	}
	
	public void generateVisual() {
		etage = new RoomGenerator[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
//				etage[i][j] = new RoomGenerator(map[i][j]);
			}
		}
		visual = new Integer[x*etage[0][0].getX()][y*etage[0][0].getY()];
		String s="";
		for(int i=0;i<this.x;i++) {
			for(int k=0;k<etage[i][0].getX();k++) {
				for(int j=0;j<etage[i].length;j++) {
					for(int m=0;m<etage[i][j].getY();m++) {
						visual[i*etage[i][0].getX()+k][j*etage[i][0].getY()+m] = etage[i][j].getSurface()[k][m];
					}
				}
				s = s+"\n";
			}
		}
	}
	
	public Integer[][] getVisual(){
		generateVisual();
		return visual;
	}
	
	public String visualToString() {
		String s="";
		generateVisual();
		for(int i=0;i<visual.length;i++) {
			for(int j=0;j<visual[0].length;j++) {
				s = s+ " " + visual[i][j]; 
	}
			s = s+ "\n";
		}
		return s;
	}
	public Integer[][] getMap() {
		return map;
	}
	
	public static Room[][] create () {
		
		WorldGenerator WG = new WorldGenerator((int) World.SIZE,(int) World.SIZE);
		System.out.println(WG.toString());
		int[] depart = {-1,-1};
		int[] arrive = {-1,-1};
		Room[][] world = new Room[(int) World.SIZE][(int) World.SIZE];
		for (int i = 0 ; i < world.length ; i++) {
			for (int j = 0 ; j < world.length ; j++) {
				world[i][j] = new Room(WG.getMap()[i][j]);
				if (WG.getMap()[i][j] != 0) {
					if(depart[0] ==-1) {
						depart[0] = i;
						depart[1] = j;
					}
					arrive[0] = i;
					arrive[1] = j;
				}
			}
		}
		
		world[depart[0]][depart[1]].type = "depart";
		world[arrive[0]][arrive[1]].type = "arrive";
		
		return world;
	}
}

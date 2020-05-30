package generator;

import java.util.Random;
import java.util.ArrayList;

import main.Game;
import main.Renderer;
import utils.Vector;
import world.Room;
import world.World;
import world.Room.RoomType;

public class WorldGenerator {

	private Integer[][] map;
	private RoomGenerator[][] etage;

	private int hauteur;
	private int largeur;
	
	public WorldGenerator(int x, int y) {
		hauteur = x;
		largeur = y;
		map =  new Integer[hauteur][largeur];
		
		int nbSalle = 0;
		while(nbSalle<(hauteur*largeur)/2) {
			createMap();
			nbSalle = 0;
			for(int i = 0; i<hauteur;i++) {
				for(int j = 0; j<largeur;j++) {
					if(map[i][j]!=0) {
						nbSalle+=1;
					}
				}
			}
		}
		
		createEtage();
	}
	
	private void createMap() {
			
		for(int i=0;i<hauteur;i++) {
			for(int j=0; j<largeur;j++){

				map[i][j] = 0;
			}
		}
		
		Random r = new Random();		
		int startx = r.nextInt((int) World.SIZE);
		int starty = r.nextInt((int) World.SIZE);
		int[] premiereSalle = {3,5,6,7,9,10,11,12,13,14,15};
		map[startx][starty] = premiereSalle[r.nextInt(11)];
		next(map[startx][starty],startx,starty);
		

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
	
	
	private void correct(int dir, int x, int y) {

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
	
	private void generate(int DirectionPrec,int x, int y) {
		Random r = new Random();	
		Integer[] sallePossible = getRooms(DirectionPrec);
		int v = sallePossible[r.nextInt(sallePossible.length)];
		if(x<0) {
			correct(1,0,y);

		}
		else if(x>=this.hauteur) {
			correct(3,this.hauteur-1,y);

		}
		else if(y<0) {
			correct(4,x,0);

		}
		else if(y>=this.largeur) {
			correct(2,x,this.largeur-1);

		}
		else if(map[x][y]==0){
			map[x][y] = v;	
			next(v,x,y);

		}
		else{
			boolean s = false;
			for(int i=0;i<sallePossible.length;i++) {
				s = s || map[x][y] == sallePossible[i]; 
			}
			if(!s){
				switch(DirectionPrec) {
				case 1:
					correct(3,x-1,y);
				break;
				case 2:
					correct(4,x,y+1);
				break;
				case 4:
					correct(2,x,y-1);
				break;
				case 3:
					correct(1,x+1,y);
				break;
				}

			}
		} 
	}
	
	
	private void generateRoom(int x, int y, int profondeur) {
		String directions = RoomGenerator.binarySalle(map[x][y]);

		if(etage[x][y].getType() == RoomType.EMPTY || etage[x][y].getDifficulty() > profondeur) {
			
			printEtage();
			//System.out.println(directions);
			
			
			if((map[x][y] == 1 || map[x][y] == 2 || map[x][y] == 4 || map[x][y] == 8 )&& profondeur !=0) {
				etage[x][y].setType(RoomType.LOOT);
				etage[x][y].setDifficulty(0);
			}
			else if(profondeur == 0) {
				etage[x][y].setType(RoomType.START);
				etage[x][y].setDifficulty(0);
			}
			else {
				etage[x][y].setType(RoomType.NORMAL);
				etage[x][y].setDifficulty(profondeur);
			}
			
			// puis deplacement
			if(directions.charAt(0) == '1') {
				generateRoom(x,y-1,profondeur+1);
			}
			if(directions.charAt(1) == '1') {
				generateRoom(x+1,y,profondeur+1);
			}
			if(directions.charAt(2) == '1') {
				generateRoom(x,y+1,profondeur+1);
			}
			if(directions.charAt(3) == '1') {
				generateRoom(x-1,y,profondeur+1);
			}
			
		}
		
		
	}
	
	private void createEtage() {
		etage = new RoomGenerator[hauteur][largeur];
		ArrayList<int[]> startRooms = new ArrayList<int[]>();
		ArrayList<int[]> rooms = new ArrayList<int[]>();

		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				etage[i][j] = new RoomGenerator(map[i][j],(int)Room.SIZE,RoomType.EMPTY,0);
				int[] coord = {i,j};
				if(map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 4 || map[i][j] == 8) {
					rooms.add(coord);
				}
				else if(map[i][j] != 0) {
					startRooms.add(coord);
				}
			}
		}
		Random r = new Random();
		int index = r.nextInt(rooms.size());
		generateRoom(rooms.get(index)[0],rooms.get(index)[1],0);
		rooms.remove(index);
		index = r.nextInt(rooms.size());
		etage[rooms.get(index)[0]][rooms.get(index)[1]].setType(RoomType.BOSS);
	}
	
	public void printEtage() {
		String types = "";
		String difficulties = "";
		for(int i = 0; i<etage.length;i++) {
			for (int j = 0; j<etage[i].length;j++){
				types += " " + etage[i][j].getType().toString();
				difficulties += " " + etage[i][j].getDifficulty();
			}
			types += "\n";
			difficulties += "\n";
		}
		//System.out.println(this.toString());
		//System.out.println(types);
		//System.out.println(difficulties);
	}
	
	@Override
	public String toString() {
		String chaine ="";
		String car[] = {" ."," ╨"," ╞"," ╚"," ╥"," ║"," ╔"," ╠"," ╡"," ╝"," ═"," ╩"," ╗"," ╣"," ╦"," ╬"};		
	
		for(int i=0;i<hauteur;i++) {
			for(int j=0; j<largeur;j++){
				chaine = chaine + car[map[i][j]];
			}
			chaine += "\n";
		}
		return chaine;
	}
	
	public Integer[][] getMap() {
		return map;
	}
	public RoomGenerator[][] getEtage(){
		return etage;
	}
	
	public static World create (Game game) {
		WorldGenerator WG = new WorldGenerator((int) World.SIZE,(int) World.SIZE);
		//System.out.println(WG.toString());
		WG.printEtage();
		int[] depart = {2,2};
		int[] arrive = {-1,-1};
		Room[][] world = new Room[(int) World.SIZE][(int) World.SIZE];
		Room roomStart, roomEnd;
		for (int i = 0 ; i < world.length ; i++) {
			for (int j = 0 ; j < world.length ; j++) {
				world[i][j] = new Room(WG.getEtage()[i][j], game, new Vector(i, j).multiply(Room.SIZE));
				if (WG.getMap()[i][j] != 0) {
					if(world[i][j].type == RoomType.START) {
						depart[0] = i;
						depart[1] = j;
					}
					if(world[i][j].type == RoomType.BOSS) {
						arrive[0] = i;
						arrive[1] = j;
					}
				}
			}
		}

		
		roomStart = world[depart[0]][depart[1]];
		roomEnd = world[arrive[0]][arrive[1]];
		
		return new World(game, world, roomStart, roomEnd);
	}

}
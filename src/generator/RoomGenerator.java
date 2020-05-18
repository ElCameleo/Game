package generator;

import java.util.Random;

import utils.Vector;
import world.Room;

public class RoomGenerator {
	
	private Integer[][] surface;
	private String typeIntersection;
	private String type;
	private Integer difficulty;
	private int x=11;
	private int y=11;
	
	public RoomGenerator(int salle,int taille) {
		x = taille;
		y = taille;
		surface = new Integer[x][y];
		this.typeIntersection = binarySalle(salle);
		for(int i=0; i<x;i++) {
			for(int j=0;j<y;j++) {
				surface[i][j] = 0;
			}
		}
		
		if(typeIntersection.charAt(0)=='1') {
			surface = combine(surface,sGauche());
		}
		if(typeIntersection.charAt(1)=='1') {
			surface = combine(surface,sBas());
		}
		if(typeIntersection.charAt(2)=='1') {
			surface = combine(surface,sDroite());
		}
		if(typeIntersection.charAt(3)=='1') {
			surface = combine(surface,sHaut());
		}
		
		if(salle!=0) {
			for(int i=0; i<3;i++) {
				surface = combine(surface,randomRoom());
			}
		}
		Random r = new Random();
		this.difficulty = r.nextInt(10);
		String[] typeRoom = {"Bonus","Boss","Normal"};
		this.type = typeRoom[r.nextInt(3)];
		
	}

	
	private String binarySalle(int type) {
		String t = Integer.toBinaryString(type);
		while(t.length()<4) {
			t = "0"+t;
		}
		return t;
	}
	
	private Integer[][] randomRoom(){
		Integer[][] room = new Integer[x][y];
		Random r = new Random();
		int x =   r.nextInt((this.x/2)-1 - 2 + 1) + 2;
		int y =  r.nextInt((this.y/2)-1 - 2 + 1) + 2;
		
		for(int i=0;i<this.x;i++) {
			for(int j=0; j<this.y;j++) {
				
				if(i>x && i<(this.x/2)+x && j>y && j<(this.y/2)+y ) {
					room[i][j] = 1;
				}
			
				else {
					room[i][j] = 0;
				}
			}
		}
		
		return room;
	}
	
	private Integer[][] sHaut(){
		Integer[][] salle = new Integer[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(i<((x)/2)+1&& j>((y)/2)-2 && j<((y)/2)+2) {
					salle[i][j] = 1;
				}
				else {
					salle[i][j] = 0;
				}
			}
		}
		return salle;
	}
	private Integer[][] sBas(){
		Integer[][] salle = new Integer[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(i>((x)/2)-1 && j>((y)/2)-2 && j<((y)/2)+2) {
					salle[i][j] = 1;
				}

				else {
					salle[i][j] = 0;
				}
			}
		}
		return salle;
	}
	
	private Integer[][] sDroite(){
		Integer[][] salle = new Integer[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(j>((y)/2)-1 && i>((x)/2)-2 && i<((x)/2)+2) {
					salle[i][j] = 1;
				}
				else {
					salle[i][j] = 0;
				}
			}
		}
		return salle;
	}
	
	private Integer[][] sGauche(){
		Integer[][] salle = new Integer[x][y];
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(j<(y+1)/2 && i>((x)/2)-2 && i<((x)/2)+2) {
					salle[i][j] = 1;
				}
				else if(j<((y)/2)+1 && i>((x)/2)-3 && i<((x)/2)+3 || j==((y)/2)+1 && i>((x)/2)-3 && i<((x)/2)+3) {
					salle[i][j] = 0;
				}
				else {
					salle[i][j] = 0;
				}
			}
		}
		return salle;
	}
	private Integer[][] combine(Integer[][] x,Integer[][] y){
		int[][] t = {
				{0, 1, 2},
				{1, 1, 1},
				{2, 1, 2}};
		for(int i=0; i<this.x;i++) {
			for(int j=0;j<this.y;j++) {
				x[i][j] = t[x[i][j]][y[i][j]];
			}
		}
		return x;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Integer getDifficulty() {
		return difficulty;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Integer[][] getSurface(){
		return surface;
	}

	@Override
	public String toString() {
		String s ="";
		for(int i=0;i<x;i++) {
			for(int j=0; j<y;j++){
				s = s +" "+ Integer.toString(surface[i][j]);
			}
			s += "\n";
		}
		return s;
	}
	
	public static Integer[][] create () {
		Integer[][] room = new Integer[(int) Room.GET_TOTAL_SIZE()][(int) Room.GET_TOTAL_SIZE()];
		for (int i = 0 ; i < room.length ; i++) {
			for (int j = 0 ; j < room.length ; j++) {
				room[i][j] = Room.IN_ROOM_SPACE(new Vector(i, j)) ? 1 : 0;
			}
		}
		return room;
	}

}

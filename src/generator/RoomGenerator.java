package generator;

import java.util.Random;

import utils.Vector;
import world.Room;

public class RoomGenerator {
	
	private Integer[][] surface;
	private String typeIntersection;
	private String type;
	private Integer difficulty;
	private int hauteur=11;
	private int largeur=11;
	
	public RoomGenerator(int salle,int taille) {
		hauteur = taille;
		largeur = taille;
		surface = new Integer[hauteur][largeur];
		this.typeIntersection = binarySalle(salle);
		for(int i=0; i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
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
	
	private Integer[][] combine(Integer[][] x,Integer[][] y){
		int[][] t = {
				{0, 1, 2},
				{1, 1, 1},
				{2, 1, 2}};
		for(int i=0; i<x.length;i++) {
			for(int j=0;j<x[0].length;j++) {
				x[i][j] = t[x[i][j]][y[i][j]];
			}
		}
		return x;
	}
	
	private Integer[][] randomRoom(){
		Integer[][] room = new Integer[hauteur][largeur];
		Random r = new Random();
		int x =   r.nextInt((this.hauteur/2)-1 - 2 + 1) + 2;
		int y =  r.nextInt((this.largeur/2)-1 - 2 + 1) + 2;
		
		for(int i=0;i<this.hauteur;i++) {
			for(int j=0; j<this.largeur;j++) {
				
				if(i>x && i<(this.largeur/2)+x && j>y && j<(this.largeur/2)+y ) {
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
		Integer[][] salle = new Integer[hauteur][largeur];
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				if(i<((hauteur)/2)+1&& j>((largeur)/2)-2 && j<((largeur)/2)+2) {
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
		Integer[][] salle = new Integer[hauteur][largeur];
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				if(i>((hauteur)/2)-1 && j>((largeur)/2)-2 && j<((largeur)/2)+2) {
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
		Integer[][] salle = new Integer[hauteur][largeur];
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				if(j>((largeur)/2)-1 && i>((hauteur)/2)-2 && i<((hauteur)/2)+2) {
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
		Integer[][] salle = new Integer[hauteur][largeur];
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				if(j<(largeur+1)/2 && i>((hauteur)/2)-2 && i<((hauteur)/2)+2) {
					salle[i][j] = 1;
				}

				else {
					salle[i][j] = 0;
				}
			}
		}
		return salle;
	}
	
	
	public int getHauteur() {
		return hauteur;
	}
	public int getLargeur() {
		return largeur;
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
		for(int i=0;i<hauteur;i++) {
			for(int j=0; j<largeur;j++){
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

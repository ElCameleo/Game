package main;

import java.util.Arrays;
import java.util.List;

import javafx.scene.image.WritableImage;
import utils.SpriteSheet;

public class Assets {

	private static SpriteSheet bossSpriteSheet, floorSpriteSheet, playerMonsterSpriteSheet, potionSpriteSheet;
	public static List<WritableImage> GROUND_NORMAL, GROUND_LOOT, GROUND_BOSS, GROUND_START;
	public static WritableImage DEALER, PLAYER, GOBLIN, BOAR, WIZARD;
	public static WritableImage DRAGON;
	
	public static void init () {
		bossSpriteSheet = new SpriteSheet("file:src/ressource/images/Boss.png", 288, 288, 96, 96);
		floorSpriteSheet = new SpriteSheet("file:src/ressource/images/Floor.png", 768, 576, 96, 96);
		playerMonsterSpriteSheet = new SpriteSheet("file:src/ressource/images/PlayerMonster.png", 384, 432, 48, 48);
		potionSpriteSheet = new SpriteSheet("file:src/ressource/images/Potions.png", 192, 320, 32, 32);
		
		GROUND_NORMAL = Arrays.asList(
				floorSpriteSheet.get(3, 3), 
				floorSpriteSheet.get(3, 4),
				floorSpriteSheet.get(3, 5),
				floorSpriteSheet.get(2, 5),
				floorSpriteSheet.get(1, 5)
		);
		GROUND_LOOT = Arrays.asList(
				floorSpriteSheet.get(0, 3), 
				floorSpriteSheet.get(1, 3),
				floorSpriteSheet.get(2, 3),
				floorSpriteSheet.get(0, 4),
				floorSpriteSheet.get(2, 4)
		);
		GROUND_BOSS = Arrays.asList(
				floorSpriteSheet.get(7, 0), 
				floorSpriteSheet.get(7, 1),
				floorSpriteSheet.get(6, 1),
				floorSpriteSheet.get(5, 1),
				floorSpriteSheet.get(7, 3)
		);
		GROUND_START = Arrays.asList(
				floorSpriteSheet.get(0, 0), 
				floorSpriteSheet.get(0, 1),
				floorSpriteSheet.get(0, 2),
				floorSpriteSheet.get(2, 0),
				floorSpriteSheet.get(2, 2)
		);
		
		DEALER = playerMonsterSpriteSheet.get(4, 0);
		PLAYER = playerMonsterSpriteSheet.get(2, 0);
		GOBLIN = playerMonsterSpriteSheet.get(0, 2);
		BOAR = playerMonsterSpriteSheet.get(5, 2);
		WIZARD = playerMonsterSpriteSheet.get(3, 7);
		
		DRAGON = bossSpriteSheet.get(0, 1);
	}

}

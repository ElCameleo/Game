package world;

import java.util.Random;

import javafx.scene.image.WritableImage;
import main.Assets;
import world.Room.RoomType;

public class Cell {
	
	public WritableImage img;
	public int value;

	public Cell(int value) {
		this.value = value;
		
	}
	
	public void setImageByRoomType (RoomType roomType) {
		switch (roomType) {
			case START: img = Assets.GROUND_START.get(new Random().nextInt(Assets.GROUND_START.size())); break;
			case LOOT: img = Assets.GROUND_LOOT.get(new Random().nextInt(Assets.GROUND_LOOT.size())); break;
			case NORMAL: img = Assets.GROUND_NORMAL.get(new Random().nextInt(Assets.GROUND_NORMAL.size())); break;
			case BOSS: img = Assets.GROUND_BOSS.get(new Random().nextInt(Assets.GROUND_BOSS.size())); break;
		}
	}

}

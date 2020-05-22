package world;

import java.util.ArrayList;

import main.Game;
import mob.enemy.Enemy;
import mob.enemy.Enemy1;
import mob.enemy.Enemy2;
import mob.enemy.Enemy3;
import utils.Vector;

public class Spawner {
	
	public static float CHUNK_SIZE = 3;
	
	public ArrayList<Vector> availableZone = new ArrayList<>();
	private Room room;
	private Game game;
	
	public Spawner (Game game, Room room, Vector delta) {
		this.room = room;
		this.game = game;

		createAvailableZones(delta);
		addEnemy();
	}
	
	public int getDifficultyByRoomLevel () {
		return 4;
	}
	
	public void createAvailableZones (Vector delta) {
		for (int i = 0 ; i < CHUNK_SIZE ; i++) {
			for (int j = 0 ; j < CHUNK_SIZE ; j++) {
				Vector pos = new Vector ((int) (i * Room.SIZE / CHUNK_SIZE), (int) (j * Room.SIZE / CHUNK_SIZE));
				if (room.isGround(pos)) availableZone.add(pos.add(delta));
			}
		}
	}
	
	public void addEnemy () {
		int maxDifficulty = getDifficultyByRoomLevel();
		int currentDifficulty = 0;
		while (maxDifficulty > currentDifficulty && availableZone.size() > 0) {
			int p = (int) (Math.random() * availableZone.size());
			Vector pos = availableZone.get(p);
			availableZone.remove(pos);
			Enemy enemy = new Enemy[] { new Enemy1(game, pos), new Enemy2(game, pos), new Enemy3(game, pos) } [(int) (Math.random() * 3)];
			game.handler.add(enemy);
			currentDifficulty += enemy.difficulty;
		}
	}
}

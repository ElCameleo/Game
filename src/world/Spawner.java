package world;

import java.util.ArrayList;

import main.Game;
import mob.Dealer;
import mob.enemy.Boss1;
import mob.enemy.Enemy;
import mob.enemy.Enemy1;
import mob.enemy.Enemy2;
import mob.enemy.Enemy3;
import utils.Vector;

public class Spawner {
	
	public static float CHUNK_SIZE = 5;
	
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
				Vector pos = new Vector (((i+0.5f) * Room.SIZE / CHUNK_SIZE), (j+0.0f) * Room.SIZE / CHUNK_SIZE);
				if (room.isGround(pos)) availableZone.add(pos.add(delta));
			}
		}
	}
	
	public Vector getRandomPos () {
		if (availableZone.size() != 0) {
			int p = (int) (Math.random() * availableZone.size());
			Vector pos = availableZone.get(p);
			if (pos != null) availableZone.remove(p);
			return pos;
		} else {
			return null;
		}
	}
	
	public void addEnemy () {
		switch (room.type) {
			case NORMAL: addEnemyNormalRoom(); break;
			case BOSS: addEnemyBossRoom(); break;
			case LOOT: addEnemyLootRoom(); break;
			case START: break;
			case END: break;
		}	
	}
	
	public void addEnemyNormalRoom () {
		int maxDifficulty = getDifficultyByRoomLevel();
		int currentDifficulty = 0;
		while (maxDifficulty > currentDifficulty && availableZone.size() > 0) {
			Vector pos = getRandomPos();
			Enemy enemy = new Enemy[] { new Enemy1(game, pos), new Enemy2(game, pos), new Enemy3(game, pos) } [(int) (Math.random() * 3)];
			game.handler.add(enemy);
			currentDifficulty += enemy.difficulty;
		}
	}
	
	public void addEnemyBossRoom() {
		Vector pos = getRandomPos();
		if (pos != null) game.handler.add(new Boss1(game, pos));
	}
	
	public void addEnemyLootRoom() {
		Vector pos = getRandomPos();
		if (pos != null) game.handler.add(new Dealer(game, pos));
	}
}

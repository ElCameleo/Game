package world;

import java.util.ArrayList;

import main.Game;
import mob.Dealer;
import mob.enemy.BlackDragon;
import mob.enemy.Boar;
import mob.enemy.Enemy;
import mob.enemy.Ghost;
import mob.enemy.Goblin;
import mob.enemy.MegaGoblin;
import mob.enemy.Minotaure;
import mob.enemy.RedDragon;
import mob.enemy.Skeleton;
import mob.enemy.Spider;
import mob.enemy.WhiteDragon;
import mob.enemy.Wizard;
import mob.enemy.Zombie;
import utils.Border;
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
		addEnemy(delta);
	}
	
	public int getDifficultyByRoomLevel () {
		return room.difficulty * (game.level);
	}
	
	public void createAvailableZones (Vector delta) {
		for (int i = 0 ; i < CHUNK_SIZE ; i++) {
			for (int j = 0 ; j < CHUNK_SIZE ; j++) {
				Vector pos = new Vector ((int) (i * Room.SIZE / CHUNK_SIZE),(int) (j * Room.SIZE / CHUNK_SIZE));
				Border border = new Border((int)pos.x - 1, (int)pos.y - 1, 2, 2);
				if (room.isGround(border.topLeft) && room.isGround(border.topRight) && room.isGround(border.downLeft) && room.isGround(border.downRight)) availableZone.add(pos.add(delta));
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
	
	public void addEnemy (Vector delta) {
		switch (room.type) {
			case NORMAL: addEnemyNormalRoom(); break;
			case BOSS: addEnemyBossRoom(delta); break;
			case LOOT: addEnemyLootRoom(delta); break;
			case START: break;
			case END: break;
		}	
	}
	
	private Enemy getEnemy (Vector pos) {
		switch (game.level) {
			case 1: return new Enemy[] { new Goblin(game, pos), new Boar(game, pos) } [(int) (Math.random() * 2)]; 
			case 2: return new Enemy[] { new Goblin(game, pos), new Boar(game, pos), new Wizard(game, pos) } [(int) (Math.random() * 3)];
			case 3: return new Enemy[] { new Wizard(game, pos), new Spider(game, pos), new Skeleton(game, pos) } [(int) (Math.random() * 3)];
			case 4: return new Enemy[] { new Spider(game, pos), new Skeleton(game, pos), new Zombie(game, pos) } [(int) (Math.random() * 3)];
			case 5: return new Enemy[] { new Skeleton(game, pos), new Zombie(game, pos), new Ghost(game, pos) } [(int) (Math.random() * 3)];
		}
		return null;
	}
	
	public void addEnemyNormalRoom () {
		int maxDifficulty = getDifficultyByRoomLevel();
		int currentDifficulty = 0;
		while (maxDifficulty > currentDifficulty && availableZone.size() > 0) {
			Vector pos = getRandomPos();
			Enemy enemy = getEnemy(pos);
			game.handler.addMob(enemy);
			currentDifficulty += enemy.difficulty;
		}
	}
	
	public void addEnemyBossRoom(Vector delta) {
		Vector pos = new Vector((int) (0.5f* Room.SIZE), (int)(0.5f* Room.SIZE));
		switch (game.level) {
			case 1: game.handler.addMob(new WhiteDragon(game, pos.add(delta))); break;
			case 2: game.handler.addMob(new BlackDragon(game, pos.add(delta))); break;
			case 3: game.handler.addMob(new MegaGoblin(game, pos.add(delta))); break;
			case 4: game.handler.addMob(new Minotaure(game, pos.add(delta))); break;
			case 5: game.handler.addMob(new RedDragon(game, pos.add(delta))); break;
		}
		
	}
	
	public void addEnemyLootRoom(Vector delta) {
		Vector pos = new Vector((int) (0.5f* Room.SIZE), (int)(0.5f* Room.SIZE));
		game.handler.addMob(new Dealer(game, pos.add(delta)));
	}
}

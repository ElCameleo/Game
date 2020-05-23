package item.potion;

import main.Game;

public class LifePotion extends Potion {

	public LifePotion(Game game ) {
		super("LIFE_POTION", game, 3);
	}

	@Override
	public void apply() {
		game.player.life += 20;
	}
}

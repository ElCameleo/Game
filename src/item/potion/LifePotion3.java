package item.potion;

import main.Game;

public class LifePotion3 extends Potion {

	public LifePotion3(Game game) {
		super("Potion de vie 3", game, 20, "Recupere 150 point de vie");
	}

	@Override
	public void apply() {
		game.player.addLife(150);
	}
	
}

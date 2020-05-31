package item.potion;

import main.Game;

public class LifePotion2 extends Potion {

	public LifePotion2(Game game) {
		super("Potion de vie 2", game, 10, "Recupere 80 point de vie");
	}

	@Override
	public void apply() {
		game.player.addLife(80);
	}
	
}

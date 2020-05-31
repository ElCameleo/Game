package item.potion;

import main.Game;

public class LifePotion1 extends Potion {

	public LifePotion1(Game game) {
		super("Potion de vie 1", game, 5, "Recupere 40 point de vie");
	}

	@Override
	public void apply() {
		game.player.addLife(40);
	}
	
}

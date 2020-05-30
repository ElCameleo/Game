package item.potion;

import main.Game;

public class SpeedPotion2 extends Potion {

	public SpeedPotion2(Game game) {
		super("Potion de vitesse 2", game, 25, "Augmente la vitesse");
	}

	@Override
	public void apply() {
		game.player.addSpeed(0.01f);
	}
	
}

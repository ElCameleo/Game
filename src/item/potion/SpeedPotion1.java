package item.potion;

import main.Game;

public class SpeedPotion1 extends Potion {

	public SpeedPotion1(Game game) {
		super("Potion de vitesse 1", game, 8, "Augmente légérement la vitesse");
	}

	@Override
	public void apply() {
		game.player.addSpeed(0.005f);
	}
	
}

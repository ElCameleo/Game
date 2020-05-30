package item.potion;

import main.Game;

public class BoostWeapon2 extends Potion {

	public BoostWeapon2(Game game) {
		super("Boost d'Arme 2", game, 30, "Améliore votre arme");
	}

	@Override
	public void apply() {
		game.player.weapon.attack *= 1.3;
		game.player.weapon.coolDown *= 0.9;
	}
	
}

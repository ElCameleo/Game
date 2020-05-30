package item.potion;

import main.Game;

public class BoostWeapon1 extends Potion {

	public BoostWeapon1(Game game) {
		super("Boost d'Arme 1", game, 10, "Améliore légérement votre arme");
	}

	@Override
	public void apply() {
		game.player.weapon.attack *= 1.1;
	}
	
}

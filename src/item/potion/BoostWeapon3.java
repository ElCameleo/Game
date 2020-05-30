package item.potion;

import main.Game;

public class BoostWeapon3 extends Potion {

	public BoostWeapon3(Game game) {
		super("Boost d'Arme Ultime", game, 50, "Améliore beaucoup votre arme");
	}

	@Override
	public void apply() {
		game.player.weapon.attack *= 1.5;
		game.player.weapon.coolDown *= 0.9;
		game.player.weapon.radius *= 1.2;
	}
	
}

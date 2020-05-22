package item.potion;

import main.Game;

public class LifePotion extends Potion {
	int price;
	public LifePotion(Game game,int price) {
		super("LIFE_POTION", game, price);
		this.price = price;
	}

	@Override
	public void apply() {
		game.player.life += 20;
	}
}

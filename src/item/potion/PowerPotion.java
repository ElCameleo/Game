package item.potion;


import java.awt.event.ActionListener;
import java.util.Timer;

import javafx.event.ActionEvent;
import main.Game;
import utils.Vector;

public class PowerPotion extends Potion {
	int price;
	@SuppressWarnings("unused")
	private Timer timerOnPotionEffects () {
	    ActionListener potioneffects = new ActionListener () {
	    	@Override
	    	public void actionPerformed (ActionEvent event) {
	    		game.player.attack += 5;
	    	}
	    };
	    return new Timer (10000, potioneffects);
	}
	    
	public PowerPotion(Game game,int price) {
		super("LIFE_POTION", game, price);
		this.price = price;
	}
	
	@Override
	public void apply() {
		timerOnPotionEffects ();
		Vector potion = new Vector(32, 32);
		Vector monster = new Vector(48, 48);
		Vector floor = new Vector(96, 96);
		Vector boss = new Vector(96, 96);
	}
}

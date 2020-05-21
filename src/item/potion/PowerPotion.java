package item.potion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import main.Game;

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
	}
}

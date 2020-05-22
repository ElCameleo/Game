package mob;

import item.potion.Bag;
import item.weapon.Spear;
import item.weapon.Weapon;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import main.Game;
import main.GameObject;
import scene.Shop;
import utils.Vector;

public class Player extends Mob {
	
	private int[] controls = { 0, 0, 0, 0 };
	public Weapon weapon;
	public Bag bag;

	public Player(Game game, Vector position) {
		super(game, "PLAYER", position, new Vector(1, 1), Color.DARKRED, 0.4f, 10);
		game.scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
		game.scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
		
		weapon = new Spear(20);
		bag = new Bag(game);
	}
	
	private EventHandler<KeyEvent> keyPressedEventHandler = (event -> {
    	switch (event.getCode().ordinal()) {
    		case 52: controls[0] = 1; break;
    		case 61: controls[1] = 1; break;
    		case 39: controls[2] = 1; break;
    		case 54: controls[3] = 1; break;
    	}
    });

    private EventHandler<KeyEvent> keyReleasedEventHandler = (event -> {
    	switch (event.getCode().ordinal()) {
			case 52: controls[0] = 0; break;
			case 61: controls[1] = 0; break;
			case 39: controls[2] = 0; break;
			case 54: controls[3] = 0; break;
			case 11: openShop(); break;
    	}
    });
    
    public void openShop() {
    	for (GameObject obj: game.handler) {
    		if (obj.name == "DEALER") {
    			if (Vector.dist(this.position, obj.getPosition()) < 3) {
    				Shop shop = new Shop(10);
    				Scene shopScene = new Scene(shop);
    				shop.setGame(game);
    				shop.printStore(new Dealer(game,new Vector(0,0)), this.bag); //Vector modifiable
    				//shop.addGoodies(((Dealer) obj).getStore());
    				game.stage.setScene(shopScene);
    			}
    		}
    	}
    }

	@Override
	public Vector move() {
		return new Vector((controls[2] - controls[0]) * speed, (controls[3] - controls[1]) * speed);
	}
	public Weapon getWeapon() {
		return(this.weapon);
	}
	public Bag getBag() {
		return(this.bag);
	}
	public void checkDurability(Weapon weapon) {
		if(weapon.getDurability() == 0) {  //Penser à enlever -1 en durabilité à chaque appel de la fonction attaquer() dans player
			this.weapon = new Hand(); 
		}
	}
}

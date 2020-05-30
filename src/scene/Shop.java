package scene;

import item.Bag;
import item.Item;
import item.potion.Potion;
import item.weapon.Weapon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.Game;
import mob.Dealer;

public class Shop extends VBox {
	
	public Button quitBtn;
	private Game game;
	
	public Shop(double spacing) {
		super(spacing);
	}
	
	
	public void printStore(Game game, Dealer d) {
		
		Label title = new Label("Bienvenue dans mon magasin !");
		title.setFont(Font.font ("Verdana", 50));
		
		Label gold = new Label("Vous avez " + game.player.gold + " piece d'or");
		gold.setFont(Font.font ("Verdana", 20));
		
		quitBtn = new Button();
		quitBtn.setText("Retourner au jeu");
		quitBtn.setFont(Font.font ("Verdana", 20));
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(title, gold);
		
		
		class ItemButton {
			public Button btn;
			public ItemButton (Shop shop, Dealer dealer, Item item) {
				if (item instanceof Potion) {
					btn = new Button(item.name + ": " + item.price + " pieces d'or (Effet : " + ((Potion)item).description + ')');
					btn.setOnAction(e -> {
						if (game.player.gold > item.price && game.player.bag.size() < Bag.MAX_SIZE) {
							shop.getChildren().remove(btn);
							game.player.gold -= item.price;
							gold.setText("Vous avez " + game.player.gold + " piece d'or");
							dealer.store.remove(item);
							game.player.bag.add((Potion) item);
						}
					});	
				} else {
					btn = new Button(item.name + ": " + item.price + " pieces d'or (DPS : " + ((Weapon)item).getDPS() + ')');
					btn.setOnAction(e -> {
						if (game.player.gold >= item.price) {
							shop.getChildren().remove(btn);
							game.player.gold -= item.price;
							gold.setText("Vous avez " + game.player.gold + " piece d'or");
							dealer.store.remove(item);
							game.player.weapon = (Weapon) item;
						}
					});
				}
				
				
			}
		}
		
		for (Item p : d.getStore()) {
			ItemButton itemButton = new ItemButton(this, d, p);
			this.getChildren().add(itemButton.btn);
		}
		
		quitBtn.setOnAction((e) -> {
			game.stage.setScene(Game.scene);
        });
		
		this.getChildren().add(quitBtn);
	}
}



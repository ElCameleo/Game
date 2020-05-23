package scene;

import item.Item;
import item.potion.Bag;
import item.potion.LifePotion;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.Game;
import mob.Dealer;
import mob.Dealer.Possession;

public class Shop extends VBox {
	
	public Button quitBtn;
	
	public Shop(double spacing) {
		super(spacing);
	}
	
	
	public void setGame(Game game) {
		quitBtn.setOnAction((e) -> {
			game.stage.setScene(Game.scene);
        });
	}
	
	
	
	public void printStore(Dealer d, Bag bag) {
		
		Label title = new Label("Bienvenue dans mon magasin !");
		title.setFont(Font.font ("Verdana", 50));
		
		quitBtn = new Button();
		quitBtn.setText("Retourner au jeu");
		quitBtn.setFont(Font.font ("Verdana", 20));
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(title);
		
		
		class ItemButton {
			public Button btn;
			public ItemButton (Possession possession) {
				btn = new Button(possession.potion.name + ": Prix -> " + possession.potion.getPrice() + " | Nombre article restant -> " + possession.compteur);
				btn.setOnAction(e -> {
					possession.compteur--;
					btn.setText(possession.potion.name + ": Prix -> " + possession.potion.getPrice() + " | Nombre article restant -> " + possession.compteur);
				});
			}
		}
		
		for (Possession p : d.getStore()) {
			ItemButton itemButton = new ItemButton(p);
			this.getChildren().add(itemButton.btn);
		}
		
		this.getChildren().add(quitBtn);
	}
}



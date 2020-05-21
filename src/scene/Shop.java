package scene;
import item.potion.Bag;
import item.potion.LifePotion;
import item.potion.MegaLifePotion;
import item.potion.PowerPotion;
import item.Item;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.Game;
import mob.Dealer;

public class Shop extends VBox {
	public Button quitBtn;
	Button LifePotionButton;
	Button PowerPotionButton;
	Button MegaLifePotionButton;
	public Shop(double spacing) {
		super(spacing);
		
		Label title = new Label("Bienvenue dans mon magasin !");
		title.setFont(Font.font ("Verdana", 50));
		
		quitBtn = new Button();
		quitBtn.setText("Retourner au jeu");
		quitBtn.setFont(Font.font ("Verdana", 20));
		
		LifePotionButton = new Button("Potion de vie : Prix -> "+2+" | Nombre article restant -> "+5);
		MegaLifePotionButton = new Button("Super potion de vie : Prix -> "+5+" | Nombre article restant -> "+5);
		PowerPotionButton = new Button("Potion de force : Prix -> "+3+" | Nombre article restant -> "+5);
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(title, LifePotionButton,MegaLifePotionButton,PowerPotionButton,quitBtn);
		
	}
	
	
	public void setGame(Game game) {
		quitBtn.setOnAction((e) -> {
			game.stage.setScene(Game.scene);
        });
	}
	
	
	
	public void printStore(Dealer d, Bag bag) {
		int [] counter_list = d.itemCount(d.getList());
		LifePotionButton.setOnAction(e -> {
			if(e.getSource() == LifePotionButton) {
				if(counter_list[0]>0) {
					counter_list[0] = counter_list[0]-1;
					LifePotionButton.setText("Potion de vie : Prix -> "+2+" | Nombre article restant -> "+counter_list[0]);
				}
				for(Item obj : d.getList()) {
					if(obj instanceof LifePotion) {
						bag.addPotion((LifePotion) obj);
						d.getList().remove(obj);
						break;
					}
				}
			}
		});
		
		MegaLifePotionButton.setOnAction(e -> {
					
			if(e.getSource() == MegaLifePotionButton) {
				if(counter_list[1]>0) {
					counter_list[1] = counter_list[1]-1;
					MegaLifePotionButton.setText("Super potion de vie : Prix -> "+5+" | Nombre article restant -> "+counter_list[1]);	
				}
				for(Item obj : d.getList()) {
					if(obj instanceof MegaLifePotion) {
						bag.addPotion((MegaLifePotion) obj);
						d.getList().remove(obj);
						break;
					}
				}
			}
		});
		
		PowerPotionButton.setOnAction(e -> {
					
			if(e.getSource() == PowerPotionButton) {
				if(counter_list[2]>0) {
					counter_list[2] = counter_list[2]-1;
					PowerPotionButton.setText("Potion de force : Prix -> "+8+" | Nombre article restant -> "+counter_list[2]);	
				}
				for(Item obj : d.getList()) {
					if(obj instanceof PowerPotion) {
						bag.addPotion((PowerPotion) obj);
						d.getList().remove(obj);
						break;
					}
				}
			}
		});
	}
}



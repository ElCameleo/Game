package scene;

import java.util.ArrayList;

import item.Item;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.Game;

public class Shop extends VBox {
	
	class Box extends VBox {
		public Button btn;
		public Box(String title) {
			btn = new Button();
			btn.setText(title);
			btn.setFont(Font.font ("Verdana", 20));
			btn.setAlignment(Pos.CENTER);
			this.getChildren().addAll(btn);
		}
	}
	

	public Button quitBtn;
	public HBox buttons;

	public Shop(double spacing) {
		super(spacing);
		
		Label title = new Label("Shop du Turfu");
		title.setFont(Font.font ("Verdana", 50));
		title.setAlignment(Pos.TOP_CENTER);
		
		
		
		buttons = new HBox(4);
		
		quitBtn = new Button();
		quitBtn.setText("Retourner au jeu");
		quitBtn.setFont(Font.font ("Verdana", 20));
		quitBtn.setAlignment(Pos.CENTER);
		
		buttons.getChildren().addAll(new Box("Object1"), new Box("Object2"), new Box("Object3"));
		
		this.getChildren().addAll(title, buttons, quitBtn);
		
	}

	public void setGame(Game game) {
		quitBtn.setOnAction((e) -> {
			game.stage.setScene(Game.scene);
        });
	}
	
	public void addGoodies(ArrayList<Item> items) {
		int[] idx = { 0 };
		buttons.getChildren().forEach((e) -> {
			((Box) e).btn.setText(items.get(idx[0]).name);
			idx[0]++;
		});
	}


}

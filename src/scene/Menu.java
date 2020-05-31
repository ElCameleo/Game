package scene;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.Game;

public class Menu extends VBox {

	public Menu(Game game) {
		super(30);
		Label title = new Label(Game.NAME);
		title.setFont(Font.font ("Verdana", 100));
		
		Button startBtn = new Button();
		startBtn.setText("Lancez une nouvelle partie");
		startBtn.setFont(Font.font ("Verdana", 20));
		startBtn.setOnAction((e) -> {
			game.reload();
			game.stage.setScene(game.scene);
        });
		
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(title, startBtn);
	}


}

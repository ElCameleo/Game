package scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Game;

public class GameOver extends VBox {

	public GameOver() {
		super(10);
		
	}
	
	
	public void showGameOver (Game game, boolean hasWin) {
		if (!hasWin) {
			Label title = new Label("GAME OVER");
			title.setFont(Font.font ("Verdana", 100));
			
			Label score = new Label("Vous avez perdu au niveau " + game.level);
			score.setFont(Font.font ("Verdana", 40));
			
			Button quitBtn = new Button();
			quitBtn.setText("Retourner au menu");
			quitBtn.setFont(Font.font ("Verdana", 20));
			quitBtn.setOnAction((e) -> {
				Menu m = new Menu(game);
				Scene mScene = new Scene(m);
				game.stage.setScene(mScene);
	        });
			
			this.setAlignment(Pos.CENTER);
			this.getChildren().addAll(title, score, quitBtn);
		} else {
			Label title = new Label("BRAVO");
			title.setFont(Font.font ("Verdana", 100));
			
			Label score = new Label("Vous avez gagné");
			score.setFont(Font.font ("Verdana", 40));
			
			Button quitBtn = new Button();
			quitBtn.setText("Retourner au menu");
			quitBtn.setFont(Font.font ("Verdana", 20));
			quitBtn.setOnAction((e) -> {
				Menu m = new Menu(game);
				Scene mScene = new Scene(m);
				game.stage.setScene(mScene);
	        });
			
			this.setAlignment(Pos.CENTER);
			this.getChildren().addAll(title, score, quitBtn);
		}
	}

}

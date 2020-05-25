package ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import main.GameObject;
import mob.Player;
import utils.Vector;

public class LifeBar extends GameObject {
	
	private Player player;

	public LifeBar(Game game, Player player) {
		super(game, "LifeBar", new Vector(20, 40), new Vector(250, 20));
		this.player = player;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(GraphicsContext gc) {
		float ratio = player.life / player.maxLife;
		
		gc.setFill(Color.GREEN);
		gc.fillRect(position.x, position.y, ratio * size.x, size.y);
		gc.setFill(Color.RED);
		gc.fillRect(position.x + ratio * size.x, position.y, size.x - ratio * size.x, size.y);
		gc.fillText("Vie : " + player.life + " / " + player.maxLife, position.x + size.x/2, position.y + 2 * size.y);
		

	}

	@Override
	public boolean checkIfDead() {
		// TODO Auto-generated method stub
		return false;
	}

}

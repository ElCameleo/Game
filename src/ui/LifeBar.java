package ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import main.GameObject;
import main.Renderer;
import mob.Mob;
import utils.Vector;

public class LifeBar extends GameObject {
	
	private Mob mob;

	public LifeBar(Game game, Mob mob) {
		//super(game, "LifeBar", new Vector(20, 40), new Vector(250, 20));
		super(game, "LifeBar", new Vector(20, 40), new Vector(30, 5));
		this.mob = mob;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(GraphicsContext gc) {
		float ratio = (mob.life < 0 ? 0 : mob.life)  / mob.maxLife;
		/*
		gc.setFill(Color.GREEN);
		gc.fillRect(position.x, position.y, ratio * size.x, size.y);
		gc.setFill(Color.RED);
		gc.fillRect(position.x + ratio * size.x, position.y, size.x - ratio * size.x, size.y);
		gc.fillText("Vie : " + mob.life + " / " + mob.maxLife, position.x + size.x/2, position.y + 2 * size.y);
		*/
		
		gc.setFill(Color.GREEN);
		gc.fillRect((mob.getPosition().x - mob.getSize().x/2) * Renderer.CELLSIZE, (mob.getPosition().y - 3 * mob.getSize().y/4) * Renderer.CELLSIZE, ratio * size.x, size.y);
		gc.setFill(Color.RED);
		gc.fillRect((mob.getPosition().x - mob.getSize().x/2) * Renderer.CELLSIZE + ratio * size.x, (mob.getPosition().y - 3 * mob.getSize().y/4) * Renderer.CELLSIZE, size.x - ratio * size.x, size.y);

	}

	@Override
	public boolean checkIfDead() {
		// TODO Auto-generated method stub
		return false;
	}

}

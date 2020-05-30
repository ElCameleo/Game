package mob.enemy;

import item.weapon.Spell;
import javafx.scene.canvas.GraphicsContext;
import main.Assets;
import main.Game;
import main.Renderer;
import utils.Vector;

public class Ghost extends Enemy {
	
	public float frameCount = 0;

	public Ghost(Game game, Vector position) {
		super(game, "GHOST", position, new Vector(1, 1), Assets.GHOST, 0.04f, 50, 5, new Spell());
	}
	
	@Override
	public void update() {
		super.update();
		frameCount++;
		if (frameCount > 200) frameCount = 0;
	}
	
	@Override
	public void render(GraphicsContext gc) {
		if (frameCount > 100) {
			gc.drawImage(img, (position.x - size.x/2) * Renderer.CELLSIZE , (position.y - size.y/2) * Renderer.CELLSIZE, size.x * Renderer.CELLSIZE, size.y * Renderer.CELLSIZE);
			lifeBar.render(gc);
		}
	}

}

package mob;

import item.weapon.Weapon;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import main.GameObject;
import utils.Border;
import utils.Vector;

public class DamageZone extends GameObject {
	
	private Mob mob;
	private Border border;
	private Weapon w;

	public DamageZone(Game game, Mob mob) {
		super(game, "DAMAGE_ZONE", mob.getZone(), new Vector(1, 1));
		border = calculBorders();
		w = mob.weapon;
		if (mob.name == "PLAYER") {
			for (GameObject other: game.handler) {
				if (mob != other && other instanceof Mob) {
					Border otherBorder = other.calculBorders();
					Mob m = (Mob) other;
					if (game.handler.collide(border, otherBorder)) {
						m.isHit(w);
						return;
					}
				}
			}
		} else {
			Border otherBorder = game.player.calculBorders();
			if (game.handler.collide(border, otherBorder)) {
				game.player.isHit(w);
			}
		}
	}

	@Override
	public void update() {
		
	}

	@Override
	public void render(GraphicsContext gc) {
		border.fill(gc, Color.MEDIUMPURPLE);
	}

	@Override
	public boolean checkIfDead() {
		return true;
	}

}

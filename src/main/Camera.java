package main;

import javafx.scene.canvas.GraphicsContext;
import utils.Border;
import utils.Vector;

public class Camera {
	
	private GraphicsContext gc;
	private Game game;
	
	public Camera (Game game, GraphicsContext gc) {
		this.gc = gc;
		this.game = game;
	}
	
	public void startTranslate () {
		gc.save();
		translate();
	}
	
	public Vector getCameraTranslate () {
		return new Vector(
			-game.player.getPosition().x * Renderer.CELLSIZE + Renderer.WIDTH/2,
			-game.player.getPosition().y * Renderer.CELLSIZE + Renderer.HEIGHT/2
		);
	}
	
	public Border getBorders () {
		Vector cameraTranslate = getCameraTranslate().multiply(-1);
		return new Border(
			new Vector(cameraTranslate.x, cameraTranslate.y),
			new Vector(cameraTranslate.x + Renderer.WIDTH, cameraTranslate.y),
			new Vector(cameraTranslate.x, cameraTranslate.y + Renderer.HEIGHT),
			new Vector(cameraTranslate.x + Renderer.WIDTH, cameraTranslate.y + Renderer.HEIGHT)
		);
	}
	
	public void translate () {
		Vector cameraTranslate = getCameraTranslate();
		gc.translate(cameraTranslate.x, cameraTranslate.y);	
	}
	
	public void endTranslate () {
		gc.restore();
	}


}

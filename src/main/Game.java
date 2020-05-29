package main;

import generator.WorldGenerator;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import mob.Player;
import mob.enemy.Enemy;
import mob.enemy.Enemy2;
import pathfinding.PathFinding;
import scene.Shop;
import ui.LifeBar;
import world.World;

public class Game extends Application {
	
	public static String NAME = "Game Name";
	
	public World world;
	public static Scene scene;
	public Handler handler;
	public Player player;
	public Shop shop;
	public Stage stage;
	public Camera camera;
	public LifeBar lifeBar;
	public int count = 0;
	
	public void setup (GraphicsContext gc) {
		gc.setTextAlign(TextAlignment.CENTER);
		camera = new Camera(this, gc);
		handler = new Handler(this);
		world = WorldGenerator.create(this);
		PathFinding.init(world);
		player = new Player(this, world.getStartPosition());
		handler.addMob(player);
		world.populate();
		lifeBar = new LifeBar(this, player);	
	}
	
	public void updatePerSecond () {
		for (GameObject obj: handler) {
			if (obj instanceof Enemy) {
				Enemy enemy = (Enemy) obj;
				if (enemy.isOnScreen()) enemy.calculatePath();
			}
		}
	}
	
	public void update (GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, Renderer.WIDTH, Renderer.HEIGHT);
		camera.startTranslate();
		world.render(gc);
		handler.process(gc);
		gc.setFill(Color.DARKGREY);
		gc.fillRect(10 * Renderer.CELLSIZE, 10 * Renderer.CELLSIZE, Renderer.CELLSIZE, Renderer.CELLSIZE);
		camera.endTranslate();
		player.weapon.render(gc, 0, 0);
		player.bag.render(gc);
		lifeBar.render(gc);
	}
	
	@Override
	public void start(Stage stage) throws Exception {	
		this.stage = stage;
		stage.setTitle(NAME);
        stage.setWidth(Renderer.WIDTH);
		stage.setHeight(Renderer.HEIGHT);
		
		StackPane root = new StackPane();
        scene = new Scene(root);
        stage.setScene(scene);
       
        
        Canvas canvas = new Canvas(Renderer.WIDTH, Renderer.HEIGHT);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        setup(gc);
        
        new AnimationTimer() {
            @Override
			public void handle(long currentNanoTime) {
                update(gc);
                if (count % 30 == 0) {
                	updatePerSecond();
                }
                count++;
            }
        }.start();
        stage.show();	
	}

}

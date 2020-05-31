package main;

import generator.WorldGenerator;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import mob.Player;
import mob.enemy.Enemy;
import pathfinding.PathFinding;
import scene.GameOver;
import scene.Menu;
import scene.Shop;
import world.World;

public class Game extends Application {
	
	public static String NAME = "RododinDonjon";
	
	public World world;
	public static Scene scene;
	public Handler handler;
	public Player player;
	public Shop shop;
	public Stage stage;
	public Camera camera;
	public int count = 0;
	
	public int level = 1;
	public boolean playing = false;
	
	public void setup (GraphicsContext gc) {
		Assets.init();
		gc.setTextAlign(TextAlignment.CENTER);
		camera = new Camera(this, gc);
		Menu m = new Menu(this);
		Scene mScene = new Scene(m);
		stage.setScene(mScene);
	}
	
	public void reload () {
		count = 0;
		level = 1;
		handler = new Handler(this);
		world = WorldGenerator.create(this);
		PathFinding.init(world);
		player = new Player(this, world.getStartPosition());
		handler.addMob(player);
		world.populate();
		playing = true;
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
		camera.endTranslate();
		player.weapon.render(gc, 0, 0);
		player.bag.render(gc);
		gc.setFont(new Font("Verdana", 20));
		gc.setFill(Color.WHITE);
		gc.fillText("Nombre d'ennemis restant : " + handler.mobCount, 180, 60);
		gc.setFill(Color.GOLD);
		gc.fillText("OR : " + player.gold, 180, 90);
		
		if (handler.mobCount == 0) {
			level++;
			if (level == 6) {
				GameOver go = new GameOver();
				go.showGameOver(this, true);
				Scene goScene = new Scene(go, Color.BLACK);
				stage.setScene(goScene);
				playing = false;
				return;
			}
			this.player.updateMaxLife();
			handler.clear();
			world = WorldGenerator.create(this);
			PathFinding.init(world);
			player.setPosition(world.getStartPosition());
			handler.addMob(player);
			world.populate();
			
		}
		
		if (player.checkIfDead()) {
			GameOver go = new GameOver();
			go.showGameOver(this, false);
			Scene goScene = new Scene(go, Color.BLACK);
			stage.setScene(goScene);
			playing = false;
		}
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
            	if (playing) {
	                update(gc);
	                if (count % 30 == 0) {
	                	updatePerSecond();
	                }
	                count++;
            	}
            }
        }.start();
        stage.show();	
	}

}

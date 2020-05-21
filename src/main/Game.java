package main;

import generator.WorldGenerator;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mob.Dealer;
import mob.Player;
import scene.Shop;
import utils.Vector;
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
	
	public void setup (GraphicsContext gc) {
		world = WorldGenerator.create(this);
		camera = new Camera(this, gc);
		handler = new Handler(this);
		player = new Player(this, world.getStartPosition());
		handler.addMob(player);
		handler.addMob(new Dealer(this, new Vector(6, 6)));
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
            }
        }.start();
        stage.show();	
	}

}

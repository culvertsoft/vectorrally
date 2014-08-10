package se.culvertsoft.vectorrally;

import java.util.ArrayList;

import se.culvertsoft.vectorrally.model.Game;
import se.culvertsoft.vectorrally.model.GameState;
import se.culvertsoft.vectorrally.model.Map;
import se.culvertsoft.vectorrally.model.MapObject;
import se.culvertsoft.vectorrally.model.Model;
import se.culvertsoft.vectorrally.model.ScreenState;
import se.culvertsoft.vectorrally.model.entity.Car;
import se.culvertsoft.vectorrally.model.util.Vector2;
import se.culvertsoft.vectorrally.model.wish.Wish;
import se.culvertsoft.vectorrally.network.Network;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class VectorRally extends com.badlogic.gdx.Game {
	SpriteBatch batch;
	BitmapFont font;
	Game gameWorld;
	String myName = "Player 1";
	private Model model;

	public void create() {
		Network.initialize("localhost", 1337);
		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		ArrayList<MapObject> mo = new ArrayList<>();
		mo.add(new Car(new Vector2(0, 0), myName, new Vector2(0, 0),
				new Vector2(0, 0)));
		
		mo.add(new Car(new Vector2(2, 2), "Other Player", new Vector2(2, 2),
				new Vector2(3, 1)));
		
		Map map = new Map(10, 10, mo);
		gameWorld = new Game(GameState.starting, 1, map);
		
		model = new Model(gameWorld, ScreenState.main);

		this.setScreen(new MenuScreen(this));
	}
	
	public void render() {
		while(Network.hasWishes()){
			Network.getWish().applyTo(model);
		}
		super.render();
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}

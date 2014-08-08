package se.culvertsoft.vectorrally;

import java.util.ArrayList;

import se.culvertsoft.vectorrally.model.Game;
import se.culvertsoft.vectorrally.model.Map;
import se.culvertsoft.vectorrally.model.MapObject;
import se.culvertsoft.vectorrally.model.entity.Car;
import se.culvertsoft.vectorrally.model.util.Vector2;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class VectorRally extends com.badlogic.gdx.Game {
	SpriteBatch batch;
	BitmapFont font;
	Game gameWorld;
	String myName = "Player 1";

	public void create() {
		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		ArrayList<MapObject> mo = new ArrayList<>();
		mo.add(new Car(new Vector2(0, 0), myName, new Vector2(0, 0),
				new Vector2(0, 0)));
		
		mo.add(new Car(new Vector2(2, 2), "Other Player", new Vector2(2, 2),
				new Vector2(3, 1)));
		
		Map map = new Map(10, 10, mo);
		gameWorld = new Game(1, map);

		this.setScreen(new MenuScreen(this));
	}

	public void render() {
		super.render(); // important!
	}

	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}

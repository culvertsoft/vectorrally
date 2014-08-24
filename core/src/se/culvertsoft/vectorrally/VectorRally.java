package se.culvertsoft.vectorrally;

import java.util.ArrayList;
import java.util.List;

import se.culvertsoft.vectorrally.model.Game;
import se.culvertsoft.vectorrally.model.GameMap;
import se.culvertsoft.vectorrally.model.GameState;
import se.culvertsoft.vectorrally.model.Model;
import se.culvertsoft.vectorrally.model.ScreenState;
import se.culvertsoft.vectorrally.model.entity.Car;
import se.culvertsoft.vectorrally.model.entity.CarColor;
import se.culvertsoft.vectorrally.model.entity.Entity;
import se.culvertsoft.vectorrally.model.entity.Goal;
import se.culvertsoft.vectorrally.model.entity.Start;
import se.culvertsoft.vectorrally.model.entity.Wall;
import se.culvertsoft.vectorrally.model.util.Vector2;
import se.culvertsoft.vectorrally.network.Network;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class VectorRally extends com.badlogic.gdx.Game {
	SpriteBatch batch;
	BitmapFont font;
	Game gameWorld;
	String myName = "Player 1";
	private Model model;

	@Override
	public void create() {
		Network.initialize("localhost", 1337);
		batch = new SpriteBatch();
		// Use LibGDX's default Arial font.
		font = new BitmapFont();
		ArrayList<Entity> entities = new ArrayList<>();
		GameMap map = new GameMap();
		map.setObjects(entities);

		createWalls(entities);
		createCars(entities);
		createGoals(entities);
		createStarts(entities);

		gameWorld = new Game(GameState.STARTING, 1, map);

		model = new Model(gameWorld, ScreenState.MAIN);

		this.setScreen(new MenuScreen(this));
	}

	private void createStarts(List<Entity> entities) {
		int[][] wallPos = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } };
		for (int[] pos : wallPos) {
			int x = pos[0];
			int y = pos[1];
			entities.add(new Start(new Vector2(x, y), 0));
		}
	}

	private void createGoals(List<Entity> entities) {
		int[][] wallPos = { { 10, 7 }, { 10, 8 } };
		for (int[] pos : wallPos) {
			int x = pos[0];
			int y = pos[1];
			entities.add(new Goal(new Vector2(x, y), 0));
		}
	}

	private void createWalls(List<Entity> entities) {
		int[][] wallPos = { { 4, 0 }, { 7, 0 } };
		for (int[] pos : wallPos) {
			int x = pos[0];
			int y = pos[1];
			entities.add(new Wall(new Vector2(x, y), 0));
		}
	}

	private void createCars(List<Entity> entities) {
		entities.add(new Car(new Vector2(0, 0), 0, myName, new Vector2(0, 0),
				new Vector2(0, 0), CarColor.RED));

		entities.add(new Car(new Vector2(2, 2), 0, "Other Player", new Vector2(
				2, 2), new Vector2(3, 1), CarColor.YELLOW));
	}

	@Override
	public void render() {
		while (Network.hasWishes()) {
			// Network.getWish().applyTo(model);
		}
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}

package se.culvertsoft.vectorrally;

import java.util.ArrayList;
import java.util.List;

import se.culvertsoft.vectorrally.model.Game;
import se.culvertsoft.vectorrally.model.GameMap;
import se.culvertsoft.vectorrally.model.GameState;
import se.culvertsoft.vectorrally.model.Model;
import se.culvertsoft.vectorrally.model.ScreenState;
import se.culvertsoft.vectorrally.model.entity.CarColor;
import se.culvertsoft.vectorrally.model.entity.Entity;
import se.culvertsoft.vectorrally.model.entity.Goal;
import se.culvertsoft.vectorrally.model.entity.Start;
import se.culvertsoft.vectorrally.model.entity.Wall;
import se.culvertsoft.vectorrally.model.util.Vec2;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class VectorRally extends com.badlogic.gdx.Game {
	SpriteBatch batch;
	BitmapFont font;
	Game gameWorld;
	CarColor myColor = CarColor.RED;
	private Model model;

	@Override
	public void create() {
		// TODO: add some network stuff? Network.initialize("localhost", 1337);
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
			entities.add(new Start(new Vec2(x, y), 0));
		}
	}

	private void createGoals(List<Entity> entities) {
		int[][] wallPos = { { 10, 7 }, { 10, 8 } };
		for (int[] pos : wallPos) {
			int x = pos[0];
			int y = pos[1];
			entities.add(new Goal(new Vec2(x, y), 0));
		}
	}

	private void createWalls(List<Entity> entities) {
		int[][] wallPos = { { 4, 0 }, { 7, 0 } };
		for (int[] pos : wallPos) {
			int x = pos[0];
			int y = pos[1];
			entities.add(new Wall(new Vec2(x, y), 0));
		}
	}

	private void createCars(List<Entity> entities) {
		// entities.add(new Car(new Vec2(0, 0), 0, "IT'S ME.", new Vec2(0, 1),
		// new Vec2(0, 1), myColor));
		// entities.add(new Car(new Vec2(1, 0), 0, "Other Player", new Vec2(1,
		// 1),
		// new Vec2(1, 1), CarColor.PURPLE));
	}

	@Override
	public void render() {
		//while (Network.hasWishes()) {
			// Network.getWish().applyTo(model);
		//}
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}
}

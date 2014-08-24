package se.culvertsoft.vectorrally;

import se.culvertsoft.vectorrally.model.GameMap;
import se.culvertsoft.vectorrally.model.entity.Car;
import se.culvertsoft.vectorrally.model.entity.CarColor;
import se.culvertsoft.vectorrally.model.entity.Entity;
import se.culvertsoft.vectorrally.model.entity.Goal;
import se.culvertsoft.vectorrally.model.entity.Select;
import se.culvertsoft.vectorrally.model.entity.Start;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class MainGameScreen implements Screen {

	private final ShapeRenderer sr = new ShapeRenderer();

	final private VectorRally game;

	private Texture selectTexture;

	final OrthographicCamera camera;

	private Texture redCarTexture;

	private Texture blueCarTexture;

	private Texture purpleCarTexture;

	private Texture yellowCarTexture;

	private Texture wallTexture;

	private Texture goalTexture;

	private Texture startTexture;

	private static final int SPACING = 800 / 16;

	public MainGameScreen(VectorRally vr) {
		this.game = vr;

		redCarTexture = new Texture("red-car.png");
		blueCarTexture = new Texture("blue-car.png");
		purpleCarTexture = new Texture("purple-car.png");
		yellowCarTexture = new Texture("yellow-car.png");
		wallTexture = new Texture("wall.png");
		goalTexture = new Texture("goal.png");
		startTexture = new Texture("start.png");
		selectTexture = new Texture("select.png");
		selectTexture = new Texture("select.png");

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.update();
	}

	@Override
	public void render(float delta) {
		// clear the screen with a dark blue color. The
		// arguments to glClearColor are the red, green
		// blue and alpha component in the range [0,1]
		// of the color to be used to clear the screen.
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

		GameMap map = game.gameWorld.getMap();

		// TMP draw lines, change to texture later.

		sr.setColor(Color.WHITE);
		sr.setProjectionMatrix(camera.combined);

		for (int w = 1; w <= map.getWidth(); w++) {
			sr.begin(ShapeType.Line);

			sr.line(new Vector2(w * SPACING, 0),
					new Vector2(w * SPACING, map.getHeight() * SPACING));

			sr.end();
		}
		for (int h = 1; h <= map.getHeight(); h++) {
			sr.begin(ShapeType.Line);

			sr.line(new Vector2(0, h * SPACING), new Vector2(map.getWidth()
					* SPACING, h * SPACING));
			sr.end();
		}

		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();

		for (Entity ent : game.gameWorld.getMap().getObjects()) {
			drawEntity(ent);
		}
		game.batch.end();
		camera.update();
	}

	private void drawEntity(Entity ent) {
		Texture text = null;
		if (ent instanceof Car) {
			Car c = (Car) ent;
			if (CarColor.RED == c.getColor()) {
				text = redCarTexture;
			} else if (CarColor.BLUE == c.getColor()) {
				text = blueCarTexture;
			} else if (CarColor.PURPLE == c.getColor()) {
				text = purpleCarTexture;
			} else if (CarColor.YELLOW == c.getColor()) {
				text = yellowCarTexture;
			}
		} else if (ent instanceof Select) {
			text = selectTexture;
		} else if (ent instanceof Goal) {
			text = goalTexture;
		} else if (ent instanceof Start) {
			text = startTexture;
		} else {
			text = wallTexture;
		}
		game.batch.draw(text, ent.getPosition().getX() * SPACING, ent
				.getPosition().getY() * SPACING);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}

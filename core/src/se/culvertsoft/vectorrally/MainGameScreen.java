package se.culvertsoft.vectorrally;

import se.culvertsoft.vectorrally.model.entity.Car;
import se.culvertsoft.vectorrally.model.entity.Entity;
import se.culvertsoft.vectorrally.model.entity.Wall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MainGameScreen implements Screen {

	private final ShapeRenderer sr = new ShapeRenderer();
	final private VectorRally game;
	final Texture carTexture;
	final Texture wallTexture;
	final OrthographicCamera camera;

	public MainGameScreen(VectorRally vr) {
		this.game = vr;
		carTexture = new Texture("car.jpeg");
		wallTexture = new Texture("wall.jpeg");

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

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		game.font.draw(game.batch, "TXT", 0, 480);

		// TMP draw lines, change to texture later.

		sr.setColor(Color.BLACK);
		sr.setProjectionMatrix(camera.combined);

		sr.begin(ShapeType.Line);
		sr.end();

		for (Entity ent : game.gameWorld.getMap().getObjects()) {

			if (ent instanceof Car) {
				Car car = (Car) ent;
				game.batch.draw(carTexture, car.getPosition().getX(), car
						.getPosition().getY());
			}
			if (ent instanceof Wall) {
				Wall wall = (Wall) ent;
				game.batch.draw(wallTexture, wall.getPosition().getX(), wall
						.getPosition().getY());
			}

		}
		game.batch.end();
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

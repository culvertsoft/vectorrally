package se.culvertsoft.vectorrally;

import se.culvertsoft.vectorrally.model.MapObject;
import se.culvertsoft.vectorrally.model.entity.Car;
import se.culvertsoft.vectorrally.model.line.Wall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class MainGameScreen implements Screen {

	final private VectorRally game;
	final Texture carTexture;
	final Texture wallTexture;
	final OrthographicCamera camera;

	public MainGameScreen(VectorRally vr) {
		this.game = vr;
		carTexture = new Texture("badlogic.jpg");
		wallTexture = new Texture("badlogic.jpg");

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

		// tell the camera to update its matrices.
		camera.update();
		// tell the SpriteBatch to render in the
		// coordinate system specified by the camera.
		game.batch.setProjectionMatrix(camera.combined);

		// begin a new batch and draw the bucket and
		// all drops
		game.batch.begin();
		game.font.draw(game.batch, "TXT", 0, 480);
		for (MapObject o : game.gameWorld.getMap().getObjects()) {

			if (o instanceof Car) {
			 	Car car = (Car) o;
			 	game.batch.draw(carTexture, car.getPosition().getX(), car
			 			.getPosition().getY());
			 }
			 if (o instanceof Wall) {
			 	Wall wall = (Wall) o;
			 	game.batch.draw(wallTexture, wall.getStartPosition().getX(),
			 			wall.getStartPosition().getY());
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

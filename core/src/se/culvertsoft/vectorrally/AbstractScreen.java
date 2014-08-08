package se.culvertsoft.vectorrally;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * The base class for all game screens.
 */
public abstract class AbstractScreen implements Screen {

	protected final Stage stage;

	private BitmapFont font;
	private SpriteBatch batch;
	private Skin skin;
	private TextureAtlas atlas;
	private Table table;
	private int width;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private int height;

	VectorRally vr;

	public AbstractScreen() {

		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		this.stage = new Stage();
	}

	protected String getName() {
		return getClass().getSimpleName();
	}

	protected boolean isGameScreen() {
		return false;
	}

	public BitmapFont getFont() {
		if (font == null) {
			font = new BitmapFont();
		}
		return font;
	}

	public SpriteBatch getBatch() {
		if (batch == null) {
			batch = new SpriteBatch();
		}
		return batch;
	}

	public TextureAtlas getAtlas() {
		if (atlas == null) {
			FileHandle textureAtlas = Gdx.files.internal("uiskin.json");
			if(!textureAtlas.exists()) {
				throw new RuntimeException(textureAtlas.file().getAbsolutePath().toString());
			}
			atlas = new TextureAtlas(
					textureAtlas);
		}
		return atlas;
	}

	protected Skin getSkin() {
		if (skin == null) {
			FileHandle skinFile = Gdx.files.internal("uiskin.json");
			if(!skinFile.exists()) {
				throw new RuntimeException(skinFile.file().getAbsolutePath().toString());
			}
			skin = new Skin(skinFile);
		}
		return skin;
	}

	protected Table getTable() {
		if (table == null) {
			table = new Table(getSkin());
			table.setFillParent(true);
			stage.addActor(table);
		}
		return table;
	}

	// Screen implementation

	@Override
	public void show() {
		Gdx.app.log("AbstractScreen", "Showing screen: " + getName());
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("AbstractScreen", "Resizing screen: " + getName() + " to: "
				+ width + " x " + height);
	}

	@Override
	public void render(float delta) {

		stage.act(delta);

		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.draw();

		Table.drawDebug(stage);
	}

	@Override
	public void hide() {
		Gdx.app.log("AbstractScreen", "Hiding screen: " + getName());
		dispose();
	}

	@Override
	public void pause() {
		Gdx.app.log("AbstractScreen", "Pausing screen: " + getName());
	}

	@Override
	public void resume() {
		Gdx.app.log("AbstractScreen", "Resuming screen: " + getName());
	}

	@Override
	public void dispose() {
		Gdx.app.log("AbstractScreen", "Disposing screen: " + getName());
		stage.dispose();
		if (font != null)
			font.dispose();
		if (batch != null)
			batch.dispose();
		if (skin != null)
			skin.dispose();
		if (atlas != null)
			atlas.dispose();
	}

	public void setVr(VectorRally vr) {
		this.vr = vr;
	}
}
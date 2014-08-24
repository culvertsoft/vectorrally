package se.culvertsoft.vectorrally;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import se.culvertsoft.mgen.javapack.serialization.JsonReader;
import se.culvertsoft.vectorrally.model.ClassRegistry;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuScreen extends AbstractScreen {

	private static final float REFRESH_INTERVAL = 10;
	private float lastServerCallCounter = 0;
	private static ClassRegistry cr = new ClassRegistry();
	private static JsonReader jr = new JsonReader(cr);

	public MenuScreen(VectorRally vr) {
		super.setVr(vr);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

		Skin skin = super.getSkin();

		Table table = new Table(getSkin());
		table.setWidth(width);
		table.setHeight(height);

		List<String> list = new List<>(getSkin());

		stage.addActor(list);
		stage.addActor(table);

		TextButton startGameButton = new TextButton("Start game", skin);
		startGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				vr.setScreen(new MainGameScreen(vr));
			}
		});

		table.add(startGameButton);
		table.validate();
	}

	@Override
	public void render(float delta) {
		lastServerCallCounter += delta;
		if (lastServerCallCounter > REFRESH_INTERVAL) {
			lastServerCallCounter = 0;
			try {
				DefaultHttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(
						"https://xn--smst-loa.se/vectorrally.php");

				HttpResponse response = client.execute(request);
				HttpEntity entity = response.getEntity();
				String content = EntityUtils.toString(entity);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			} catch (HttpException e) {
				e.printStackTrace();
			}
		}

	}
}
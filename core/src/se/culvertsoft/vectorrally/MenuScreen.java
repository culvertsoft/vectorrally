package se.culvertsoft.vectorrally;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import se.culvertsoft.mgen.javapack.serialization.JsonReader;
import se.culvertsoft.vectorrally.model.ClassRegistry;
import se.culvertsoft.vectorrally.model.network.ServerIpList;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuScreen extends AbstractScreen {

	private static final float REFRESH_INTERVAL = 1;
	private float lastServerCallCounter = 10;
	private ServerIpList sil;
	private SelectBox<ServerIpList> serverList;
	private CompletableFuture<ServerIpList> future;
	private Table table;
	private static ClassRegistry cr = new ClassRegistry();
	private static JsonReader jr = new JsonReader(cr);

	public MenuScreen(VectorRally vr) {
		super.setVr(vr);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

		Skin skin = super.getSkin();

		table = new Table(getSkin());
		table.setWidth(width);
		table.setHeight(height);

		stage.addActor(table);

		TextButton startGameButton = new TextButton("Start game", skin);
		startGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				vr.setScreen(new MainGameScreen(vr));
			}
		});
		serverList = new SelectBox<ServerIpList>(getSkin());
		table.add(serverList);
		table.add(startGameButton);
		table.validate();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		lastServerCallCounter += delta;
		if (lastServerCallCounter > REFRESH_INTERVAL) {
			lastServerCallCounter = 0;

			future = CompletableFuture
					.supplyAsync(new Supplier<ServerIpList>() {
						@Override
						public ServerIpList get() {
							try {
								DefaultHttpClient client = new DefaultHttpClient();
								HttpGet request = new HttpGet(
										"http://xn--smst-loa.se/vectorrally.php");

								HttpResponse response = client.execute(request);
								HttpEntity entity = response.getEntity();
								String content = EntityUtils.toString(entity);

								System.out.println(content);

								return jr.readObject(content,
										ServerIpList.class);
							} catch (IOException | HttpException
									| URISyntaxException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return sil;
						}
					});

		}
		if (future.isDone()) {
			try {
				sil = future.get();
				serverList.validate();
				table.validate();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}
}
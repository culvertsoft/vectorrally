package se.culvertsoft.vectorrally;

import static se.culvertsoft.vectorrally.utils.Utils.map;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import se.culvertsoft.vectorrally.gui.ServerList;
import se.culvertsoft.vectorrally.model.network.ServerIpList;
import se.culvertsoft.vectorrally.utils.RepeatedTimer;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

public class MenuScreen extends AbstractScreen {

	private final RepeatedTimer serverListTimer = new RepeatedTimer(1);
	private List<String> serverList;
	private CompletableFuture<ServerIpList> getServerListAction;
	private Table table;

	public MenuScreen(VectorRally vr) {
		super.setVr(vr);

		Skin skin = super.getSkin();

		table = new Table(getSkin());
		serverList = new List<String>(getSkin());

		TextButton startGameButton = new TextButton("Start game", skin);
		startGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				vr.setScreen(new MainGameScreen(vr));
			}
		});
		table.add(startGameButton);
		table.add(serverList);

		stage.addActor(table);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		table.setWidth(width);
		table.setHeight(height);
		table.validate();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		if (serverListTimer.poll()) {
			if (getServerListAction == null) {
				getServerListAction = ServerList.getIpList();

			} else if (getServerListAction.isDone()) {
				try {
					ServerIpList ipList = getServerListAction.get();
					serverList.setItems(parseServers(ipList));
					getServerListAction = null;
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Array<String> parseServers(ServerIpList ipList) {
		java.util.List<String> a = map(ipList.getServers(), s -> s.getIp());
		return convertListToArray(a);
	}

	public <T> Array<T> convertListToArray(java.util.List<T> list) {
		Array<T> t = new Array<T>();
		for (T l : list) {
			t.add(l);
		}
		return t;
	}
}
package se.culvertsoft.vectorrally;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import se.culvertsoft.vectorrally.gui.ServerList;
import se.culvertsoft.vectorrally.model.network.ServerIpList;
import se.culvertsoft.vectorrally.model.network.ServerListItem;
import se.culvertsoft.vectorrally.utils.RepeatedTimer;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuScreen extends AbstractScreen {

	private final RepeatedTimer serverListTimer = new RepeatedTimer(1);
	private SelectBox<ServerListItem> serverList;
	private CompletableFuture<ServerIpList> getServerListAction;
	private Table table;

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
		serverList = new SelectBox<ServerListItem>(getSkin());
		table.add(serverList);
		table.add(startGameButton);
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
					serverList.validate();
					table.validate();
					getServerListAction = null;
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
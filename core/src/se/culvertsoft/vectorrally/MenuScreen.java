package se.culvertsoft.vectorrally;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuScreen extends AbstractScreen {
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

		// add the table to the stage and retrieve its layout
		stage.addActor(table);

		// register the button "start game"
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
}
package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainScreen extends ScreenAdapter {

	private Batch batch;
	private Background background;
	private SaturnFive saturnFive;
	private Hud hud;

	public MainScreen() {
		batch = new SpriteBatch();
		background = new Background();
		saturnFive = new SaturnFive();
		hud = new Hud();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		background.draw(batch, delta);
		saturnFive.draw(batch, delta);
		hud.draw(batch, delta);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		hud.dispose();
	}
}

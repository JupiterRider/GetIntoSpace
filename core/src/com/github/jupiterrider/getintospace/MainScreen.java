package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spacerocket.game.MainGame;

public class MainScreen extends ScreenAdapter {

	private MainGame game;
	private Batch batch;
	private Background background;
	private SaturnFive saturnFive;
	private Hud hud;
	private Asteroid asteroid;

	public MainScreen(MainGame g) {
		game = g;
		batch = new SpriteBatch();
		background = new Background(g);
		saturnFive = new SaturnFive(g);
		hud = new Hud();
		asteroid = new Asteroid(g);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		background.draw(batch, delta);
		saturnFive.draw(batch, delta);
		hud.draw(batch, delta);
		asteroid.draw(batch, delta);
		batch.end();

		if (saturnFive.getRectangle().overlaps(asteroid.getRectangle())) {
			saturnFive.reset();
			hud.reset();
			asteroid.reset(true);
		}
	}

	@Override
	public void dispose() {
		batch.dispose();
		hud.dispose();
	}
}

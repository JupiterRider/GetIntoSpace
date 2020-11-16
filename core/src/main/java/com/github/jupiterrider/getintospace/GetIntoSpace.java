package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class GetIntoSpace extends Game {

	@Override
	public void create() {
		setScreen(new MainScreen());
	}

	@Override
	public void render() {
		super.render();

		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}

	@Override
	public void dispose() {
		screen.dispose();
		AssetHandler.dispose();
	}
}
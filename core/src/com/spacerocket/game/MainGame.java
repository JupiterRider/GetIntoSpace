package com.spacerocket.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.github.jupiterrider.getintospace.AssetHandler;
import com.github.jupiterrider.getintospace.MainScreen;

public class MainGame extends Game {

	public static final int GAME_WIDTH = 480;
	public static final int GAME_HEIGHT = 800;
	public static final String GAME_TITLE = "Space Rocket";
	public AssetHandler assets;

	public MainGame(){ }

	@Override
	public void create () {
		assets = new AssetHandler(this);
		this.setScreen(new MainScreen(this));
	}

	@Override
	public void render() {
		super.render();
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}

	@Override
	public void dispose() {
		this.assets.getManager().dispose();
	}

}

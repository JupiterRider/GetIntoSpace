package com.spacerocket.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.spacerocket.game.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		MainGame mg = new MainGame();
		cfg.title = mg.GAME_TITLE;
		cfg.width = mg.GAME_WIDTH;
		cfg.height = mg.GAME_HEIGHT;
		new LwjglApplication(mg, cfg);
	}
}

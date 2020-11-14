package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GetIntoSpace extends Game {
	
	@Override
	public void create() {
		setScreen(new FirstScreen());
	}

	@Override
	public void dispose() {
		screen.dispose();
	}
}
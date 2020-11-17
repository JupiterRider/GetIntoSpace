package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Hud {

	private BitmapFont bitmapFont;
	private float time = 0f;

	public Hud() {
		bitmapFont = new BitmapFont();
	}

	public void draw(Batch batch, float delta) {
		time += delta;
		String strTime = "Survived: " + String.valueOf((long) time) + "sec";
		String strFps = "FPS: " + String.valueOf(Gdx.graphics.getFramesPerSecond());
		bitmapFont.draw(batch, strFps + System.lineSeparator() + strTime, 0f, Gdx.graphics.getHeight());
	}
	
	public void reset() {
		time = 0f;
	}
	
	public void dispose() {
		bitmapFont.dispose();
	}
}

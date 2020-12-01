package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Hud {

	private BitmapFont bitmapFont;
	private float currentScore = 0f;
	private float lastScore = 0f;
	private float bestScore = 0f;

	public Hud() {
		bitmapFont = new BitmapFont();
	}

	public void draw(Batch batch, float delta) {
		currentScore += delta;
		String strFps = "FPS: " + String.valueOf(Gdx.graphics.getFramesPerSecond());
		String strCurrentScore = "Current score: " + String.valueOf((long) currentScore) + "sec";
		String strLastScore = "Last score: " + String.valueOf((long) lastScore) + "sec";
		String strBestScore = "Best score: " + String.valueOf((long) bestScore) + "sec";

		String text = strFps + "\r\n" + strCurrentScore + "\r\n" + strLastScore + "\r\n" + strBestScore;
		bitmapFont.draw(batch, text, 0f, Gdx.graphics.getHeight());
	}

	public void reset() {
		lastScore = currentScore;

		if (lastScore > bestScore) {
			bestScore = lastScore;
		}

		currentScore = 0f;
	}

	public void dispose() {
		bitmapFont.dispose();
	}
}

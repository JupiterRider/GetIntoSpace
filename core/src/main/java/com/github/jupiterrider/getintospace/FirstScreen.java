package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen extends ScreenAdapter {

	private final Rocket rocket;
	private final Batch batch;
	private final BitmapFont bitmapFont;
	private final Texture texture;
	private final Sprite skySprite;
	private float skyOffset = 0f;

	public FirstScreen() {
		rocket = new Rocket();
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		texture = new Texture("sky.png");

		skySprite = new Sprite(texture);
		skySprite.flip(true, true);
	}

	@Override
	public void render(float delta) {
//		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1f);
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		renderBackground(delta);
		rocket.draw(batch, delta);
		String strFps = "FPS: " + String.valueOf(Gdx.graphics.getFramesPerSecond());
		bitmapFont.draw(batch, strFps, 0f, Gdx.graphics.getHeight());
		batch.end();
	}

	private void renderBackground(float delta) {
		skyOffset += 55f * delta;

		if ((int)skyOffset / Gdx.graphics.getHeight() == 1) {
			skyOffset = 0f;
		}

		batch.draw(skySprite, 0f, -skyOffset, texture.getWidth() * 5, texture.getHeight() * 5);
		batch.draw(skySprite, 0f, -skyOffset + Gdx.graphics.getHeight(), texture.getWidth() * 5,
				texture.getHeight() * 5);
	}

	@Override
	public void dispose() {
		Rocket.dispose();
		batch.dispose();
		bitmapFont.dispose();
		texture.dispose();
	}
}
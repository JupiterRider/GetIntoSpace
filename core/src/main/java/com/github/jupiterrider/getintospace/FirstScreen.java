package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class FirstScreen extends ScreenAdapter {

	private final Rocket rocket;
	private final Batch batch;
	private final BitmapFont bitmapFont;
	private final Texture texture;
	private final Sprite skySprite;
	private final Camera camera;
	
	private int skyOffset = 0;
	
	private final Rectangle cursorRectangle;

	public FirstScreen() {
		rocket = new Rocket();
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		texture = new Texture("sky.png");

		skySprite = new Sprite(texture);
		skySprite.flip(true, true);
		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		cursorRectangle = new Rectangle(0f, 0f, 1f, 1f);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		renderBackground(delta);
		rocket.draw(batch, delta, camera);
//		String strFps = "FPS: " + String.valueOf(Gdx.graphics.getFramesPerSecond());
//		bitmapFont.draw(batch, strFps, 0f, Gdx.graphics.getHeight());
		batch.end();
		
		cursorRectangle.setX(Gdx.input.getX());
		cursorRectangle.setY(Gdx.graphics.getHeight() - Gdx.input.getY());

		if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
			if (cursorRectangle.overlaps(rocket.getRectangle())) {
				System.out.println("Hit!");
			}

			System.out.println(rocket.getRectangle().getPosition(new Vector2()));
		}
	}

	private void renderBackground(float delta) {
		skyOffset = (int) (camera.position.y / Gdx.graphics.getHeight());

		batch.draw(skySprite, 0f, Gdx.graphics.getHeight() * (skyOffset + 1), texture.getWidth() * 5, texture.getHeight() * 5);
		batch.draw(skySprite, 0f, Gdx.graphics.getHeight() * skyOffset, texture.getWidth() * 5, texture.getHeight() * 5);
		batch.draw(skySprite, 0f, Gdx.graphics.getHeight() * (skyOffset - 1), texture.getWidth() * 5, texture.getHeight() * 5);
		batch.draw(skySprite, 0f, Gdx.graphics.getHeight() * (skyOffset - 2), texture.getWidth() * 5, texture.getHeight() * 5);
	}

	@Override
	public void dispose() {
		Rocket.dispose();
		batch.dispose();
		bitmapFont.dispose();
		texture.dispose();
	}
}
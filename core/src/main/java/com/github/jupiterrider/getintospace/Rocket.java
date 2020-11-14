package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Rocket {

	private final Texture rocketTexture;
	private final TextureRegion rocketOnTextureRegion;
	private final TextureRegion rocketOffTextureRegion;
	private Vector2 position;

	public Rocket() {
		rocketTexture = new Texture("saturn5.png");
		rocketOffTextureRegion = new TextureRegion(rocketTexture, 0, 0, rocketTexture.getWidth(),
				rocketTexture.getHeight() / 2);
		rocketOnTextureRegion = new TextureRegion(rocketTexture, 0, rocketTexture.getHeight() / 2,
				rocketTexture.getWidth(), rocketTexture.getHeight() / 2);
		
		position = Vector2.Zero;
	}

	public void draw(Batch batch, float delta) {
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			position.mulAdd(new Vector2(0f, 400f), delta);
			batch.draw(rocketOnTextureRegion, position.x, position.y, rocketOnTextureRegion.getRegionWidth() * 5,
					rocketOnTextureRegion.getRegionHeight() * 5);
		} else {
			batch.draw(rocketOffTextureRegion, position.x, position.y, rocketOnTextureRegion.getRegionWidth() * 5,
					rocketOnTextureRegion.getRegionHeight() * 5);
		}
	}

	public void dispose() {
		rocketTexture.dispose();
	}
}

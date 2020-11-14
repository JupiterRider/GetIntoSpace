package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Rocket {

	private final Texture rocketTexture;
	private final TextureRegion rocketOnTextureRegion;
	private final TextureRegion rocketOffTextureRegion;

	public Rocket() {
		rocketTexture = new Texture("saturn5.png");
		rocketOffTextureRegion = new TextureRegion(rocketTexture, 0, 0, rocketTexture.getWidth(),
				rocketTexture.getHeight() / 2);
		rocketOnTextureRegion = new TextureRegion(rocketTexture, 0, rocketTexture.getHeight() / 2,
				rocketTexture.getWidth(), rocketTexture.getHeight() / 2);
	}

	public void draw(Batch batch) {
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			batch.draw(rocketOnTextureRegion, 0f, 0f, rocketOnTextureRegion.getRegionWidth() * 5,
					rocketOnTextureRegion.getRegionHeight() * 5);
		} else {
			batch.draw(rocketOffTextureRegion, 0f, 0f, rocketOnTextureRegion.getRegionWidth() * 5,
					rocketOnTextureRegion.getRegionHeight() * 5);
		}
	}

	public void dispose() {
		rocketTexture.dispose();
	}
}

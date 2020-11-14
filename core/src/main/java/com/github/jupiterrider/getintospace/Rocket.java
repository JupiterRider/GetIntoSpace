package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Rocket {

	private final static Texture rocketTexture = new Texture("saturn5.png");

	private final static TextureRegion rocktOffTextureRegion = new TextureRegion(rocketTexture, 0, 0,
			rocketTexture.getWidth(), rocketTexture.getHeight() / 2);

	private final static TextureRegion rocktOnTextureRegion = new TextureRegion(rocketTexture, 0,
			rocketTexture.getHeight() / 2, rocketTexture.getWidth(), rocketTexture.getHeight() / 2);

	private final static Vector2 position = new Vector2(Gdx.graphics.getWidth() / 2f - rocketTexture.getWidth() * 2.5f, 0f);
	
	private final static float speedMax = 500f;
	private final static float speedMultiplier = 500f;
	
	private float velocity = 0f;
	
	public void draw(Batch batch, float delta) {
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			velocity += speedMultiplier * delta;
			velocity = MathUtils.clamp(velocity, -speedMax, speedMax);
			position.mulAdd(new Vector2(0f, velocity), delta);
			batch.draw(rocktOnTextureRegion, position.x, position.y, rocktOnTextureRegion.getRegionWidth() * 5,
					rocktOnTextureRegion.getRegionHeight() * 5);
		} else {
			velocity -= speedMultiplier * delta;
			velocity = MathUtils.clamp(velocity, -speedMax, speedMax);
			position.mulAdd(new Vector2(0f, velocity), delta);
			batch.draw(rocktOffTextureRegion, position.x, position.y, rocktOnTextureRegion.getRegionWidth() * 5,
					rocktOnTextureRegion.getRegionHeight() * 5);
		}
	}

	public void dispose() {
		rocketTexture.dispose();
	}
}

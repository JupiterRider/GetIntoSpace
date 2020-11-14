package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Rocket {

	private static final Texture TEXTURE = new Texture("saturn5.png");

	private static final TextureRegion OFF_TEXTURE_REGION = new TextureRegion(TEXTURE, 0, 0, TEXTURE.getWidth(),
			TEXTURE.getHeight() / 2);

	private static final TextureRegion ON_TEXTURE_REGION = new TextureRegion(TEXTURE, 0, TEXTURE.getHeight() / 2,
			TEXTURE.getWidth(), TEXTURE.getHeight() / 2);

	private static final Vector2 POSITION = new Vector2(Gdx.graphics.getWidth() / 2f - TEXTURE.getWidth() * 2.5f, 0f);

	private static final float SPEED_MAX = 500f;
	private static final float SPEED_MULTIPLIER = 500f;

	private float velocity = 0f;

	public void draw(Batch batch, float delta) {
		if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			velocity += SPEED_MULTIPLIER * delta;
			velocity = MathUtils.clamp(velocity, -SPEED_MAX, SPEED_MAX);
			POSITION.mulAdd(new Vector2(0f, velocity), delta);
			batch.draw(ON_TEXTURE_REGION, POSITION.x, POSITION.y, ON_TEXTURE_REGION.getRegionWidth() * 5,
					ON_TEXTURE_REGION.getRegionHeight() * 5);
		} else {
			velocity -= SPEED_MULTIPLIER * delta;
			velocity = MathUtils.clamp(velocity, -SPEED_MAX, SPEED_MAX);
			POSITION.mulAdd(new Vector2(0f, velocity), delta);
			batch.draw(OFF_TEXTURE_REGION, POSITION.x, POSITION.y, ON_TEXTURE_REGION.getRegionWidth() * 5,
					ON_TEXTURE_REGION.getRegionHeight() * 5);
		}
	}

	public static final void dispose() {
		TEXTURE.dispose();
	}
}

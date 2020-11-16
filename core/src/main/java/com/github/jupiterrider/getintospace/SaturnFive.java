package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class SaturnFive {

	private static final AtlasRegion ON_ATLAS_REGION = AssetHandler.TEXTURE_ATLAS.findRegion("saturn5on");
	private static final AtlasRegion OFF_ATLAS_REGION = AssetHandler.TEXTURE_ATLAS.findRegion("saturn5off");
	private static final Vector2 SIZE = new Vector2(ON_ATLAS_REGION.getRegionWidth() * 5,
			ON_ATLAS_REGION.getRegionHeight() * 5);
	private static final float SPEED = 150f;
	private static final Vector2 NORMAL = new Vector2(1f, 1f).nor();

	private Vector2 pos;
	private boolean up = false;
	private boolean left = false;
	private boolean right = false;

	public SaturnFive() {
		pos = new Vector2((Gdx.graphics.getWidth() - SIZE.x) / 2, (Gdx.graphics.getHeight() - SIZE.y) / 2);
	}

	public void draw(Batch batch, float delta) {
		checkInput();
		if (up) {
			if (left) {
				pos.mulAdd(new Vector2(-SPEED, SPEED).scl(NORMAL), delta);
			} else if (right) {
				pos.mulAdd(new Vector2(SPEED, SPEED).scl(NORMAL), delta);
			} else {
				pos.mulAdd(new Vector2(0f, SPEED), delta);
			}

			batch.draw(ON_ATLAS_REGION, pos.x, pos.y, SIZE.x, SIZE.y);

		} else {
			pos.mulAdd(new Vector2(0f, -100f), delta);
			batch.draw(OFF_ATLAS_REGION, pos.x, pos.y, SIZE.x, SIZE.y);
		}
	}

	private void checkInput() {
		if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) {
			up = true;
		} else {
			up = false;
		}

		if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)) {
			left = true;
		} else {
			left = false;
		}

		if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)) {
			right = true;
		} else {
			right = false;
		}
	}
}

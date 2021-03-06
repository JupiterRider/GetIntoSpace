package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SaturnFive {

	private static final AtlasRegion ON_ATLAS_REGION = AssetHandler.TEXTURE_ATLAS.findRegion("saturn5on");
	private static final AtlasRegion OFF_ATLAS_REGION = AssetHandler.TEXTURE_ATLAS.findRegion("saturn5off");
	private static final Vector2 SIZE = new Vector2(ON_ATLAS_REGION.getRegionWidth() * 5,
			ON_ATLAS_REGION.getRegionHeight() * 5);
	private static final float SPEED = 250f;
	private static final Vector2 NORMAL = new Vector2(1f, 1f).nor();

	private Vector2 pos;
//	private boolean up = false;
	private boolean left = false;
	private boolean right = false;
	private Rectangle rectangle;

	public SaturnFive() {
		reset();
		rectangle = new Rectangle(pos.x, pos.y, SIZE.x, SIZE.y);
	}

	public void draw(Batch batch, float delta) {
		checkInput();

		if (left) {
			pos.mulAdd(new Vector2(-SPEED, SPEED).scl(NORMAL), delta);
			pos = clampPos(pos);
			batch.draw(ON_ATLAS_REGION, pos.x, pos.y, SIZE.x, SIZE.y);
		} else if (right) {
			pos.mulAdd(new Vector2(SPEED, SPEED).scl(NORMAL), delta);
			pos = clampPos(pos);
			batch.draw(ON_ATLAS_REGION, pos.x, pos.y, SIZE.x, SIZE.y);
//		} else if (up) {
//			pos.mulAdd(new Vector2(0f, SPEED), delta);
//			pos = clampPos(pos);
//			batch.draw(ON_ATLAS_REGION, pos.x, pos.y, SIZE.x, SIZE.y);
		} else {
			pos.mulAdd(new Vector2(0f, -100f), delta);
			pos = clampPos(pos);
			batch.draw(OFF_ATLAS_REGION, pos.x, pos.y, SIZE.x, SIZE.y);
		}

		rectangle.setPosition(pos);
	}

	private void checkInput() {
//		if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) {
//			up = true;
//		} else {
//			up = false;
//		}

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

	private Vector2 clampPos(Vector2 pos) {
		float x = pos.x;
		float y = pos.y;

		x = MathUtils.clamp(x, -SIZE.x / 2, Gdx.graphics.getWidth() - SIZE.x / 2);
		y = MathUtils.clamp(y, -SIZE.y / 2, Gdx.graphics.getHeight() - SIZE.y / 2);
		pos.set(x, y);
		return pos;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void reset() {
		pos = new Vector2((Gdx.graphics.getWidth() - SIZE.x) / 2, (Gdx.graphics.getHeight() - SIZE.y) / 2);
	}
}

package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class Background {

	private static final AtlasRegion ATLAS_REGION = AssetHandler.TEXTURE_ATLAS.findRegion("sky");
	private static final Vector2 SIZE = new Vector2(ATLAS_REGION.getRegionWidth() * 5,
			ATLAS_REGION.getRegionHeight() * 5);

	private float offset = 0;

	public void draw(Batch batch, float delta) {
		offset -= 100f * delta;

		if (offset / Gdx.graphics.getHeight() <= -1) {
			offset = 0f;
		}

		batch.draw(ATLAS_REGION, 0f, Gdx.graphics.getHeight() + offset, SIZE.x, SIZE.y);
		batch.draw(ATLAS_REGION, 0f, offset, SIZE.x, SIZE.y);
	}
}
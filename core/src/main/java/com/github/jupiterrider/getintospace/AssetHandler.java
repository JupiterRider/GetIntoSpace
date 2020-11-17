package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetHandler {
	public static final TextureAtlas TEXTURE_ATLAS = new TextureAtlas("images.atlas");
	public static final Texture ASTEROID_TEXTURE = new Texture("asteroid.png");

	public static final void dispose() {
		TEXTURE_ATLAS.dispose();
		ASTEROID_TEXTURE.dispose();
	}
}
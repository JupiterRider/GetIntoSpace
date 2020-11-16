package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetHandler {
	public static final TextureAtlas TEXTURE_ATLAS = new TextureAtlas("images.atlas");

	public static final void dispose() {
		TEXTURE_ATLAS.dispose();
	}
}
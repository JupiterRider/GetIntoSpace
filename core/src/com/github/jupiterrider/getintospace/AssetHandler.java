package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.spacerocket.game.MainGame;

public class AssetHandler {
	private MainGame game;
	private AssetManager manager;
	public AssetHandler(MainGame g){
		game = g;
		manager = new AssetManager();
		manager.load("data/asteroids/asteroid.png", Texture.class);
		manager.load("getintospace/images.atlas", TextureAtlas.class);
		manager.finishLoading();
		if(manager.update()){ }
	}
	public AssetManager getManager(){
		return this.manager;
	}

}
package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.spacerocket.game.MainGame;

public class Background {

    private MainGame game;
    private AtlasRegion stars;
    private Vector2 size;

    private float offset = 0;

    Background(MainGame g) {
        game = g;
        stars = game.assets.getManager()
                .get("getintospace/images.atlas", TextureAtlas.class)
                .findRegion("sky");
        size = new Vector2(g.GAME_WIDTH, g.GAME_HEIGHT);
    }

    public void draw(Batch batch, float delta) {
        offset -= 100f * delta;
        if (offset / Gdx.graphics.getHeight() <= -1) {
            offset = 0f;
        }
        batch.draw(stars, 0f, Gdx.graphics.getHeight() + offset, size.x, size.y);
        batch.draw(stars, 0f, offset, size.x, size.y);
    }
}
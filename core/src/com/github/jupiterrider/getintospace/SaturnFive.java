package com.github.jupiterrider.getintospace;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.spacerocket.game.MainGame;

public class SaturnFive {

    private MainGame game;
    private AtlasRegion saturn5on;
    private AtlasRegion saturn5off;
    private Vector2 saturn5Box;
    private final float LR_SPEED = 2.0f;
    private final float U_SPEED = 3.0f;
    private final Vector2 NORMAL = new Vector2(1f, 1f).nor();

    private boolean keyLeft = false;
    private boolean keyRight = false;
    private boolean keyUp = false;
    private boolean keyUpLeft = false;
    private boolean keyUpRight = false;
    private boolean keyDown = false;

    private Vector2 pos;
    private Rectangle rectangle;

    public SaturnFive(MainGame g) {
        game = g;
        AssetManager manager = g.assets.getManager();
        saturn5on = manager.get("getintospace/images.atlas", TextureAtlas.class)
                .findRegion("saturn5on");
        saturn5off = manager.get("getintospace/images.atlas", TextureAtlas.class)
                .findRegion("saturn5off");
        saturn5Box = new Vector2(saturn5on.getRegionWidth() * 2, saturn5on.getRegionHeight() * 2);
        reset();
        rectangle = new Rectangle(pos.x, pos.y, saturn5Box.x, saturn5Box.y);
    }

    public void draw(Batch batch, float delta) {

        checkInput();

        if (keyDown) {
            batch.draw(saturn5off, pos.x, pos.y, saturn5Box.x, saturn5Box.y);
        }
        if (keyUp) {
            pos.y += U_SPEED;
            batch.draw(saturn5on, pos.x, pos.y, saturn5Box.x, saturn5Box.y);
        }
        if (keyUpLeft) {
            pos.y += U_SPEED;
            pos.x -= LR_SPEED;
            batch.draw(saturn5on, pos.x, pos.y, saturn5Box.x, saturn5Box.y);
        }
        if (keyLeft) {
            pos.x -= LR_SPEED;
        }
        if (keyRight) {
            pos.x += LR_SPEED;
        }
		if (keyUpRight) {
			pos.y += U_SPEED;
			pos.x += LR_SPEED;
			batch.draw(saturn5on, pos.x, pos.y, saturn5Box.x, saturn5Box.y);
		}

        pos.mulAdd(new Vector2(0f, -100f), delta);
        pos = clampPos(pos);
        batch.draw(saturn5off, pos.x, pos.y, saturn5Box.x, saturn5Box.y);

        rectangle.setPosition(pos);

    }

    private void checkInput() {
        if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)) {
            keyPress("L");
        }
        if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)) {
            keyPress("R");
        }
        if (Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) {
            keyPress("U");
        }
        if (Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)) {
            keyPress("D");
        }
        if ((Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) &&
                (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT))) {
            keyPress("UL");
        }
		if ((Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) &&
				(Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT))) {
			keyPress("UR");
		}
    }

    private void keyPress(String key) {
        keyUp = false;
        keyDown = false;
        keyRight = false;
        keyLeft = false;
        keyUpLeft = false;
        keyUpRight = false;
        switch (key) {
            case "L":
                keyLeft = true;
                break;
            case "R":
                keyRight = true;
                break;
            case "U":
                keyUp = true;
                break;
            case "D":
                keyDown = true;
                break;
            case "UL":
                keyUpLeft = true;
                break;
			case "UR":
				keyUpRight = true;
				break;
        }
    }

    private Vector2 clampPos(Vector2 pos) {
        float x = pos.x;
        float y = pos.y;
        x = MathUtils.clamp(x, -saturn5Box.x / 2, Gdx.graphics.getWidth() - saturn5Box.x / 2);
        y = MathUtils.clamp(y, -saturn5Box.y / 2, Gdx.graphics.getHeight() - saturn5Box.y / 2);
        pos.set(x, y);
        return pos;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void reset() {
        pos = new Vector2((Gdx.graphics.getWidth() - saturn5Box.x) / 2, (Gdx.graphics.getHeight() - saturn5Box.y) / 2);
    }
}

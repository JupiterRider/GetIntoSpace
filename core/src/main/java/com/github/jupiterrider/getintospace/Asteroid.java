package com.github.jupiterrider.getintospace;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
	private static final Vector2 SIZE = new Vector2(AssetHandler.ASTEROID_TEXTURE.getWidth() * 5,
			AssetHandler.ASTEROID_TEXTURE.getHeight() * 5);
	private static final float DEFAULT_SPEED = 200f;
	private static final float MULTIPLIER_SPEED = 5f;

	private float currentSpeed = DEFAULT_SPEED;
	private Random random;
	private Sprite sprite;
	private Vector2 pos;
	private Rectangle rectangle;

	public Asteroid() {
		random = new Random();
		random.nextInt(Gdx.graphics.getWidth() - (int) SIZE.x);

		sprite = new Sprite(AssetHandler.ASTEROID_TEXTURE);
		reset(false);
		rectangle = new Rectangle(pos.x, pos.y, SIZE.x, SIZE.y);
	}

	public void draw(Batch batch, float delta) {
		if (pos.y <= 0 - SIZE.y) {
			reset(false);
		} else {
			pos.mulAdd(new Vector2(0f, -currentSpeed), delta);
		}

		batch.draw(sprite, pos.x, pos.y, SIZE.x, SIZE.y);
		rectangle.setPosition(pos);

		currentSpeed += delta * MULTIPLIER_SPEED;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void reset(boolean hit) {
		if (hit) {
			currentSpeed = DEFAULT_SPEED;
		}
		sprite.flip(random.nextBoolean(), random.nextBoolean());
		pos = new Vector2(random.nextInt(Gdx.graphics.getWidth() - (int) SIZE.x + 1), Gdx.graphics.getHeight());
	}
}

package com.github.jupiterrider.getintospace;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.spacerocket.game.MainGame;

public class Asteroid {

	private MainGame game;
	private static Vector2 asteroidBox;
	private static final float DEFAULT_SPEED = 200f;
	private static final float MULTIPLIER_SPEED = 5f;

	private float currentSpeed = DEFAULT_SPEED;
	private Random random;
	private Sprite sprite;
	private Vector2 pos;
	private Rectangle rectangle;

	public Asteroid(MainGame g) {
		game = g;
		AssetManager manager = g.assets.getManager();
		int aw = manager.get("data/asteroids/asteroid.png", Texture.class).getWidth() * 2;
		int ah = manager.get("data/asteroids/asteroid.png", Texture.class).getHeight() * 2;
		asteroidBox = new Vector2(aw,ah);

		random = new Random();
		random.nextInt(Gdx.graphics.getWidth() - (int) asteroidBox.x);
		sprite = new Sprite(manager.get("data/asteroids/asteroid.png", Texture.class));
		reset(false);
		rectangle = new Rectangle(pos.x, pos.y, asteroidBox.x, asteroidBox.y);
	}

	public void draw(Batch batch, float delta) {
		if (pos.y <= 0 - asteroidBox.y) {
			reset(false);
		} else {
			pos.mulAdd(new Vector2(0f, -currentSpeed), delta);
		}

		batch.draw(sprite, pos.x, pos.y,asteroidBox.x, asteroidBox.y);
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
		pos = new Vector2(random.nextInt(Gdx.graphics.getWidth() - (int) asteroidBox.x + 1), Gdx.graphics.getHeight());
	}
}

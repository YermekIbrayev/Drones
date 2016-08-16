package com.iskhak.games.droneattack.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.iskhak.games.droneattack.helpers.AssetLoader;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class Bullet extends GameObject {
	
	private final static int WIDTH = 10;
	private final static int HEIGHT= 4;
	private final static float SPEED =5f;
	private final float LIFE_TIME = 1f;
	private boolean _remove;
	private float _lifeTimer;
	private static float MIN_TIME_BETWEEN_SHOOTS = 0.15f;

	public Bullet(float x, float y, Vector2 velocity, DrawFramework drawFramework) {
		super(x, y, WIDTH, HEIGHT, SPEED);
		super.setVelocity(velocity.x, velocity.y);
		_lifeTimer = 0;
		super.setDrawFramework(drawFramework);
		super.setSprite(AssetLoader.bullet);
	}
	
	public static float getMinimalTimeBetweenShoots(){
		return MIN_TIME_BETWEEN_SHOOTS;
	}

	@Override
	public void update(float delta){
		super.update(delta);
		_lifeTimer+=delta;
		if(_lifeTimer>LIFE_TIME){
			_remove = true;
		}
	}
	
	public boolean isRemoved(){
		return _remove;
	}

}

package com.iskhak.games.droneattack.gameobjects;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject extends PictureObject {
	private final float SPEED;
	private Vector2 _correction;
	private Vector2 _velocity;
	
	public GameObject(float x, float y, int width, int height, float speed){
		super(x, y, width, height);
		SPEED = speed;
		_velocity = new Vector2(MathUtils.random(-1,1), MathUtils.random(-1,1)).scl(SPEED);
		_correction = new Vector2(0,0);
	}
	
	public void update(float delta){
		setNextPosition(delta);
	}
	
	protected void setNextPosition(float delta){
		turnToNextPosition(delta);
		addToPosition(_velocity.cpy().scl(delta));
		setShapePosition(getX(), getY());
	}
	
	private Vector2 getNextPosition(float delta){
		Vector2 position = new Vector2(getX(), getY());
		return position.add(_correction).add(getVelocity().scl(delta));
	}
	
	private void turnToNextPosition(float delta){
		changeRotation(getNextPosition(delta));
	}
	
	public void setCorrection(float x, float y){
		_correction.set(x,y);
	}
	
	protected Vector2 getCorrection(){
		return new Vector2(_correction);
	}
	
	public Vector2 getVelocity(){
		return new Vector2(_velocity);
	}
	
	protected void setVelocity(float x, float y){
		_velocity.set(x, y).scl(SPEED);
	}
	
	protected void setVelocity(Vector2 newVelocity){
		_velocity.set(newVelocity);
	}
	
	protected void setCorrectedPosition(Vector2 newPosition){
		setPosition(newPosition.sub(_correction));
	}
	
	private void getNewRotation(Vector2 newPosition){
		setRotation((float)(Math.atan2(
			    newPosition.y-getY()-_correction.y,
			    newPosition.x-getX()-_correction.x
			)));
	}
		
	private void changeRotation(Vector2 newPosition){
		getNewRotation(newPosition);
		setShapeRotation(getRotation()*MathUtils.radiansToDegrees);
	}
	
	protected void directToPosition(Vector2 newPosition){
		changeRotation(newPosition);
		setVelocity((float) Math.cos(getRotation()), (float) Math.sin(getRotation()));
	}
}

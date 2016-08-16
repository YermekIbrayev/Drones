package com.iskhak.games.droneattack.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.iskhak.games.droneattack.helpers.Constants;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public abstract class DroneCore extends TouchingObject {
	private final static int WIDTH = 77;
	private final static int HEIGHT = 120;
	private final static float SPEED = 50.0f;
	
	private MovingWay _movingWay;
	private boolean _needToClean;
	private BulletsGroup _bullets;
	private boolean _isSelected;

	public DroneCore(int x, int y, DrawFramework drawFramework){
		super(x, y, WIDTH, HEIGHT, SPEED);
		super.setDrawFramework(drawFramework);
		_movingWay = new MovingWay(drawFramework);
		_bullets = new BulletsGroup(drawFramework);
		this.setCorrection(WIDTH/2-_movingWay.getWidth()/2,HEIGHT/2-_movingWay.getWidth()/2);
		super.setCanDie();
	}
	
	@Override
	protected void setNextPosition(float delta){
		if (_movingWay.getSize() > 0) {
			_movingWay.getPathDirection(this);
		}
		super.setNextPosition(delta);
	}
	
	@Override
	public void update(float delta){
		super.update(delta);
		Vector2 _velocity = getVelocity();
		_velocity.y=testScreenBorders(getY(), _velocity.y, Constants.SCREEN_HEIGHT-getHeight());
		_velocity.x=testScreenBorders(getX(), _velocity.x, Constants.SCREEN_WIDTH-getWidth());		
		setVelocity(_velocity);
		_bullets.update(delta);
	}
	
	private float testScreenBorders(float position, float velocity, int maxValue){
		float reusult = velocity;
		if(position>maxValue){
			reusult = -Math.abs(velocity);
		}
		if(position<0){
			reusult= Math.abs(velocity);
		}
		return reusult;
	}
	
	public BulletsGroup getBullets(){
		return _bullets;
	}
	
	public void checkIfCrashed(DroneCore object){
		if((!this.isCrashed()&&!object.isCrashed())&&isCollides(object)){
			crash();
			object.crash();
		}
	}
	
	@Override
	protected void crash(){
		super.crash();
		_movingWay.clear();

	}
	
	@Override
	public boolean onTouchDown(int x, int y){
		_isSelected = super.onTouchDown(x, y);
		return _isSelected;
	}
	
	@Override
	public boolean onTouchDragged(int x, int y){
		if (isMousePressed()) {
			if(_needToClean){
				_movingWay.clear();
				_needToClean=false;
			}
			if(!isCrashed())_movingWay.addPoint(new Vector2(x, y));
			return true;
		}
		return false;
	}
	
	protected boolean isPositionReached(Vector2 targetPosition){
		float _delta = Gdx.graphics.getDeltaTime();
		return Math.abs(targetPosition.x-getX()-getCorrection().x)<=SPEED*_delta&&Math.abs(targetPosition.y-getY()-getCorrection().y)<=SPEED*_delta;
	}

	@Override
	public boolean onTouchUp(int x, int y) {
		if(isMousePressed()) _movingWay.finishAdd();
		_needToClean = true;
		return super.onTouchUp(x, y);
	}
	
	public void drawMovingWay(){
		_movingWay.draw();
	}
	
	public void shoot(){
		if(!this.isCrashed()&&_isSelected)
			_bullets.addBullet(getX()+getWidth()/2, getY()+getHeight()/2, getVelocity());
	}
	
	public void drawBullets(){
		if(!this.isCrashed())
			_bullets.draw();
	}
	
	public void drawRender(){
		if(!this.isCrashed()&&_isSelected)
			getDrawFramework().drawRender(this);
	}
	
}

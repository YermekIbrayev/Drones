package com.iskhak.games.droneattack.gameobjects;

import com.badlogic.gdx.math.Rectangle;

public abstract class TouchingObject extends GameObject implements IClickable {
	
	private boolean _isMousePressed;

	public TouchingObject(int x, int y, int width, int height, float speed) {
		super(x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}

	public boolean isTouched(int x, int y){
		return new Rectangle(getX(), getY(), getWidth(), getHeight()).contains(x, y);
	}
	
	public boolean onTouchDown(int x, int y){
		if(isTouched(x, y)){
			_isMousePressed=true;
			return true;
		}
		return false;
	}
	
	abstract public boolean onTouchDragged(int x, int y);
	
	public boolean onTouchUp(int x, int y){
		_isMousePressed =false;
		return true;
	}
	
	protected boolean isMousePressed(){
		return _isMousePressed;
	}	
}

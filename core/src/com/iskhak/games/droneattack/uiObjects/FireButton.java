package com.iskhak.games.droneattack.uiObjects;

import com.badlogic.gdx.math.Rectangle;
import com.iskhak.games.droneattack.gameobjects.IClickable;
import com.iskhak.games.droneattack.gameobjects.PictureObject;
import com.iskhak.games.droneattack.helpers.Constants;

public class FireButton extends PictureObject implements IClickable {
	private final static int WIDTH = 50;
	private final static int HEIGHT = 50;
	private final static int POS_X = 40;
	private final static int POS_Y = Constants.SCREEN_HEIGHT - HEIGHT - 40;
	private boolean _isTouched;
	
	public FireButton(){
		super(POS_X, POS_Y, WIDTH, HEIGHT);
	}

	@Override
	public boolean onTouchDown(int x, int y) {
		if(new Rectangle(0, Constants.SCREEN_HEIGHT - HEIGHT-100, getWidth()+100, getHeight()+100).contains(x, y)){
			_isTouched = true;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean onTouchDragged(int x, int y) {
		if(new Rectangle(0, Constants.SCREEN_HEIGHT - HEIGHT-100, getWidth()+100, getHeight()+100).contains(x, y)){
			return true;
		}
		return false;
	}

	@Override
	public boolean onTouchUp(int x, int y) {
		if(new Rectangle(0, Constants.SCREEN_HEIGHT - HEIGHT-100, getWidth()+100, getHeight()+100).contains(x, y)){
			_isTouched = false;
			return true;
		}
		
		return false;
	}
	
	public boolean isTouched(){
		return _isTouched;
	}

}

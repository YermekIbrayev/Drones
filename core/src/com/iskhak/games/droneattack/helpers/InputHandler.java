package com.iskhak.games.droneattack.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.iskhak.games.droneattack.gameobjects.IClickable;

public class InputHandler implements InputProcessor{

	IClickable _world;
	private double _scaleFactorX;
	private double _scaleFactorY;
	
	public InputHandler(IClickable world) {
		_world = world;
		_scaleFactorX = Gdx.graphics.getWidth()/(float)Constants.SCREEN_WIDTH;
		_scaleFactorY = Gdx.graphics.getHeight()/(float)Constants.SCREEN_HEIGHT;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return _world.onTouchDown(scaleX(screenX), scaleY(screenY));
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return _world.onTouchUp(scaleX(screenX), scaleY(screenY));
		
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return _world.onTouchDragged(scaleX(screenX), scaleY(screenY));
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
    int scaleX(int screenX) {
        return (int) (screenX / _scaleFactorX);
    }

    int scaleY(int screenY) {
        return (int) (screenY / _scaleFactorY);
    }

}
package com.iskhak.games.droneattack.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.iskhak.games.droneattack.gameobjects.IClickable;
import com.iskhak.games.droneattack.helpers.AssetLoader;
import com.iskhak.games.droneattack.helpers.DrawFramework;
import com.iskhak.games.droneattack.uiObjects.FireButton;

public class GameUI implements IGameWorld, IClickable {
	
	private FireButton _fireButton;
	private GameWorld _world;
	private DrawFramework _drawFramework;
	private int _currentStageNumber;
	private boolean _isPressed;
	
	public GameUI(GameWorld world, SpriteBatch batcher, ShapeRenderer render){
		_fireButton = new FireButton();
		_world = world;
		_drawFramework = new DrawFramework(batcher, render);
	}

	@Override
	public void draw() {
		if(_currentStageNumber>0)
			_drawFramework.draw(_fireButton, AssetLoader.point);
	}
	
	public void setCurrentStageNumber(int currentStageNumber){
		_currentStageNumber=currentStageNumber;
	}

	@Override
	public void drawRender() {
	}

	@Override
	public void update(float delta) {
		if(_isPressed)
			_world.shootPressed();
	}


	@Override
	public boolean onTouchDragged(int x, int y) {
		if(_currentStageNumber>0)
			return _fireButton.onTouchDragged(x, y);
		return false;
	}


	@Override
	public boolean onTouchDown(int x, int y) {
		if(_currentStageNumber>0&&_fireButton.onTouchDown(x, y)){
			_isPressed = true;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean onTouchUp(int x, int y) {
		if (_currentStageNumber > 0) {
			_isPressed = false;
			return _fireButton.onTouchUp(x, y);
		}
		return false;
	}

}

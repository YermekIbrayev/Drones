package com.iskhak.games.droneattack.gameworld.stages;

import com.iskhak.games.droneattack.gameobjects.IClickable;
import com.iskhak.games.droneattack.gameworld.IGameWorld;
import com.iskhak.games.droneattack.gameworld.IStages;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public abstract class Stage implements IGameWorld, IClickable, IStages{
	
	protected DrawFramework _drawFramework;
	private boolean _isFinished=false;
	private int _currentStageNumber;
	
	public Stage(DrawFramework drawFramework, int currentStageNumber){
		_drawFramework = drawFramework;
		_currentStageNumber = currentStageNumber;
	}
	
	public int getStageNumber(){
		return _currentStageNumber;
	}
	
	public boolean isFinished(){
		return _isFinished;
	}
	
	protected void finish(){
		_isFinished = true;
	}

	@Override
	public abstract void shootPressed();

	@Override
	public abstract boolean onTouchDown(int x, int y);

	@Override
	public abstract boolean onTouchDragged(int x, int y);

	@Override
	public abstract boolean onTouchUp(int x, int y);

	@Override
	public abstract void draw();

	@Override
	public abstract void drawRender();

	@Override
	public abstract void update(float delta);

}

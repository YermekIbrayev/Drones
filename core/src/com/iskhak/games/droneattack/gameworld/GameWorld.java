package com.iskhak.games.droneattack.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.iskhak.games.droneattack.gameobjects.IClickable;
import com.iskhak.games.droneattack.gameworld.stages.Intro;
import com.iskhak.games.droneattack.gameworld.stages.Stage;
import com.iskhak.games.droneattack.gameworld.stages.Stage1;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class GameWorld implements IGameWorld, IClickable, IStages {
	
	private Stage _currentStage;
	private DrawFramework _drawFramework;
	
	public GameWorld(SpriteBatch batcher, ShapeRenderer render){
		_drawFramework = new DrawFramework(batcher, render);
		_currentStage = new Intro(_drawFramework);
	}
	
	@Override
	public void draw(){
		_currentStage.draw();
	}

	@Override
	public void update(float delta){
		_currentStage.update(delta);
		if(_currentStage.isFinished())
			getNextStage();
	}
	
	private void getNextStage(){
		switch(_currentStage.getStageNumber()){
			case 0:_currentStage = new Stage1(_drawFramework);
				break;
			case 1:_currentStage = new Intro(_drawFramework);
				break;
		}
	}
	
	public int getStageNumber(){
		return _currentStage.getStageNumber();
	}
	
	@Override
	public boolean onTouchDragged(int x, int y){
		return _currentStage.onTouchDragged(x, y);
	}

	@Override
	public void shootPressed(){
		_currentStage.shootPressed();
	}

	@Override
	public void drawRender() {
		_currentStage.drawRender();
	}

	@Override
	public boolean onTouchDown(int x, int y) {
		return _currentStage.onTouchDown(x, y);
	}

	@Override
	public boolean onTouchUp(int x, int y) {
		return _currentStage.onTouchUp(x, y);
	}
}

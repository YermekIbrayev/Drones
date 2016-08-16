package com.iskhak.games.droneattack.gameworld.stages;

import com.iskhak.games.droneattack.gameobjects.Background;
import com.iskhak.games.droneattack.helpers.AssetLoader;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class Intro extends Stage {
	private Background _background;
	private float _time;

	public Intro(DrawFramework drawFramework) {
		super(drawFramework, 0);
		_background = new Background(_drawFramework);
		_background.setPicture(AssetLoader.intro);
		_time = 0;
	}

	@Override
	public void shootPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onTouchDown(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchDragged(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouchUp(int x, int y) {
		return false;
	}

	@Override
	public void draw() {
		_background.draw();
	}

	@Override
	public void drawRender() {
		_background.drawFadeInFadeOut();
		
	}

	@Override
	public void update(float delta) {
		_time+=delta;
		if(_time>3.0f)
			this.finish();
	}

}

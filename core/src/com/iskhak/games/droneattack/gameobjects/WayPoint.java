package com.iskhak.games.droneattack.gameobjects;

import com.iskhak.games.droneattack.helpers.AssetLoader;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class WayPoint extends PictureObject {

	private DrawFramework _drawFramework;
	
	public WayPoint(float x, float y, int width, int height, DrawFramework drawFramework) {
		super(x, y, width, height);
		_drawFramework = drawFramework;
	}
	
	public void draw(boolean isNew){
		if(isNew)
			_drawFramework.draw(this, AssetLoader.point);
		else
			_drawFramework.draw(this, AssetLoader.point1);
	}
	

}

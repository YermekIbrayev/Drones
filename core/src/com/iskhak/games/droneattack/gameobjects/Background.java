package com.iskhak.games.droneattack.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.iskhak.games.droneattack.helpers.Constants;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class Background extends PictureObject{
	
	public Background(DrawFramework drawFramework){
		super(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		super.setDrawFramework(drawFramework);
		
	}
	
	public void setPicture(TextureRegion picture){
		super.setSprite(picture);
	}
}

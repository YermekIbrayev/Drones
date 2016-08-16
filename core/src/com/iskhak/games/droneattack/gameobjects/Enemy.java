package com.iskhak.games.droneattack.gameobjects;

import com.iskhak.games.droneattack.helpers.AssetLoader;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class Enemy extends PictureObject {
	
	private static int WIDTH = 40;
	private static int HEIGHT= 40;

	public Enemy(float x, float y, DrawFramework drawFramework) {
		super(x, y, WIDTH, HEIGHT);
		super.setDrawFramework(drawFramework);
		super.setSprite(AssetLoader.target);
	}
	
	public void update(BulletsGroup bulletsGroup){
		checkIfCrashed(bulletsGroup);
	}
	
	private void checkIfCrashed(BulletsGroup bulletsGroup){
		if(bulletsGroup.isReached(this)){
			crash();
		}
	}
}

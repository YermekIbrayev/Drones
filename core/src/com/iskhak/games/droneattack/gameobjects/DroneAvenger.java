package com.iskhak.games.droneattack.gameobjects;

import com.iskhak.games.droneattack.helpers.AssetLoader;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class DroneAvenger extends DroneCore {

	public DroneAvenger(int x, int y, DrawFramework drawFramework) {
		super(x, y, drawFramework);
		float[] _points = new float[] {0,36, 6,36, 17,53, 34,53, 39,33, 32,3, 32,0, 39,0, 47,33, 52,53, 68,53, 75,58, 77,58, 77,61, 75,61, 69,66, 52,66, 47,86, 39,120, 33,120, 32,117, 39,86, 34,66, 17,66, 6,83, 0,83, 10,66, 7,63, 7,56, 10,53};
		super.setShape(_points);
		super.setSprite(AssetLoader.drone);
		super.setDieAnimation(AssetLoader.droneExplosion);
	}
}

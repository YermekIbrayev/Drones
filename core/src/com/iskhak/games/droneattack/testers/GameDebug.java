package com.iskhak.games.droneattack.testers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.iskhak.games.droneattack.gameobjects.DroneCore;
import com.iskhak.games.droneattack.gameworld.GameWorld;

public class GameDebug {
	
	private GameWorld _world;
	private ShapeRenderer _render;
	
	public GameDebug(GameWorld world, ShapeRenderer render){
		_world = world;
		_render = render;
	}
	
	public void render(){
        //for(DroneCore drone:_world.getObjects())
        	//_render.polygon(drone.getShapePoints());	
	}
}

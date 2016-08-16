package com.iskhak.games.droneattack.gameworld.stages;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.iskhak.games.droneattack.gameobjects.Background;
import com.iskhak.games.droneattack.gameobjects.DroneAvenger;
import com.iskhak.games.droneattack.gameobjects.Enemy;
import com.iskhak.games.droneattack.helpers.AssetLoader;
import com.iskhak.games.droneattack.helpers.Constants;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class Stage1 extends Stage{ 
	private Background _background;
	private Array<DroneAvenger> _drones;
	private Enemy[] _enemies;
	
	public Stage1(DrawFramework drawFramework){
		super(drawFramework,1);
		_background = new Background(_drawFramework);
		_background.setPicture(AssetLoader.background);
		_drones = new Array<DroneAvenger>();
		_enemies = new Enemy[4];
		for(int i=0;i<MathUtils.random(3,5);i++){
			DroneAvenger _drone = new DroneAvenger(MathUtils.random(0,Constants.SCREEN_WIDTH-120),MathUtils.random(0,Constants.SCREEN_HEIGHT-120), _drawFramework);
			_drones.add(_drone);
		}
		for(int i=0; i<4; i++)
			_enemies[i]= new Enemy(MathUtils.random(0,Constants.SCREEN_WIDTH-40),MathUtils.random(0,Constants.SCREEN_HEIGHT-40), _drawFramework);
	}

	@Override
	public boolean onTouchDown(int x, int y) {
		boolean result = false;
		for(DroneAvenger _drone:_drones){
			boolean isTouched = _drone.onTouchDown(x, y);
			result = result || isTouched;
			}
		return result;
	}

	@Override
	public boolean onTouchDragged(int x, int y) {
		boolean result = false;
		for(DroneAvenger _drone:_drones){
			boolean isDragged = _drone.onTouchDragged(x, y);
			result = result || isDragged;
		}
		return result;
	}

	@Override
	public boolean onTouchUp(int x, int y) {
		boolean result = false;
		for(DroneAvenger _drone:_drones){
			boolean isTouchedUp = _drone.onTouchUp(x, y);
			result = result || isTouchedUp;
		}
		return result;
	}

	@Override
	public void draw() {	
		_background.draw();
		for (DroneAvenger _drone:_drones) {
			 _drone.drawMovingWay();
		};
		
		for (DroneAvenger _drone:_drones) {
			_drone.drawBullets();
		};
		
		for(int i=0;i<4;i++)
			_enemies[i].draw();
		
		for(DroneAvenger _drone:_drones)
			_drone.draw();
	}

	@Override
	public void drawRender() {
		for(DroneAvenger _drone:_drones)
			_drone.drawRender();	
	}

	@Override
	public void update(float delta) {
		for (int i = 0; i < _drones.size - 1; i++)
			for (int j = i + 1; j < _drones.size; j++) {
				_drones.get(i).checkIfCrashed(_drones.get(j));
			}

		for (DroneAvenger _drone : _drones) {
			if (!_drone.isCrashed()) {
				_drone.update(delta);
				int enemyNotCrashed = 0;
				for (int i = 0; i < 4; i++) {
					if (!_enemies[i].isCrashed()) {
						_enemies[i].update(_drone.getBullets());
						enemyNotCrashed++;
					}
					if (enemyNotCrashed == 0) {
						this.finish();
					}
				}
			}
		}	
	}
	

	@Override
	public void shootPressed() {
		for(DroneAvenger _drone:_drones)
			_drone.shoot();
	}
	
}

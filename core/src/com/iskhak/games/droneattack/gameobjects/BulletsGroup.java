package com.iskhak.games.droneattack.gameobjects;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class BulletsGroup {
	private LinkedList<Bullet> _bullets;
	private DrawFramework _drawFramework;
	private float _timeBetweenShoots;
	
	public BulletsGroup(DrawFramework drawFramework){
		_bullets = new LinkedList<Bullet>();
		_drawFramework = drawFramework;
		_timeBetweenShoots = 0;
	}
	
	public void addBullet(float x, float y, Vector2 velocity){
		if(_timeBetweenShoots>Bullet.getMinimalTimeBetweenShoots()){
			_bullets.add(new Bullet(x, y, velocity, _drawFramework));
			_timeBetweenShoots = 0;
		}
	}
	
	public void update(float delta){
		_timeBetweenShoots+=delta;
		for(Bullet _bullet:_bullets){
			_bullet.update(delta);
		}
		
		for(int i=0;i<_bullets.size(); i++){
			if(_bullets.get(i).isRemoved()) _bullets.remove(i);
		}
		
	}
	
	public void draw(){
		for(Bullet _bullet:_bullets){
			_bullet.draw();
		}
	}
	
	public boolean isReached(PictureObject object){
		boolean result = false;
		for(Bullet _bullet: _bullets){
			boolean testCollides = _bullet.isCollides(object);
			if(testCollides) _bullet.crash();
			result = result || testCollides;
		}
		
		return result;
	}

}

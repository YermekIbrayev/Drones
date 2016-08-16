package com.iskhak.games.droneattack.gameobjects;

import java.util.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public class MovingWay extends PictureObject {
	private LinkedList<WayPoint> _path;
	private static final int WIDTH=10;
	private static final int HEIGHT = 10;
	private final int MAX_POINTS_COUNT = 50;
	private final int DIST_BETWEEN_POINTS = 30;
	private boolean _isNew = true;
	
	public MovingWay(DrawFramework drawFramework){
		super(0,0, WIDTH, HEIGHT);
		_path = new LinkedList<WayPoint>();
		super.setDrawFramework(drawFramework);
	}
	
	protected void getPathDirection(DroneCore _drone){
		Vector2 newPosition = _path.getFirst().getPosition();
		if (!_drone.isPositionReached(newPosition)){
			_drone.directToPosition(newPosition);
		} else {
			_drone.setCorrectedPosition(newPosition);
			_path.remove();
		}
	}
	
	public void addPoint(Vector2 newPosition){
		if (_path.size() < MAX_POINTS_COUNT
				&& ((_path.size() == 0 || (_path.getLast().getPosition().dst(newPosition) >= DIST_BETWEEN_POINTS)))) {
			_path.add(new WayPoint(newPosition.x, newPosition.y, WIDTH, HEIGHT, getDrawFramework()));
		}
	}
	
	@Override
	public void draw(){
		for(WayPoint _point: _path)
			_point.draw(_isNew);
	}
	
	protected void clear(){
		_path.clear();
		_isNew = true;
	}
	
	public int getSize(){
		return _path.size();
	}
	
	public WayPoint getByIndex(int index){
		return _path.get(index);
	}

	public void finishAdd(){
		_isNew = false;
	}
}

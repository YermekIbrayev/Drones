package com.iskhak.games.droneattack.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.iskhak.games.droneattack.helpers.DrawFramework;

public abstract class PictureObject {
	private final int WIDTH;
	private final int HEIGHT;
	private Vector2 _position;
	private float _rotation, _delta;
	private Polygon _shape;
	private DrawFramework _drawFramework;
	private TextureRegion _sprite;
	private boolean _isCrashed, _isDied, _canDie;
	private Animation _dieAnimation;
	
	public PictureObject(float x, float y, int width, int height){
		_position = new Vector2(x, y);
		WIDTH = width;
		HEIGHT = height;
		float[] _points = {0, 0, 0, WIDTH, HEIGHT, WIDTH,  HEIGHT, 0};
		setShape(_points);
		_canDie=false;
	}
	
	public void setCanDie(){
		_canDie=true;
	}
	
	protected void setSprite(TextureRegion sprite){
		_sprite = sprite;
	}
	
	protected void setDieAnimation(Animation dieAnimation){
		_dieAnimation = dieAnimation;
	}
	
	protected void setDrawFramework(DrawFramework drawFramework){
		_drawFramework = drawFramework;
	}
	
	protected DrawFramework getDrawFramework(){
		return _drawFramework;
	}
	
	public void draw(){
		if(!_isCrashed)
			_drawFramework.draw(this, _sprite);
		else if(!_isDied&&_canDie){
			_isDied = drawDie();
		}
	}
	
	public void drawFadeInFadeOut(){
		_drawFramework.drawFadeInOut();
	}
	
	public boolean drawDie(){
		_delta+=Gdx.graphics.getDeltaTime();
		return _drawFramework.drawAnimation(this, _dieAnimation, _delta);
	}
	
	public float getX(){
		return _position.x;
	}
	
	

	public float getY(){
		return _position.y;
	}
	
	public int getWidth(){
		return WIDTH;
	}
	
	public int getHeight(){
		return HEIGHT;
	}
	
	protected void addToPosition(Vector2 newVector){
		_position.add(newVector);
	}
	
	protected void setPosition(Vector2 newPosition){
		_position.set(newPosition);
	}
	
	public Vector2 getPosition(){
		return new Vector2(_position);
	}
	
	public void setRotation(float rotation){
		_rotation = rotation;
	}
	
	public float getRotation(){
		return _rotation;
	}
	
	public Polygon getShape(){
		return _shape;
	}
	
	public float[] getShapePoints(){
		return _shape.getTransformedVertices();
	}
	
	protected void setShape(float[] points){
		_shape = new Polygon(points);
		_shape.setOrigin(getWidth()/2, getHeight()/2);
		_shape.translate(getX(), getY());
	}
	
	protected void setShapePosition(float x, float y){
		if(_shape!=null)
			_shape.setPosition(x, y);
	}
	
	protected void setShapeRotation(float rotation){
		if(_shape!=null)
			_shape.setRotation(rotation);
	}
	
	private boolean isObjectNear(PictureObject object){
		return (getX()+getWidth()>object.getX()&&getY()+getWidth()>object.getY())&&(object.getX()+object.getWidth()>getX()&&object.getY()+object.getHeight()>getY());
	}
	
	public boolean isCollides(PictureObject object){
		if(isObjectNear(object)){
			return Intersector.overlapConvexPolygons(object.getShape(),getShape());
		}
		return false;
	}
	
	protected void crash(){
		_isCrashed=true;
	}
	
	public boolean isCrashed(){
		return _isCrashed;
	}
}

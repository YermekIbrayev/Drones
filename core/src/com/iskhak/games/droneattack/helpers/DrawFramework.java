package com.iskhak.games.droneattack.helpers;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.iskhak.games.droneattack.gameobjects.DroneCore;
import com.iskhak.games.droneattack.gameobjects.PictureObject;

public class DrawFramework {
	
	private SpriteBatch _batcher;
	private ShapeRenderer _render;
	
	public DrawFramework(SpriteBatch batch, ShapeRenderer render){
		_batcher=batch;
		_render = render;
	}
	
	public boolean drawAnimation(PictureObject pictureObject, Animation animation, float delta){
		TextureRegion currentFrame = animation.getKeyFrame(delta);
		this.draw(pictureObject, currentFrame);
		return animation.isAnimationFinished(delta);
	}
	
	public void draw(PictureObject pictureObject, TextureRegion sprite){
		if(pictureObject!=null)
			_batcher.draw(sprite, pictureObject.getX(),pictureObject.getY(), pictureObject.getWidth()/2.0f, pictureObject.getHeight()/2.0f , pictureObject.getWidth(), pictureObject.getHeight(),1,1, pictureObject.getRotation() *MathUtils.radiansToDegrees);
	}
	
	public void drawRender(DroneCore drone){
		float radius = drone.getHeight()/2.0f+3;
		if(drone.getHeight()<drone.getWidth()) radius = drone.getWidth()/2.0f+3;
		_render.circle(drone.getX()+drone.getWidth()/2, drone.getY()+drone.getHeight()/2, radius);
	}
	
	public void drawFadeInOut(){
/*		f
		Color fadeColor = new Color(0,0,0,1);
		_render.end();
		_render.setColor(fadeColor);
		_render.begin(ShapeType.Filled);
		_render.rect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);*/
	}
}

package com.iskhak.games.droneattack.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.iskhak.games.droneattack.helpers.Constants;
import com.iskhak.games.droneattack.testers.GameDebug;

public class GameRenderer {
	private GameWorld _world;
	private OrthographicCamera _cam, _hudCam;
	private SpriteBatch _batcher, _uiBatcher;
	private GameUI _ui;
	private GameDebug _debuger;
	private ShapeRenderer _render;
	
	public GameRenderer(){

		_cam = new OrthographicCamera();
		_cam.setToOrtho(true, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		_hudCam = new OrthographicCamera();
		_hudCam.setToOrtho(true, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		_render = new ShapeRenderer();
		_render.setProjectionMatrix(_cam.combined);
		_batcher = new SpriteBatch();
		_batcher.setProjectionMatrix(_cam.combined);
		_world = new GameWorld(_batcher, _render);
		_debuger = new GameDebug(_world, _render);
		_uiBatcher = new SpriteBatch();
		_uiBatcher.setProjectionMatrix(_hudCam.combined);
		_ui = new GameUI(_world, _uiBatcher, _render);

	}
	
	public GameWorld getWorld(){
		return _world;
	}
	
	public GameUI getUI(){
		return _ui;
	}
	
	public void render(){
		drawGameWorld();
		drawUI();
	}
	
	private void drawGameWorld(){
		initGameWorldBatcher();
        _world.draw();
        finishGameWorldBatcher();
        
        _render.begin(ShapeType.Line);
        _render.setColor(Color.GREEN);
        _world.drawRender();
       
        if(Constants.DEBUG)
        	_debuger.render();
        
        _render.end();
	}
	
	private void drawUI(){
		_ui.setCurrentStageNumber(_world.getStageNumber());
		initUI();
		_ui.draw();
		finishUI();
	}
	
	private void initGameWorldBatcher(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        _batcher.begin();
        _batcher.enableBlending();
	}
	
	private void initUI(){
        _uiBatcher.begin();
        _uiBatcher.enableBlending();
	}
	
	private void finishUI(){
		_uiBatcher.end();
	}
	
	private void finishGameWorldBatcher(){
		_batcher.end();
	}
	
	public void dispose(){
		_batcher.dispose();
		_uiBatcher.dispose();
	}
}

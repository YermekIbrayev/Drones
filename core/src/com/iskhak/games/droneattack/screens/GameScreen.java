package com.iskhak.games.droneattack.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.iskhak.games.droneattack.gameworld.GameRenderer;
import com.iskhak.games.droneattack.gameworld.GameUI;
import com.iskhak.games.droneattack.gameworld.GameWorld;
import com.iskhak.games.droneattack.helpers.InputHandler;

public class GameScreen implements Screen {
	
	private GameWorld _world;
	private GameUI _ui;
	private GameRenderer _renderer;
	
	public GameScreen(){
		_renderer = new GameRenderer();
		_world = _renderer.getWorld();
		_ui = _renderer.getUI();
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(new InputHandler(_ui));
		inputMultiplexer.addProcessor(new InputHandler(_world));
		Gdx.input.setInputProcessor(inputMultiplexer);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		_world.update(delta);
		_ui.update(delta);
		_renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		_renderer.dispose();
	}

	@Override
	public void dispose() {
		_renderer.dispose();
	}

}

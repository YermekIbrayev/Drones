package com.iskhak.games.droneattack.game;

import com.badlogic.gdx.Game;
import com.iskhak.games.droneattack.helpers.AssetLoader;
import com.iskhak.games.droneattack.screens.GameScreen;

public class DAgame extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}

}

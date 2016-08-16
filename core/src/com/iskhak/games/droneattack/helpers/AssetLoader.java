package com.iskhak.games.droneattack.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	private static int EXPLOTION_COLUMNS = 8;
	private static int EXPLOTION_ROWS = 6;
	
	private static Texture texture, texture2, texture3, texture4, texture5, texture6, texture7, startScreenTexture;
	private static TextureRegion[] explosionFrames;
	public static Animation droneExplosion;
	public static TextureRegion background, drone, point, point1, bullet, target, intro;
	
	public static void load(){
		texture = new Texture(Gdx.files.internal("data/desert1.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		texture2 = new Texture(Gdx.files.internal("data/Drone_military.png"));
		texture2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		texture3 = new Texture(Gdx.files.internal("data/sphere1.png"));
		texture3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		texture4 = new Texture(Gdx.files.internal("data/sphere2.png"));
		texture4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		texture5 = new Texture(Gdx.files.internal("data/target_40x40.png"));
		texture5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		texture6 = new Texture(Gdx.files.internal("data/bullet.png"));
		texture6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		texture7 = new Texture(Gdx.files.internal("data/explosion.png"));
		texture7.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		startScreenTexture = new Texture(Gdx.files.internal("data/First_Page.png"));
		startScreenTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		background = new TextureRegion(texture, 0, 0, 960, 640);
		background.flip(false, true);
		drone = new TextureRegion(texture2, 0, 0, 154, 239);
		drone.flip(false, false);
		point = new TextureRegion(texture4, 0, 0, 50, 50);
		point.flip(false, false);
		point1 = new TextureRegion(texture3, 0, 0, 50, 50);
		point1.flip(false, false);
		bullet = new TextureRegion(texture6, 0, 0, 10, 4);
		bullet.flip(false, false);
		target = new TextureRegion(texture5, 0, 0, 50, 50);
		target.flip(false, true);
		TextureRegion[][] tmp = TextureRegion.split(texture7, texture7.getWidth()/EXPLOTION_COLUMNS, texture7.getHeight()/EXPLOTION_ROWS);
        explosionFrames = new TextureRegion[EXPLOTION_ROWS*EXPLOTION_COLUMNS];
		int index = 0;
        for (int i = 0; i < EXPLOTION_ROWS; i++) {
            for (int j = 0; j < EXPLOTION_COLUMNS; j++) {
                explosionFrames[index++] = tmp[i][j];
            }
        }
 
        droneExplosion = new Animation(0.025f,explosionFrames);
        droneExplosion.setPlayMode(PlayMode.NORMAL);
        intro = new TextureRegion(startScreenTexture,startScreenTexture.getWidth(), startScreenTexture.getHeight());
        intro.flip(false, true);
	}
	
	public static void dispose(){
		texture.dispose();
		texture2.dispose();
		texture3.dispose();
		texture4.dispose();
		texture5.dispose();
		texture6.dispose();
		texture7.dispose();
		startScreenTexture.dispose();
	}

}

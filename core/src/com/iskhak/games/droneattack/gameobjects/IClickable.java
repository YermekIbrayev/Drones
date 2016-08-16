package com.iskhak.games.droneattack.gameobjects;

public interface IClickable {

	public boolean onTouchDown(int x, int y);

	public boolean onTouchDragged(int x, int y);

	public boolean onTouchUp(int x, int y);

}

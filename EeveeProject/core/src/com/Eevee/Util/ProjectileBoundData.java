package com.Eevee.Util;

import com.badlogic.gdx.math.Vector2;

public enum ProjectileBoundData {
	MOVE1(new Vector2(25,10),30,10),
	MOVE2(new Vector2(19,13),70,40),
	MOVE3(new Vector2(70,20),70,20);
	
	private ProjectileBoundData(Vector2 offset, int width, int height) {
		this.offset = offset;
		
		this.width = width;
		this.height = height;
	}
	private Vector2 offset;
	public Vector2 getOffset() {
		return offset;
	}
	public void setOffset(Vector2 offset) {
		this.offset = offset;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	private int height;
	private int width;

}

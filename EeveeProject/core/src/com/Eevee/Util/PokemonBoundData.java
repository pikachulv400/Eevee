package com.Eevee.Util;

import com.badlogic.gdx.math.Vector2;

public enum PokemonBoundData {
	BULBASAUR(new Vector2(15,13),75,40),
	CHARMANDER(new Vector2(19,13),70,40),
	SQUIRTLE(new Vector2(70,20),70,20);
	
	private PokemonBoundData(Vector2 offset, int width, int height) {
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

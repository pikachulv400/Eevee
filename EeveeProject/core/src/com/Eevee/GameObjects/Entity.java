package com.Eevee.GameObjects;

import com.Eevee.PokemonData.PokemonName;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	private Vector2 position;
	private int height;
	private int width;
	private Vector2 velocity;
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
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

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public Entity(Vector2 position,  Vector2 velocity,int height, int width) {
		super();
		this.position = position;
		this.height = height;
		this.width = width;
		this.velocity = velocity;
	}
	public abstract boolean update(float delta);

	
}

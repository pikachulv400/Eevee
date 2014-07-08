package com.Eevee.GameObjects;

import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Vector2;

public class Projectile extends Entity {

	private int fromPlayerID;
	private int spAtk;
	private int type;
	private float timeToDie;
	private HitEffect hitEffect;
	private Ellipse bound;

	public Projectile(Vector2 position, Vector2 velocity,int height, int width,
			 int fromPlayerID, int spAtk, int type,
			float timeToDie) {
		super(position,velocity, height, width);
		// TODO Auto-generated constructor stub
		this.fromPlayerID = fromPlayerID;
		this.spAtk = spAtk;
		this.type = type;
		this.timeToDie = timeToDie;
	}

	public boolean update(float delta) {
		timeToDie--;
		this.getPosition().add(this.getVelocity());
		return timeToDie>=0;
	}
	
}

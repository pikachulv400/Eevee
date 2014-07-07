package com.Eevee.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Projectile extends Entity {

	private int fromPlayerID;
	private int spAtk;
	private int type;
	private float timeToDie;
	private HitEffect hitEffect;

	public Projectile(Vector2 position, int height, int width,
			Vector2 velocity, int fromPlayerID, int spAtk, int type,
			float timeToDie, HitEffect hitEffect) {
		super(position, height, width, velocity);
		// TODO Auto-generated constructor stub
		this.fromPlayerID = fromPlayerID;
		this.spAtk = spAtk;
		this.type = type;
		this.timeToDie = timeToDie;
		this.hitEffect = hitEffect;
	}

	public boolean update(float delta) {
		return false;
	}
}

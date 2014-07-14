package com.Eevee.GameObjects;

import com.Eevee.PokemonData.Action;
import com.Eevee.Util.PokemonBoundMap;
import com.Eevee.Util.ProjectileBoundData;
import com.Eevee.Util.ProjectileBoundMap;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Vector2;

public class Projectile extends Entity {

	private int fromPlayerID;
	private int spAtk;
	private int type;
	private float timeToDie;
	private boolean dieAfterHit;
	private HitEffect hitEffect;
	private Ellipse bound;
	private ProjectileBoundData pbd;
	
	public Projectile(Vector2 position, Vector2 velocity,int height, int width,
			 int fromPlayerID, int spAtk, int type,
			float timeToDie) {
		super(position,velocity, height, width);
		// TODO Auto-generated constructor stub
		this.setFromPlayerID(fromPlayerID);
		this.spAtk = spAtk;
		this.type = type;
		this.timeToDie = timeToDie;
		this.dieAfterHit = true;
		pbd = ProjectileBoundMap.getBoundDataByMoveName(Action.MOVE1);
		Vector2 ellipsePosition = super.getPosition().cpy().add(pbd.getOffset());
		bound = new Ellipse(ellipsePosition, pbd.getWidth(), pbd.getHeight());
		
	}

	public boolean update(float delta) {
		bound.setPosition(super.getPosition().cpy().add(pbd.getOffset()));
		timeToDie--;
		this.getPosition().add(this.getVelocity());
		return timeToDie>=0;
	}

	public Ellipse getBound() {
		return bound;
	}

	public void setBound(Ellipse bound) {
		this.bound = bound;
	}

	public int getFromPlayerID() {
		return fromPlayerID;
	}

	public void setFromPlayerID(int fromPlayerID) {
		this.fromPlayerID = fromPlayerID;
	}
	
}

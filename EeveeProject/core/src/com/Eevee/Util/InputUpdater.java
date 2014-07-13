package com.Eevee.Util;

import com.Eevee.GameObjects.Projectile;
import com.Eevee.GameWorld.GameWorld;
import com.Eevee.PokemonData.Action;
import com.Eevee.Screens.ArenaScreen;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;

public class InputUpdater {
	protected int shouldMove,shouldAttack,shouldHit;
	private InputHandler inputhandler;
	private float skillDuration = 60;
	private float cooldown = 100;
	private GameWorld myWorld;
	
	public InputUpdater(InputHandler inputhandler,GameWorld myWorld){
		this.myWorld = myWorld;
		this.inputhandler=inputhandler;
	}
	public void update() {
		shouldMove++;
		shouldAttack++;
		shouldHit++;
		if (shouldMove >= 8) {
			if(inputhandler.Moving)
			{
				inputhandler.getPokemon().setAction(Action.RUN);
			}
			if (inputhandler.MovingUp) {
				inputhandler.getPokemon().setDirection(8);// HandleMovement();
				shouldMove = 0;
			}
			if (inputhandler.MovingLeft) {
				inputhandler.getPokemon().setDirection(4);// HandleMovement();
				shouldMove = 0;
			}
			if (inputhandler.MovingRight) {
				inputhandler.getPokemon().setDirection(6);// HandleMovement();
				shouldMove = 0;
			}
			if (inputhandler.MovingDown) {
				inputhandler.getPokemon().setDirection(2);// HandleMovement();
				shouldMove = 0;
			}
			if (inputhandler.MovingDown && inputhandler.MovingLeft) {
				inputhandler.getPokemon().setDirection(1);// HandleMovement();
				shouldMove = 0;
			}
			if (inputhandler.MovingUp && inputhandler.MovingLeft) {
				inputhandler.getPokemon().setDirection(7);// HandleMovement();
				shouldMove = 0;
			}
			if (inputhandler.MovingUp && inputhandler.MovingRight) {
				inputhandler.getPokemon().setDirection(9);// HandleMovement();
				shouldMove = 0;
			}
			if (inputhandler.MovingDown && inputhandler.MovingRight) {
				inputhandler.getPokemon().setDirection(3);// HandleMovement();
				shouldMove = 0;
			}

		}
		if(shouldAttack>cooldown)
		{
			Vector2 velocity = null;
			switch(inputhandler.getPokemon().getDirection())
			{
			case 1:
				velocity = new Vector2(-0.7071f,-0.7071f);
				break;
			case 2:
				velocity = new Vector2(0,-1);
				break;
			case 3:
				velocity = new Vector2(0.7071f,-0.7071f);
				break;
			case 4:
				velocity = new Vector2(-1,0);
				break;
			case 6:
				velocity = new Vector2(1,0);
				break;
			case 7:
				velocity = new Vector2(-0.7071f,0.7071f);
				break;
			case 8:
				velocity = new Vector2(0,1);
				break;
			case 9:
				velocity = new Vector2(0.7071f,0.7071f);
				break;
			}
			if (inputhandler.useMove1)
			{
				inputhandler.getPokemon().setAction(Action.MOVE1);
				myWorld.spawnProjectile(new Projectile(inputhandler.getPokemon().getPosition().cpy().add(BoundData.BULBASAUR.getOffset()),velocity,0,0,1,1,1,400));
				shouldAttack = 0;
			}
			if(inputhandler.useMove2)
			{
				inputhandler.getPokemon().setAction(Action.MOVE2);
				myWorld.spawnProjectile(new Projectile(inputhandler.getPokemon().getPosition().cpy().add(BoundData.BULBASAUR.getOffset()),velocity.cpy().scl(6),0,0,1,1,1,400));
				shouldAttack = 0;
			}
			if(inputhandler.useMove3)
			{
				inputhandler.getPokemon().setAction(Action.MOVE3);
				myWorld.spawnProjectile(new Projectile(inputhandler.getPokemon().getPosition().cpy().add(BoundData.BULBASAUR.getOffset()),velocity.cpy().scl(6),0,0,1,1,1,400));
				shouldAttack = 0;
			}
			
		}
		
		if (shouldAttack >= cooldown) { // cooldown

		}// else if (shouldAttack >= skillDuration && shouldAttack <= cooldown) { // skill
		else if (shouldAttack >= skillDuration && shouldAttack < cooldown) {// duration
			inputhandler.Attacking=false;
		} else {
			shouldMove = 0;
		}

		if (shouldHit >= 80) { // cooldown
			if (inputhandler.isHit) {
		
				shouldHit = 0;

			} else {

			}
		} else if (shouldHit >= skillDuration && shouldHit <= cooldown) { // skill
																			// duration
			inputhandler.isHit=false;
		} else {
			shouldMove = 0;
			shouldAttack = 0;
		}
		if(shouldAttack ==skillDuration||shouldHit ==skillDuration)
		{
			inputhandler.getPokemon().setAction(Action.IDLE);
			inputhandler.Attacking=false;
		}
	}
}

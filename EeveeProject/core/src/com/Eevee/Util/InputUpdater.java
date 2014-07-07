package com.Eevee.Util;

import com.Eevee.PokemonData.Action;

public class InputUpdater {
	protected int shouldMove,shouldAttack,shouldHit;
	private InputHandler inputhandler;
	private float skillDuration = 60;
	private float cooldown = 100;
	
	public InputUpdater(InputHandler inputhandler){
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
			if (inputhandler.useMove1)
			{
				inputhandler.getPokemon().setAction(Action.MOVE1);
				shouldAttack = 0;
			}
			if(inputhandler.useMove2)
			{
				inputhandler.getPokemon().setAction(Action.MOVE2);
				shouldAttack = 0;
			}
			
		}
		
		System.out.println(shouldAttack+":"+cooldown);
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
			System.out.println("came here");
			inputhandler.Attacking=false;
		}
	}
}

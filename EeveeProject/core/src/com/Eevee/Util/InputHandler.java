package com.Eevee.Util;

import java.util.ArrayList;
import java.util.List;

import com.Eevee.GameObjects.Pokemon;
import com.Eevee.GameWorld.GameWorld;
import com.Eevee.PokemonData.Action;
import com.Eevee.Screens.ArenaScreen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {
	protected boolean MovingUp= false, MovingDown= false, MovingLeft= false, MovingRight= false, Moving= false,
			Attacking= false, useMove1= false,useMove2 = false,useMove3= false,useMove4 = false;
	public boolean isHit = false;
	private InputUpdater inputUpdater;

	private GameWorld myWorld;
	private Pokemon pokemon;
	private int KeysUp =Keys.UP;
	private int KeysDown =Keys.DOWN;
	private int KeysLeft =Keys.LEFT;
	private int KeysRight =Keys.RIGHT;
	private int KeysMove1 =Keys.Q;
	private int KeysMove2 =Keys.W;
	private int KeysMove3 =Keys.E;
	private int KeysMove4 =Keys.R;

	/*
	 * private List<SimpleButton> menuButtons;
	 * 
	 * private SimpleButton playButton;
	 * 
	 * private float scaleFactorX; private float scaleFactorY;
	 */

	public InputHandler(Pokemon pokemon,GameWorld myWorld) {
		this.pokemon = pokemon;
		pokemon.setInputhandler(this);
		this.inputUpdater = new InputUpdater(this,myWorld);
		/*
		 * this.myWorld = myWorld; myBird = myWorld.getBird();
		 * 
		 * int midPointY = myWorld.getMidPointY();
		 * 
		 * this.scaleFactorX = scaleFactorX; this.scaleFactorY = scaleFactorY;
		 * 
		 * menuButtons = new ArrayList<SimpleButton>(); playButton = new
		 * SimpleButton( 136 / 2 - (AssetLoader.playButtonUp.getRegionWidth() /
		 * 2), midPointY + 50, 29, 16, AssetLoader.playButtonUp,
		 * AssetLoader.playButtonDown); menuButtons.add(playButton);
		 */

	}

	public InputUpdater getInputUpdater() {
		return inputUpdater;
	}

	public void setInputUpdater(InputUpdater inputUpdater) {
		this.inputUpdater = inputUpdater;
	}

	@Override
	public boolean keyDown(int keycode) {

		if (keycode == KeysUp) {

			MovingUp = true;
			MovingDown = false;
			Moving = true;
		}
		if (keycode == KeysLeft) {
			MovingLeft = true;
			MovingRight = false;
			Moving = true;
		}
		if (keycode == KeysDown) {
			MovingDown = true;
			MovingUp = false;
			Moving = true;
		}
		if (keycode == KeysRight) {
			MovingRight = true;
			MovingLeft = false;
			Moving = true;

		}
		// Can now use Space Bar to play the game
		if (keycode == KeysMove1) {
			Attacking = true;
			useMove1=true;
		}
		if (keycode == KeysMove2) {
			Attacking = true;
			useMove2=true;
		}
		if (keycode == KeysMove3) {
			Attacking = true;
			useMove3=true;
		}
		if (keycode == KeysMove4) {
			isHit = true;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {

		if (keycode == KeysUp) {
			MovingUp = false;
			inputUpdater.shouldMove = 0;
			if(!MovingUp&&!MovingDown&&!MovingLeft&&!MovingRight)
			{
				pokemon.setAction(Action.IDLE);
				Moving = false;
			}
		}
		if (keycode == KeysLeft) {
			MovingLeft = false;
			inputUpdater.shouldMove = 0;
			if(!MovingUp&&!MovingDown&&!MovingLeft&&!MovingRight)
			{
				pokemon.setAction(Action.IDLE);
				Moving = false;
			}
		}
		if (keycode == KeysDown) {
			MovingDown = false;
			inputUpdater.shouldMove = 0;
			if(!MovingUp&&!MovingDown&&!MovingLeft&&!MovingRight)
			{
				pokemon.setAction(Action.IDLE);
				Moving = false;
			}
		}
		if (keycode == KeysRight) {
			MovingRight = false;
			inputUpdater.shouldMove = 0;
			if(!MovingUp&&!MovingDown&&!MovingLeft&&!MovingRight)
			{
				pokemon.setAction(Action.IDLE);
				Moving = false;
			}
		}
		
		// Can now use Space Bar to play the game
		if (keycode == KeysMove1) {
			Attacking = false;
			inputUpdater.shouldMove = 0;
			useMove1=false;
		}
		if (keycode == KeysMove2) {
			Attacking = false;
			inputUpdater.shouldMove = 0;
			useMove2=false;
		}
		if (keycode == KeysMove3) {
			Attacking = false;
			inputUpdater.shouldMove = 0;
			useMove3=false;
		}

		if (keycode == KeysMove4) {
			isHit = false;

			inputUpdater.shouldHit = 0;
		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

}

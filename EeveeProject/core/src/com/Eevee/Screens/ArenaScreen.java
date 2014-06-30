package com.Eevee.Screens;

import com.Eevee.GameObjects.Pokemon;
import com.Eevee.PokemonData.Action;
import com.Eevee.PokemonData.PokeData;
import com.Eevee.Util.AssetLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class ArenaScreen implements Screen,InputProcessor {

	private SpriteBatch 			spriteBatch = new SpriteBatch();
	private int						WIDTH,HEIGHT;
	private int shouldMove,shouldAttack,shouldHit;
	private float time ;
	private float skillDuration = 60;
	private float cooldown = 100;
	private Pokemon bulbasaur = new Pokemon(new Vector2(0,0),0,0,new Vector2(0,0),PokeData.BULBASAUR);
	boolean MovingUp = false,MovingDown = false,MovingLeft = false,MovingRight = false,Attacking = false,isHit=false;

	
	// This is the constructor, not the class declaration
	public ArenaScreen() {
		Gdx.input.setInputProcessor(this);
		/*float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();
		float gameWidth = 136;
		float gameHeight = screenHeight / (screenWidth / gameWidth);
		int midPointY = (int) (gameHeight / 2);

		world = new GameWorld(midPointY);
		Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
		renderer = new GameRenderer(world, (int) gameHeight, midPointY);
		world.setRenderer(renderer);*/
	}

	@Override
	public void render(float delta){
		GL20 gl = Gdx.graphics.getGL20();
    	gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		time +=Gdx.graphics.getDeltaTime();
		spriteBatch.begin();
		UpdatePokemon();
		spriteBatch.draw(bulbasaur.getCurrentAnimation().getKeyFrame(time), bulbasaur.getPosition().x,
				bulbasaur.getPosition().y);
		spriteBatch.end();
		/*runTime += delta;
		world.update(delta);
		renderer.render(delta, runTime);*/
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean keyDown(int keycode) {
		
		if (keycode == Keys.W) {
			System.out.println("W");
			MovingUp=true;
			MovingDown=false;
		}
		if (keycode == Keys.A) {
			System.out.println("A");
			MovingLeft=true;
			MovingRight=false;
		}
		if (keycode == Keys.S) {
			System.out.println("S");
			MovingDown=true;
			MovingUp=false;
		}
		if (keycode == Keys.D) {
			System.out.println("D");
			MovingRight=true;
			MovingLeft=false;
		}
		// Can now use Space Bar to play the game
		if (keycode == Keys.SPACE) {
			Attacking = true;
		}
		if (keycode == Keys.H) {
			isHit = true;
		}

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		if (keycode == Keys.W) {
			MovingUp=false;
			shouldMove = 0;
		}
		if (keycode == Keys.A) {
			MovingLeft=false;
			shouldMove = 0;
		}
		if (keycode == Keys.S) {
			MovingDown=false;
			shouldMove = 0;
		}
		if (keycode == Keys.D) {
			MovingRight=false;
			shouldMove = 0;
		}
		// Can now use Space Bar to play the game
		if (keycode == Keys.SPACE) {
			Attacking = false;
			shouldMove = 0;
		}
		
		if (keycode == Keys.H) {
			isHit = false;
			shouldHit = 0;
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

	public void UpdatePokemon() {
		shouldHit++;
		shouldMove++;
		shouldAttack++;
		bulbasaur.setSpeed(4);
		bulbasaur.setPosition(bulbasaur.getPosition().add(new Vector2(bulbasaur.getVelocity().x * bulbasaur.getSpeed(),bulbasaur.getVelocity().y * bulbasaur.getSpeed())));
		
		System.out.println(shouldMove +":"+shouldAttack);
		if (shouldMove >= 8) {
			if (MovingUp) {
				bulbasaur.setDirection(8);// HandleMovement();
				bulbasaur.setVelocity(new Vector2(0,1));
				shouldMove = 0;
			}
			if (MovingLeft) {
				bulbasaur.setDirection(4);// HandleMovement();
				bulbasaur.setVelocity(new Vector2(-1,0));
				shouldMove = 0;
			}
			if (MovingRight) {
				bulbasaur.setDirection(6);// HandleMovement();
				bulbasaur.setVelocity(new Vector2(1,0));
				shouldMove = 0;
			}
			if (MovingDown) {
				bulbasaur.setDirection(2);// HandleMovement();
				bulbasaur.setVelocity(new Vector2(0,-1));
				shouldMove = 0;
			}
			if (MovingDown && MovingLeft) {
				bulbasaur.setDirection(1);// HandleMovement();
				bulbasaur.setVelocity(new Vector2(-0.66f,-0.66f));
				shouldMove = 0;
			}
			if (MovingUp && MovingLeft) {
				bulbasaur.setDirection(7);// HandleMovement();
				bulbasaur.setVelocity(new Vector2(-0.66f,0.66f));
				shouldMove = 0;
			}
			if (MovingUp && MovingRight) {
				bulbasaur.setDirection(9);// HandleMovement();
				bulbasaur.setVelocity(new Vector2(0.66f,0.66f));
				shouldMove = 0;
			}
			if (MovingDown && MovingRight) {
				bulbasaur.setDirection(3);// HandleMovement();
				bulbasaur.setVelocity(new Vector2(0.66f,-0.66f));
				shouldMove = 0;
			}

		}

		if (shouldAttack >= cooldown){ //cooldown
			if (Attacking) {
				time = 0;
				bulbasaur.setAction(Action.MOVE1);
				shouldAttack = 0;
				
			}
			else {
				
			}
		}
		else if(shouldAttack >=skillDuration&&shouldAttack<=cooldown){ //skill duration
			bulbasaur.setAction(Action.RUN);
		}
		else
		{
			shouldMove = 0;
		}
		
		
		if (shouldHit >= cooldown){ //cooldown
			if (isHit) {
				time = 0;
				bulbasaur.setAction(Action.HURT);
				shouldHit = 0;
				
			}
			else {
				
			}
		}
		else if(shouldHit >=skillDuration&&shouldHit<=cooldown){ //skill duration
			bulbasaur.setAction(Action.RUN);
		}
		else
		{
			shouldMove = 0;
			shouldAttack =0;
		}
		
	}

}
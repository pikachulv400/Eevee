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
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;


public class TestScreen implements Screen,InputProcessor {

	private SpriteBatch 			spriteBatch = new SpriteBatch();
	Polygon bulbapoly = new Polygon(new float[]{0.0559895820915699f*850-200,0.9674479365348816f*850-200,0.0442708320915699f*850-200,0.9557291865348816f*850-200,0.0325520820915699f*850-200,0.9166666865348816f*850-200,0.046875f*850-200,0.8997395634651184f*850-200,0.0755208358168602f*850-200,0.89453125f*850-200,0.0911458358168602f*850-200,0.9010416865348816f*850-200,0.0911458358168602f*850-200,0.9010416865348816f*850-200,0.1028645858168602f*850-200,0.9205729365348816f*850-200,0.0911458358168602f*850-200,0.9518229365348816f*850-200,0.0794270858168602f*850-200,0.9674479365348816f*850-200,0.0638020858168602f*850-200,0.9713541865348816f*850-200,0.0559895820915699f*850-200,0.9674479365348816f*850-200});
	Rectangle bounds = new Rectangle(0, 0, 70, 20);
	Polygon polygon = new Polygon(new float[]{0,0,bounds.width,0,bounds.width,bounds.height,0,bounds.height,0,0});
	Ellipse ellipse ;
	private int						WIDTH,HEIGHT;
	private int shouldMove,shouldAttack,shouldHit;
	private float time ;
	private float skillDuration = 60;
	private float cooldown = 100;
	private Pokemon charmander = new Pokemon(new Vector2(0,0),0,0,new Vector2(0,0),PokeData.CHARMANDER);
	private Pokemon bulbasaur = new Pokemon(new Vector2(50,50),0,0,new Vector2(0,0),PokeData.BULBASAUR);
	boolean MovingUp = false,MovingDown = false,MovingLeft = false,MovingRight = false,Attacking = false,isHit=false;
	private OrthographicCamera camera;
	ShapeRenderer shapeRenderer = new ShapeRenderer();
	
	// This is the constructor, not the class declaration
	public TestScreen() {
		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(bulbasaur.getPosition().x,bulbasaur.getPosition().y, 0f);
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
		Vector2 EllipsePosition = bulbasaur.getPosition();
		ellipse = new Ellipse(EllipsePosition.x-35.5f,EllipsePosition.y-35.5f,70,30);

		System.out.println(bulbasaur.getPosition());
		GL20 gl = Gdx.graphics.getGL20();
    	gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		time +=Gdx.graphics.getDeltaTime();
		spriteBatch.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setProjectionMatrix(camera.combined);
	    shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.ellipse(ellipse.x, ellipse.y, ellipse.width, ellipse.height);
        shapeRenderer.end();
		spriteBatch.begin();
		spriteBatch.draw(bulbasaur.getCurrentAnimation().getKeyFrame(time), bulbasaur.getPosition().x-bulbasaur.getCurrentAnimation().getKeyFrame(time).getRegionWidth()/2,
				bulbasaur.getPosition().y-bulbasaur.getCurrentAnimation().getKeyFrame(time).getRegionWidth()/2);
		spriteBatch.draw(charmander.getCurrentAnimation().getKeyFrame(time), charmander.getPosition().x,
				charmander.getPosition().y);
		spriteBatch.end();


        UpdatePokemon();
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
		camera.translate(new Vector2(bulbasaur.getVelocity().x * bulbasaur.getSpeed(), bulbasaur.getVelocity().y * bulbasaur.getSpeed()));
		camera.update();

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
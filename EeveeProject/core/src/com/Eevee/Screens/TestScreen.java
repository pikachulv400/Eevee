package com.Eevee.Screens;

import com.Eevee.GameObjects.Pokemon;
import com.Eevee.PokemonData.Action;
import com.Eevee.PokemonData.PokeData;
import com.Eevee.Util.AssetLoader;
import com.Eevee.Util.InputHandler;
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


public class TestScreen implements Screen {

	private SpriteBatch 			spriteBatch = new SpriteBatch();
	Polygon bulbapoly = new Polygon(new float[]{0.0559895820915699f*850-200,0.9674479365348816f*850-200,0.0442708320915699f*850-200,0.9557291865348816f*850-200,0.0325520820915699f*850-200,0.9166666865348816f*850-200,0.046875f*850-200,0.8997395634651184f*850-200,0.0755208358168602f*850-200,0.89453125f*850-200,0.0911458358168602f*850-200,0.9010416865348816f*850-200,0.0911458358168602f*850-200,0.9010416865348816f*850-200,0.1028645858168602f*850-200,0.9205729365348816f*850-200,0.0911458358168602f*850-200,0.9518229365348816f*850-200,0.0794270858168602f*850-200,0.9674479365348816f*850-200,0.0638020858168602f*850-200,0.9713541865348816f*850-200,0.0559895820915699f*850-200,0.9674479365348816f*850-200});
	Rectangle bounds = new Rectangle(0, 0, 70, 20);
	Polygon polygon = new Polygon(new float[]{0,0,bounds.width,0,bounds.width,bounds.height,0,bounds.height,0,0});
	private int						WIDTH,HEIGHT;
	private float time ;
	Ellipse ellipse ;
	private float skillDuration = 60;
	private float cooldown = 100;
	private Pokemon charmander = new Pokemon(new Vector2(0,0),0,0,new Vector2(0,0),PokeData.CHARMANDER);
	private Pokemon bulbasaur = new Pokemon(new Vector2(50,50),0,0,new Vector2(0,0),PokeData.BULBASAUR);
	private OrthographicCamera camera;
	ShapeRenderer shapeRenderer = new ShapeRenderer();
	private InputHandler inputHandler = new InputHandler(bulbasaur);
	
	// This is the constructor, not the class declaration
	public TestScreen() {
		
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		 camera.position.set(bulbasaur.getPosition().x+52.5f,bulbasaur.getPosition().y+52.5f, 0f);
		Gdx.input.setInputProcessor(inputHandler);
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
		bulbapoly =  new Polygon(new float[]{0.0559895820915699f*849+bulbasaur.getPosition().x,0.9674479365348816f*849-800+bulbasaur.getPosition().y,0.0442708320915699f*849+bulbasaur.getPosition().x,0.9557291865348816f*849-800+bulbasaur.getPosition().y,0.0325520820915699f*849+bulbasaur.getPosition().x,0.9166666865348816f*849-800+bulbasaur.getPosition().y,0.046875f*849+bulbasaur.getPosition().x,0.8997395634651184f*849-800+bulbasaur.getPosition().y,0.0755208358168602f*849+bulbasaur.getPosition().x,0.89453125f*849-800+bulbasaur.getPosition().y,0.0911458358168602f*849+bulbasaur.getPosition().x,0.9010416865348816f*849-800+bulbasaur.getPosition().y,0.0911458358168602f*849+bulbasaur.getPosition().x,0.9010416865348816f*849-800+bulbasaur.getPosition().y,0.1028645858168602f*849+bulbasaur.getPosition().x,0.9205729365348816f*849-800+bulbasaur.getPosition().y,0.0911458358168602f*849+bulbasaur.getPosition().x,0.9518229365348816f*849-800+bulbasaur.getPosition().y,0.0794270858168602f*849+bulbasaur.getPosition().x,0.9674479365348816f*849-800+bulbasaur.getPosition().y,0.0638020858168602f*849+bulbasaur.getPosition().x,0.9713541865348816f*849-800+bulbasaur.getPosition().y,0.0559895820915699f*849+bulbasaur.getPosition().x,0.9674479365348816f*849-800+bulbasaur.getPosition().y});
		Vector2 EllipsePosition = bulbasaur.getPosition();

		ellipse = new Ellipse(EllipsePosition.x+17f,EllipsePosition.y+10f,70,30);
		GL20 gl = Gdx.graphics.getGL20();
    	gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		time +=Gdx.graphics.getDeltaTime();
		shapeRenderer.begin(ShapeType.Line);

		shapeRenderer.setProjectionMatrix(camera.combined);

		shapeRenderer.setColor(1, 0, 0, 1);

		shapeRenderer.ellipse(ellipse.x, ellipse.y, ellipse.width, ellipse.height);

		shapeRenderer.end();
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		UpdatePokemon(delta);
		spriteBatch.draw(bulbasaur.getCurrentAnimation().getKeyFrame(time), bulbasaur.getPosition().x,
				bulbasaur.getPosition().y);
		spriteBatch.draw(charmander.getCurrentAnimation().getKeyFrame(time), charmander.getPosition().x,
				charmander.getPosition().y);
		spriteBatch.end();
		
        bulbapoly.setPosition(bulbasaur.getPosition().x,bulbasaur.getPosition().y);
        shapeRenderer.end();
		/*runTime += delta;
		world.update(delta);
		renderer.render(delta, runTime);*/
	}

	

	public void UpdatePokemon(float delta) {
		inputHandler.getInputUpdater().update();
		bulbasaur.update(delta);
		bulbasaur.setPosition(bulbasaur.getPosition());
		camera.translate(bulbasaur.getVelocity().cpy());
		camera.update();

		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
package com.Eevee.Screens;

import java.util.ArrayList;

import com.Eevee.GameObjects.Pokemon;
import com.Eevee.GameObjects.Projectile;
import com.Eevee.PokemonData.Action;
import com.Eevee.PokemonData.PokemonName;
import com.Eevee.Util.AssetLoader;
import com.Eevee.Util.BoundData;
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

	private SpriteBatch spriteBatch = new SpriteBatch();
	private float time;
	Ellipse ellipse, pewpewEllipse;
	private Pokemon charmander = new Pokemon(new Vector2(0, 0),new Vector2(0, 0), 0, 0, PokemonName.CHARMANDER);
	private Pokemon bulbasaur = new Pokemon(new Vector2(50, 50), new Vector2(0, 0),106, 106, PokemonName.BULBASAUR);
	private Projectile pewpew;
	private OrthographicCamera camera;
	ShapeRenderer shapeRenderer = new ShapeRenderer();
	private InputHandler inputHandler = new InputHandler(bulbasaur, this);
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	Sprite background;

	// This is the constructor, not the class declaration
	public TestScreen() {

		camera = new OrthographicCamera(Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		camera.position.set(bulbasaur.getPosition().x + 52.5f,
				bulbasaur.getPosition().y + 52.5f, 0f);
		Gdx.input.setInputProcessor(inputHandler);
		background= new Sprite(AssetLoader.Background1);
		background.setScale(2);
		/*
		 * float screenWidth = Gdx.graphics.getWidth(); float screenHeight =
		 * Gdx.graphics.getHeight(); float gameWidth = 136; float gameHeight =
		 * screenHeight / (screenWidth / gameWidth); int midPointY = (int)
		 * (gameHeight / 2);
		 * 
		 * world = new GameWorld(midPointY); Gdx.input.setInputProcessor(new
		 * InputHandler(world, screenWidth / gameWidth, screenHeight /
		 * gameHeight)); renderer = new GameRenderer(world, (int) gameHeight,
		 * midPointY); world.setRenderer(renderer);
		 */
	}

	@Override
	public void render(float delta) {
		inputHandler.getInputUpdater().update();
		Vector2 PewPewPosition;

		Vector2 EllipsePosition = bulbasaur.getPosition().cpy().add(BoundData.BULBASAUR.getOffset());
		
		ellipse = new Ellipse(EllipsePosition,
				BoundData.BULBASAUR.getWidth(), BoundData.BULBASAUR.getHeight());

		GL20 gl = Gdx.graphics.getGL20();
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		time += Gdx.graphics.getDeltaTime();
		
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		background.draw(spriteBatch);
		spriteBatch.end();
		
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.setColor(0, 0, 0, 1);

		shapeRenderer.ellipse(ellipse.x, ellipse.y, ellipse.width,
				ellipse.height);
		shapeRenderer.end();
		
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.setColor(1, 0, 0, 1);
		if (pewpew != null) {
			if(pewpew.update(delta))
			{
			shapeRenderer.setColor(1, 1, 0, 1);
			PewPewPosition = pewpew.getPosition();
			pewpewEllipse = new Ellipse(PewPewPosition.x, PewPewPosition.y, BoundData.BULBASAUR.getWidth(), BoundData.BULBASAUR.getHeight());

			shapeRenderer.ellipse(pewpewEllipse.x, pewpewEllipse.y,
					pewpewEllipse.width, pewpewEllipse.height);
			}
		}
		shapeRenderer.end();
		
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		UpdatePokemon(delta);
		if(bulbasaur.getPosition().y>charmander.getPosition().y){
		spriteBatch.draw(bulbasaur.getCurrentAnimation().getKeyFrame(time),
				bulbasaur.getPosition().x, bulbasaur.getPosition().y);
		spriteBatch.draw(charmander.getCurrentAnimation().getKeyFrame(time),
				charmander.getPosition().x, charmander.getPosition().y);
		}
		else
		{
			
			spriteBatch.draw(charmander.getCurrentAnimation().getKeyFrame(time),
					charmander.getPosition().x, charmander.getPosition().y);
			spriteBatch.draw(bulbasaur.getCurrentAnimation().getKeyFrame(time),
					bulbasaur.getPosition().x, bulbasaur.getPosition().y);
		}
		spriteBatch.end();
		

		/*
		 * runTime += delta; world.update(delta); renderer.render(delta,
		 * runTime);
		 */
	}

	public void UpdatePokemon(float delta) {
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

	public void spawnProjectile(Projectile p) {
		pewpew = p;
	}
	

}
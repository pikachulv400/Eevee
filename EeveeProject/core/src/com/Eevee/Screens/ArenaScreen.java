package com.Eevee.Screens;

import com.Eevee.GameObjects.Pokemon;
import com.Eevee.GameWorld.GameRenderer;
import com.Eevee.GameWorld.GameWorld;
import com.Eevee.PokemonData.Action;
import com.Eevee.PokemonData.PokemonName;
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
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class ArenaScreen implements Screen{
	private GameWorld world;
	private GameRenderer renderer;
//	private InputHandler inputHandler = new InputHandler(bulbasaur, this);
	private float runTime;

	// This is the constructor, not the class declaration
	public ArenaScreen() {
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		world = new GameWorld();
		//Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
		renderer = new GameRenderer(world, screenWidth, screenHeight);
		world.setRenderer(renderer);
	}

	@Override
	public void render(float delta){
		runTime+=Gdx.graphics.getDeltaTime();
		world.update(delta);
		renderer.render();
		//renderPokemons();
		//renderProjectiles();
		//inputHandler.getInputUpdater().update();
	/*	GL20 gl = Gdx.graphics.getGL20();
    	gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		time +=Gdx.graphics.getDeltaTime();
		spriteBatch.begin();
		UpdatePokemon();
		spriteBatch.draw(bulbasaur.getCurrentAnimation().getKeyFrame(time), bulbasaur.getPosition().x,
				bulbasaur.getPosition().y);
		spriteBatch.draw(charmander.getCurrentAnimation().getKeyFrame(time), charmander.getPosition().x,
				charmander.getPosition().y);
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

	

}
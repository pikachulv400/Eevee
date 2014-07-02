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


public class ArenaScreen implements Screen{
	
	// This is the constructor, not the class declaration
	public ArenaScreen() {
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
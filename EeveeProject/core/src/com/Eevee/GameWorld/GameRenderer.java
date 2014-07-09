package com.Eevee.GameWorld;

import java.util.List;

/*
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;
*/






import com.Eevee.GameObjects.Pokemon;
import com.Eevee.Util.BoundData;
import com.Eevee.Util.BoundMap;
import com.Eevee.net.Master.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class GameRenderer {
	
	private GameWorld world;
	private float runTime;
	private SpriteBatch batcher;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	private Pokemon localpokemon;
	float test =0;

	public GameRenderer(GameWorld world, int gameWidth, int gameHeight) {
		
		this.world = world;
		localpokemon=world.getLocalPlayer().getInput().getPokemon();
		camera = new OrthographicCamera(gameWidth, gameHeight);
		camera.position.set(localpokemon.getPosition().x + 52.5f, localpokemon.getPosition().y + 52.5f, 0f);
		//camera.position.set(world.getLocalPlayer().getPokemon().getPosition().y+52.5f,world.getLocalPlayer().getPokemon().getPosition().y+52.5f, 0f);
		Gdx.input.setInputProcessor(world.getLocalPlayer().getInput());
		
		batcher = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		
	}
	
	public void render(){
		runTime+=Gdx.graphics.getDeltaTime();
		GL20 gl = Gdx.graphics.getGL20();
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batcher.setProjectionMatrix(camera.combined);
		batcher.begin();
		renderBackground(batcher);
		renderPokemon(batcher,shapeRenderer);
		renderProjectiles(batcher);
		batcher.end();
		updateCamera();
		
	}
private void updateCamera() {
	camera.translate(localpokemon.getVelocity().cpy());
	camera.update();
	}

	private void renderProjectiles(SpriteBatch batcher) {
		// TODO Auto-generated method stub
		
		
	}

	private void renderPokemon(SpriteBatch batcher, ShapeRenderer shapeRenderer) {

		// TODO Auto-generated method stub
		float index = 0.25f;
		for(Player player:world.getPlayerList())
		{
			batcher.setColor(index+=0.22f,index+=0.22f,index+=0.22f,1);
			System.out.println(test);
			Pokemon pokemon =player.getInput().getPokemon();
			batcher.end();
			renderPokemonBound(pokemon,shapeRenderer);
			batcher.begin();
			batcher.draw(pokemon.getCurrentAnimation().getKeyFrame(runTime),
					pokemon.getPosition().x, pokemon.getPosition().y);
		}
		batcher.setColor(Color.WHITE);
	}
	private void renderPokemonBound(Pokemon pokemon, ShapeRenderer shapeRenderer){
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.ellipse(pokemon.getBound().x,pokemon.getBound().y,pokemon.getBound().width,pokemon.getBound().height);
		shapeRenderer.end();
	}

	private void renderBackground(SpriteBatch batcher) {
		// TODO Auto-generated method stub
		world.getBackground().draw(batcher);
	}
}

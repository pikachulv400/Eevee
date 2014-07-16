package com.Eevee.GameWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 import aurelienribon.tweenengine.Tween;
 import aurelienribon.tweenengine.TweenEquations;
 import aurelienribon.tweenengine.TweenManager;
 */

import java.util.TreeMap;

import javax.swing.event.ListSelectionEvent;

import com.Eevee.GameObjects.Pokemon;
import com.Eevee.GameObjects.Projectile;
import com.Eevee.Util.PokemonBoundData;
import com.Eevee.Util.PokemonBoundMap;
import com.Eevee.net.Master.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

public class GameRenderer {

	private GameWorld world;
	private float runTime;
	public SpriteBatch batcher;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;
	private Pokemon localpokemon;
	BitmapFont emufont = new BitmapFont(Gdx.files.internal("data/emulogic.fnt"));
	float test = 0;

	public GameRenderer(GameWorld world, int gameWidth, int gameHeight) {

		this.world = world;
		localpokemon = world.getLocalPlayer().getInput().getPokemon();
		camera = new OrthographicCamera(gameWidth, gameHeight);
		camera.position.set(localpokemon.getPosition().x + 52.5f,
				localpokemon.getPosition().y + 52.5f, 0f);
		// camera.position.set(world.getLocalPlayer().getPokemon().getPosition().y+52.5f,world.getLocalPlayer().getPokemon().getPosition().y+52.5f,
		// 0f);
		Gdx.input.setInputProcessor(world.getLocalPlayer().getInput());

		batcher = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);

	}

	public void render() {
		runTime += Gdx.graphics.getDeltaTime();
		GL20 gl = Gdx.graphics.getGL20();
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batcher.setProjectionMatrix(camera.combined);
		batcher.begin();
		renderBackground(batcher);
		renderPokemon(batcher, shapeRenderer);
		renderProjectiles(batcher, shapeRenderer);
		emufont.setColor(Color.RED);
		emufont.draw(batcher, "FPS:" + Gdx.graphics.getFramesPerSecond(),
				camera.position.x + 150f, camera.position.y + 220f);
		emufont.draw(batcher,
				"HP:" + localpokemon.getHp() + "/" + localpokemon.getMaxHp(),
				camera.position.x - 250f, camera.position.y + 230f);
		emufont.draw(batcher,
				"PP:" + localpokemon.getPp() + "/" + localpokemon.getMaxPp(),
				camera.position.x - 250f, camera.position.y + 200f);
		emufont.draw(batcher, "EXP:" + localpokemon.getExp() + "/" + "100",
				camera.position.x - 250f, camera.position.y + 170f);
		batcher.end();
		updateCamera();

	}

	private void updateCamera() {
			if (localpokemon.getPosition().x - 270 >= GameWorld
					.getBackground().getX() &&localpokemon.getPosition().x  <= 820) {
				camera.position.set(localpokemon.getPosition().cpy().x+52.5f,
						camera.position.cpy().y, 0f);
				
			}
			if (localpokemon.getPosition().y - 185 >= GameWorld
					.getBackground().getY()&&localpokemon.getPosition().y  <= 600) {

				camera.position.set(camera.position.cpy().x,
						localpokemon.getPosition().cpy().y+52.5f, 0f);
			}
	

		camera.update();
	}

	private void renderProjectiles(SpriteBatch batcher,
			ShapeRenderer shapeRenderer) {
		// TODO Auto-generated method stub
		for (Projectile projectile : world.getProjectileList()) {
			batcher.end();
			renderProjectileBound(projectile);
			batcher.begin();
		}

	}

	private void renderProjectileBound(Projectile projectile) {
		// TODO Auto-generated method stub
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.identity();
		shapeRenderer.setColor(Color.BLACK);
		shapeRenderer.ellipse(projectile.getBound().x, projectile.getBound().y,
				projectile.getBound().width, projectile.getBound().height);
		shapeRenderer.end();
	}

	private void renderPokemon(SpriteBatch batcher, ShapeRenderer shapeRenderer) {

		// TODO Auto-generated method stub
		ArrayList<Pokemon> pokemonYAxis = new ArrayList<Pokemon>();
		for (Player player : world.getPlayerList()) {
			pokemonYAxis.add(player.getInput().getPokemon());
		}
		Collections.sort(pokemonYAxis, new Comparator<Pokemon>() {
			@Override
			public int compare(Pokemon arg0, Pokemon arg1) {
				// TODO Auto-generated method stub
				if ((arg0).getPosition().cpy().y < (arg1).getPosition().cpy().y) {
					return 1;
				} else {
					return -1;
				}
			}

		});
		for (int i = 0; i < pokemonYAxis.size(); i++) {
			// batcher.setColor(index+=0.22f,index+=0.22f,index+=0.22f,1);
			batcher.end();
			renderPokemonBound(pokemonYAxis.get(i), shapeRenderer);
			batcher.begin();
			batcher.draw(
					pokemonYAxis.get(i).getCurrentAnimation()
							.getKeyFrame(runTime), pokemonYAxis.get(i)
							.getPosition().x,
					pokemonYAxis.get(i).getPosition().y);
		}
		batcher.setColor(Color.WHITE);
	}

	private void renderPokemonBound(Pokemon pokemon, ShapeRenderer shapeRenderer) {
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.identity();
		shapeRenderer.setColor(Color.BLACK);
//		System.out.println("pokemon.getBound().x+(pokemon.getBound().width/2) ="+ pokemon.getBound().x+(pokemon.getBound().width/2));
//		System.out.println("pokemon.getBound().x+(pokemon.getBound().height/2) ="+pokemon.getBound().y+(pokemon.getBound().height/2));
		shapeRenderer.translate( pokemon.getBound().x+(pokemon.getBound().width/2), pokemon.getBound().y+(pokemon.getBound().height/2), 0);
	//	shapeRenderer.rotate(0,0,1,90);
		shapeRenderer.ellipse(-(pokemon.getBound().width/2), -(pokemon.getBound().height/2),
				pokemon.getBound().width, pokemon.getBound().height);
		shapeRenderer.end();
//		
//		shapeRenderer.setProjectionMatrix(camera.combined);
//		shapeRenderer.begin(ShapeType.Filled);
//		shapeRenderer.identity();
//		shapeRenderer.setColor(Color.BLACK);
//		System.out.println("pokemon.getBound().x+(pokemon.getBound().width/2) ="+ pokemon.getBound().x+(pokemon.getBound().width/2));
//		System.out.println("pokemon.getBound().x+(pokemon.getBound().height/2) ="+pokemon.getBound().y+(pokemon.getBound().height/2));
//		shapeRenderer.translate(pokemon.getBound().x+(pokemon.getBound().width/2), pokemon.getBound().y+(pokemon.getBound().height/2), 0);
//		shapeRenderer.rotate(0,0,1,50);
//		shapeRenderer.ellipse(pokemon.getBound().x, pokemon.getBound().y,
//				pokemon.getBound().width, pokemon.getBound().height);
//		shapeRenderer.end();
	}

	private void renderBackground(SpriteBatch batcher) {
		// TODO Auto-generated method stub
		world.getBackground().draw(batcher);
	}

}

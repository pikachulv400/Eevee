package com.Eevee.GameWorld;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.Eevee.GameObjects.Pokemon;
import com.Eevee.GameObjects.Projectile;
import com.Eevee.PokemonData.PokemonName;
import com.Eevee.Screens.ArenaScreen;
import com.Eevee.Util.AssetLoader;
import com.Eevee.Util.InputHandler;
import com.Eevee.net.Master.Player;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameWorld {
	private List<Player> playerList = Collections.synchronizedList(new ArrayList<Player>());
	private List<Projectile> projectileList = Collections.synchronizedList(new ArrayList<Projectile>());
	private Sprite background;
	public Sprite getBackground() {
		return background;
	}
	public void setBackground(Sprite background) {
		this.background = background;
	}
	private GameRenderer renderer;

	public enum GameState {
		SELECTION, LOADING, ARENA, GAMEOVER
	}

	public GameWorld() {
		Player player1 = new Player(001,new InputHandler(new Pokemon(new Vector2(50, 50),106, 106, PokemonName.CHARMANDER), this));
		Player player2 = new Player(002,new InputHandler(new Pokemon(new Vector2(150, 50),106, 106, PokemonName.CHARMANDER), this));
		Player player3 = new Player(003,new InputHandler(new Pokemon(new Vector2(250, 50),106, 106, PokemonName.CHARMANDER), this));
		Player player4 = new Player(004,new InputHandler(new Pokemon(new Vector2(350, 50),106, 106, PokemonName.CHARMANDER), this));
		Player player5 = new Player(003,new InputHandler(new Pokemon(new Vector2(450, 50),106, 106, PokemonName.CHARMANDER), this));
		Player player6 = new Player(004,new InputHandler(new Pokemon(new Vector2(550, 50),106, 106, PokemonName.CHARMANDER), this));

		playerList.add(player1);
		playerList.add(player2);
		playerList.add(player3);
		playerList.add(player4);
		playerList.add(player5);
		playerList.add(player6);
		
		background= new Sprite(AssetLoader.Background1);
		background.setScale(2);
/*		currentState = GameState.MENU;
		this.midPointY = midPointY;
		bird = new Bird(33, midPointY - 5, 17, 12);
		// The grass should start 66 pixels below the midPointY
		scroller = new ScrollHandler(this, midPointY + 66);
		ground = new Rectangle(0, midPointY + 66, 137, 11);*/
	}
/*
	public void update(float delta) {
		runTime += delta;

		switch (currentState) {
		case READY:
		case MENU:
			updateReady(delta);
			break;

		case RUNNING:
			updateRunning(delta);
			break;
		default:
			break;
		}

	}

	private void updateReady(float delta) {
		bird.updateReady(runTime);
		scroller.updateReady(delta);
	}

	public void updateRunning(float delta) {
		if (delta > .15f) {
			delta = .15f;
		}

		bird.update(delta);
		scroller.update(delta);

		if (scroller.collides(bird) && bird.isAlive()) {
			scroller.stop();
			bird.die();
			AssetLoader.dead.play();
			renderer.prepareTransition(255, 255, 255, .3f);

			AssetLoader.fall.play();
		}

		if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {

			if (bird.isAlive()) {
				AssetLoader.dead.play();
				renderer.prepareTransition(255, 255, 255, .3f);

				bird.die();
			}

			scroller.stop();
			bird.decelerate();
			currentState = GameState.GAMEOVER;

			if (score > AssetLoader.getHighScore()) {
				AssetLoader.setHighScore(score);
				currentState = GameState.HIGHSCORE;
			}
		}
	}

	public Bird getBird() {
		return bird;

	}

	public int getMidPointY() {
		return midPointY;
	}

	public ScrollHandler getScroller() {
		return scroller;
	}

	public int getScore() {
		return score;
	}

	public void addScore(int increment) {
		score += increment;
	}

	public void start() {
		currentState = GameState.RUNNING;
	}

	public void ready() {
		currentState = GameState.READY;
		renderer.prepareTransition(0, 0, 0, 1f);
	}

	public void restart() {
		score = 0;
		bird.onRestart(midPointY - 5);
		scroller.onRestart();
		ready();
	}

	public boolean isReady() {
		return currentState == GameState.READY;
	}

	public boolean isGameOver() {
		return currentState == GameState.GAMEOVER;
	}

	public boolean isHighScore() {
		return currentState == GameState.HIGHSCORE;
	}

	public boolean isMenu() {
		return currentState == GameState.MENU;
	}

	public boolean isRunning() {
		return currentState == GameState.RUNNING;
	}
*/
	public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}


	public List<Projectile> getProjectileList() {
		return projectileList;
	}

	public void setProjectileList(List<Projectile> projectileList) {
		this.projectileList = projectileList;
	}
	public List<Player> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	public Player getLocalPlayer(){
		return playerList.get(0);
	}
	public void spawnProjectile(Projectile projectile) {
		// TODO Auto-generated method stub
		
	}
	public void update(float delta){
		for(Player player:playerList)
		{
			player.update(delta);
		}
	}


}
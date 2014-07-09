package com.Eevee.Util;

import java.util.HashMap;

import com.Eevee.PokemonData.Action;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture Bulbasaur,Charmander;
	public static int bulbasaurSize = 105;
	public static int charmanderSize = 106;
	public static Texture Background1;
	public static TextureRegion[][] BulbasaurRegions;
	public static TextureRegion[][] CharmanderRegions;
	public static TextureRegion tempRegions[] = new TextureRegion[10];

	public static Animation Bulbasaur_1_R, Bulbasaur_2_R, Bulbasaur_3_R,
			Bulbasaur_4_R, Bulbasaur_5_R, Bulbasaur_6_R, Bulbasaur_7_R,
			Bulbasaur_8_R, Bulbasaur_9_R, Bulbasaur_1_M1, Bulbasaur_2_M1,
			Bulbasaur_3_M1, Bulbasaur_4_M1, Bulbasaur_5_M1, Bulbasaur_6_M1,
			Bulbasaur_7_M1, Bulbasaur_8_M1, Bulbasaur_9_M1, Bulbasaur_1_M2,
			Bulbasaur_2_M2, Bulbasaur_3_M2, Bulbasaur_4_M2, Bulbasaur_5_M2,
			Bulbasaur_6_M2, Bulbasaur_7_M2, Bulbasaur_8_M2, Bulbasaur_9_M2,
			Bulbasaur_1_H,Bulbasaur_2_H,Bulbasaur_3_H,Bulbasaur_4_H,
			Bulbasaur_5_H,Bulbasaur_6_H,Bulbasaur_7_H,Bulbasaur_8_H,Bulbasaur_9_H, 
			Bulbasaur_1_I,Bulbasaur_2_I,Bulbasaur_3_I,Bulbasaur_4_I,
			Bulbasaur_5_I,Bulbasaur_6_I,Bulbasaur_7_I,Bulbasaur_8_I,Bulbasaur_9_I,// Bulbasaur
			
			Charmander_1_R, Charmander_2_R, Charmander_3_R, Charmander_4_R,
			Charmander_5_R, Charmander_6_R, Charmander_7_R, Charmander_8_R,
			Charmander_9_R, 
			Charmander_1_M1, Charmander_2_M1, Charmander_3_M1,
			Charmander_4_M1, Charmander_5_M1, Charmander_6_M1, Charmander_7_M1,
			Charmander_8_M1, Charmander_9_M1,
			Charmander_1_M2, Charmander_2_M2, Charmander_3_M2,
			Charmander_4_M2, Charmander_5_M2, Charmander_6_M2, Charmander_7_M2,
			Charmander_8_M2, Charmander_9_M2,
			Charmander_1_M3, Charmander_2_M3, Charmander_3_M3,
			Charmander_4_M3, Charmander_5_M3, Charmander_6_M3, Charmander_7_M3,
			Charmander_8_M3, Charmander_9_M3,
			Charmander_1_H, Charmander_2_H,
			Charmander_3_H, Charmander_4_H, Charmander_5_H, Charmander_6_H,
			Charmander_7_H, Charmander_8_H, Charmander_9_H,
			Charmander_1_I, Charmander_2_I,
			Charmander_3_I, Charmander_4_I, Charmander_5_I, Charmander_6_I,
			Charmander_7_I, Charmander_8_I, Charmander_9_I;// Charmander
	private static HashMap<PokemonState,Animation> AnimationMap = new HashMap<PokemonState,Animation>();

	/*
	 * public static TextureRegion logo, zbLogo, bg, grass, bird, birdDown,
	 * birdUp, skullUp, skullDown, bar, playButtonUp, playButtonDown, ready,
	 * gameOver, highScore, scoreboard, star, noStar, retry; public static
	 * Animation birdAnimation; public static Sound dead, flap, coin, fall;s
	 * public static BitmapFont font, shadow, whiteFont; private static
	 * Preferences prefs;
	 */

	public static void load() {
		loadBulbasaur();
		loadCharmander();
		Background1 = new Texture(Gdx.files.internal("data/background1.png"));
		/*logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		logo = new TextureRegion(logoTexture, 0, 0, 512, 114);

		texture = new Texture(Gdx.files.internal("data/texture.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		playButtonUp = new TextureRegion(texture, 0, 83, 29, 16);
		playButtonDown = new TextureRegion(texture, 29, 83, 29, 16);
		playButtonUp.flip(false, true);
		playButtonDown.flip(false, true);

		ready = new TextureRegion(texture, 59, 83, 34, 7);
		ready.flip(false, true);

		retry = new TextureRegion(texture, 59, 110, 33, 7);
		retry.flip(false, true);
		
		gameOver = new TextureRegion(texture, 59, 92, 46, 7);
		gameOver.flip(false, true);

		scoreboard = new TextureRegion(texture, 111, 83, 97, 37);
		scoreboard.flip(false, true);

		star = new TextureRegion(texture, 152, 70, 10, 10);
		noStar = new TextureRegion(texture, 165, 70, 10, 10);

		star.flip(false, true);
		noStar.flip(false, true);

		highScore = new TextureRegion(texture, 59, 101, 48, 7);
		highScore.flip(false, true);

		zbLogo = new TextureRegion(texture, 0, 55, 135, 24);
		zbLogo.flip(false, true);

		bg = new TextureRegion(texture, 0, 0, 136, 43);
		bg.flip(false, true);

		grass = new TextureRegion(texture, 0, 43, 143, 11);
		grass.flip(false, true);

		birdDown = new TextureRegion(texture, 136, 0, 17, 12);
		birdDown.flip(false, true);

		bird = new TextureRegion(texture, 153, 0, 17, 12);
		bird.flip(false, true);

		birdUp = new TextureRegion(texture, 170, 0, 17, 12);
		birdUp.flip(false, true);

		TextureRegion[] birds = { birdDown, bird, birdUp };
		birdAnimation = new Animation(0.06f, birds);
		birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

		skullUp = new TextureRegion(texture, 192, 0, 24, 14);
		// Create by flipping existing skullUp
		skullDown = new TextureRegion(skullUp);
		skullDown.flip(false, true);

		bar = new TextureRegion(texture, 136, 16, 22, 3);
		bar.flip(false, true);

		dead = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
		flap = Gdx.audio.newSound(Gdx.files.internal("data/flap.wav"));
		coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));
		fall = Gdx.audio.newSound(Gdx.files.internal("data/fall.wav"));

		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
		font.setScale(.25f, -.25f);

		whiteFont = new BitmapFont(Gdx.files.internal("data/whitetext.fnt"));
		whiteFont.setScale(.1f, -.1f);

		shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
		shadow.setScale(.25f, -.25f);

		// Create (or retrieve existing) preferences file
		prefs = Gdx.app.getPreferences("ZombieBird");

		if (!prefs.contains("highScore")) {
			prefs.putInteger("highScore", 0);
		}*/
	}
	
	public static Animation getAnimationFor(int index,int direction,Action action)
	{
		return AnimationMap.get(new PokemonState(index,direction,action));
	}

	private static void loadBulbasaur() {
		// TODO Auto-generated method stub
		Bulbasaur = new Texture(Gdx.files.internal("data/BulbasaurSprite.png"));
		BulbasaurRegions = new TextureRegion[Bulbasaur.getWidth()/bulbasaurSize][Bulbasaur.getWidth()/bulbasaurSize];
		for(int i = 0;i<Bulbasaur.getWidth()/bulbasaurSize;i++)
		{
			for(int j = 0;j<Bulbasaur.getHeight()/bulbasaurSize;j++)
			{
				BulbasaurRegions[j][i] = new TextureRegion(Bulbasaur, j*bulbasaurSize, i*bulbasaurSize, bulbasaurSize, bulbasaurSize);
			}
		}

		Bulbasaur_1_R = new Animation(0.2f,BulbasaurRegions[2][1], BulbasaurRegions[3][1],BulbasaurRegions[4][1]);
		Bulbasaur_1_R.setPlayMode(Animation.PlayMode.LOOP);
		Bulbasaur_1_I = new Animation(0.2f,BulbasaurRegions[4][1]);
		
		Bulbasaur_2_R = new Animation(0.2f,BulbasaurRegions[0][0],  BulbasaurRegions[1][0],BulbasaurRegions[2][0]);
		Bulbasaur_2_R.setPlayMode(Animation.PlayMode.LOOP);
		Bulbasaur_2_I = new Animation(0.2f,BulbasaurRegions[2][0]);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[2][1]);
		tempRegions[1] = new TextureRegion(BulbasaurRegions[3][1]);
		tempRegions[2] = new TextureRegion(BulbasaurRegions[4][1]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		Bulbasaur_3_R = new Animation(0.2f,tempRegions[0], tempRegions[1],tempRegions[2]);
		Bulbasaur_3_R.setPlayMode(Animation.PlayMode.LOOP);
		Bulbasaur_3_I = new Animation(0.2f,tempRegions[2]);
		
		Bulbasaur_4_R = new Animation(0.2f,BulbasaurRegions[6][0], BulbasaurRegions[0][1], BulbasaurRegions[1][1]);
		Bulbasaur_4_R.setPlayMode(Animation.PlayMode.LOOP);
		Bulbasaur_4_I = new Animation(0.2f,BulbasaurRegions[1][1]);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[6][0]);
		tempRegions[1] = new TextureRegion(BulbasaurRegions[0][1]);
		tempRegions[2] = new TextureRegion(BulbasaurRegions[1][1]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		Bulbasaur_6_R = new Animation(0.2f,tempRegions[0], tempRegions[1],tempRegions[2]);
		Bulbasaur_6_R.setPlayMode(Animation.PlayMode.LOOP);
		Bulbasaur_6_I = new Animation(0.2f,tempRegions[2]);
		
		Bulbasaur_7_R = new Animation(0.2f,BulbasaurRegions[5][1], BulbasaurRegions[6][1],BulbasaurRegions[0][2]);
		Bulbasaur_7_R.setPlayMode(Animation.PlayMode.LOOP);
		Bulbasaur_7_I = new Animation(0.2f,BulbasaurRegions[0][2]);
		
		Bulbasaur_8_R = new Animation(0.2f,BulbasaurRegions[3][0], BulbasaurRegions[4][0],BulbasaurRegions[5][0]);
		Bulbasaur_8_R.setPlayMode(Animation.PlayMode.LOOP);
		Bulbasaur_8_I = new Animation(0.2f,BulbasaurRegions[5][0]);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[5][1]);
		tempRegions[1] = new TextureRegion(BulbasaurRegions[6][1]);
		tempRegions[2] = new TextureRegion(BulbasaurRegions[0][2]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		Bulbasaur_9_R = new Animation(0.2f,tempRegions[0], tempRegions[1] ,tempRegions[2]);
		Bulbasaur_9_R.setPlayMode(Animation.PlayMode.LOOP);
		Bulbasaur_9_I = new Animation(0.2f,tempRegions[2]);
		
		Bulbasaur_1_M1 = new  Animation(0.2f,BulbasaurRegions[5][3],BulbasaurRegions[6][3]);
		Bulbasaur_1_M1.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_2_M1 = new  Animation(0.2f,BulbasaurRegions[6][2],BulbasaurRegions[0][3]);
		Bulbasaur_2_M1.setPlayMode(Animation.PlayMode.LOOP);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[5][3]);
		tempRegions[1] = new TextureRegion(BulbasaurRegions[6][3]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		Bulbasaur_3_M1 = new  Animation(0.2f,tempRegions[0],tempRegions[1]);
		Bulbasaur_3_M1.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_4_M1 = new  Animation(0.2f,BulbasaurRegions[3][3],BulbasaurRegions[4][3]);
		Bulbasaur_4_M1.setPlayMode(Animation.PlayMode.LOOP);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[3][3]);
		tempRegions[1] = new TextureRegion(BulbasaurRegions[4][3]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		Bulbasaur_6_M1 = new  Animation(0.2f,tempRegions[0],tempRegions[1]);
		Bulbasaur_6_M1.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_7_M1 = new  Animation(0.2f,BulbasaurRegions[0][4],BulbasaurRegions[1][4]);
		Bulbasaur_7_M1.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_8_M1 = new  Animation(0.2f,BulbasaurRegions[1][3],BulbasaurRegions[2][3]);
		Bulbasaur_8_M1.setPlayMode(Animation.PlayMode.LOOP);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[0][4]);
		tempRegions[1] = new TextureRegion(BulbasaurRegions[1][4]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		Bulbasaur_9_M1 = new  Animation(0.2f,tempRegions[0],tempRegions[1]);
		Bulbasaur_9_M1.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_1_M2 = new  Animation(0.2f,BulbasaurRegions[1][5],BulbasaurRegions[2][5]);
		Bulbasaur_1_M2.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_2_M2 = new  Animation(0.2f,BulbasaurRegions[2][4],BulbasaurRegions[3][4]);
		Bulbasaur_2_M2.setPlayMode(Animation.PlayMode.LOOP);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[1][5]);
		tempRegions[1] = new TextureRegion(BulbasaurRegions[2][5]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		Bulbasaur_3_M2 = new  Animation(0.2f,tempRegions[0],tempRegions[1]);
		Bulbasaur_3_M2.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_4_M2 = new  Animation(0.2f,BulbasaurRegions[6][4],BulbasaurRegions[0][5]);
		Bulbasaur_4_M2.setPlayMode(Animation.PlayMode.LOOP);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[6][4]);
		tempRegions[1] = new TextureRegion(BulbasaurRegions[0][5]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		Bulbasaur_6_M2 = new  Animation(0.2f,tempRegions[0],tempRegions[1]);
		Bulbasaur_6_M2.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_7_M2 = new  Animation(0.2f,BulbasaurRegions[3][5],BulbasaurRegions[4][5]);
		Bulbasaur_7_M2.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_8_M2 = new  Animation(0.2f,BulbasaurRegions[4][4],BulbasaurRegions[5][4]);
		Bulbasaur_8_M2.setPlayMode(Animation.PlayMode.LOOP);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[3][5]);
		tempRegions[1] = new TextureRegion(BulbasaurRegions[4][5]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		Bulbasaur_9_M2 = new  Animation(0.2f,tempRegions[0],tempRegions[1]);
		Bulbasaur_9_M2.setPlayMode(Animation.PlayMode.LOOP);
		
				
		Bulbasaur_1_H = new  Animation(0.2f,BulbasaurRegions[4][2]);
		Bulbasaur_2_H = new  Animation(0.2f,BulbasaurRegions[1][2]);
		tempRegions[0] = new TextureRegion(BulbasaurRegions[4][2]);
		tempRegions[0].flip(true, false);
		Bulbasaur_3_H = new  Animation(0.2f,tempRegions[0]);

		Bulbasaur_4_H = new  Animation(0.2f,BulbasaurRegions[3][2]);
		tempRegions[0] = new TextureRegion(BulbasaurRegions[3][2]);
		tempRegions[0].flip(true, false);
		Bulbasaur_6_H = new  Animation(0.2f,tempRegions[0]);

		
		Bulbasaur_7_H = new  Animation(0.2f,BulbasaurRegions[5][2]);
		
		Bulbasaur_8_H = new  Animation(0.2f,BulbasaurRegions[2][2]);
		
		tempRegions[0] = new TextureRegion(BulbasaurRegions[5][2]);
		tempRegions[0].flip(true, false);
		Bulbasaur_9_H = new  Animation(0.2f,tempRegions[0]);
		
		AnimationMap.put(new PokemonState(1,1,Action.RUN), Bulbasaur_1_R);
		AnimationMap.put(new PokemonState(1,2,Action.RUN), Bulbasaur_2_R);
		AnimationMap.put(new PokemonState(1,3,Action.RUN), Bulbasaur_3_R);
		AnimationMap.put(new PokemonState(1,4,Action.RUN), Bulbasaur_4_R);
		AnimationMap.put(new PokemonState(1,6,Action.RUN), Bulbasaur_6_R);
		AnimationMap.put(new PokemonState(1,7,Action.RUN), Bulbasaur_7_R);
		AnimationMap.put(new PokemonState(1,8,Action.RUN), Bulbasaur_8_R);
		AnimationMap.put(new PokemonState(1,9,Action.RUN), Bulbasaur_9_R);
		AnimationMap.put(new PokemonState(1,1,Action.MOVE1), Bulbasaur_1_M1);
		AnimationMap.put(new PokemonState(1,2,Action.MOVE1), Bulbasaur_2_M1);
		AnimationMap.put(new PokemonState(1,3,Action.MOVE1), Bulbasaur_3_M1);
		AnimationMap.put(new PokemonState(1,4,Action.MOVE1), Bulbasaur_4_M1);
		AnimationMap.put(new PokemonState(1,6,Action.MOVE1), Bulbasaur_6_M1);
		AnimationMap.put(new PokemonState(1,7,Action.MOVE1), Bulbasaur_7_M1);
		AnimationMap.put(new PokemonState(1,8,Action.MOVE1), Bulbasaur_8_M1);
		AnimationMap.put(new PokemonState(1,9,Action.MOVE1), Bulbasaur_9_M1);
		AnimationMap.put(new PokemonState(1,1,Action.MOVE2), Bulbasaur_1_M2);
		AnimationMap.put(new PokemonState(1,2,Action.MOVE2), Bulbasaur_2_M2);
		AnimationMap.put(new PokemonState(1,3,Action.MOVE2), Bulbasaur_3_M2);
		AnimationMap.put(new PokemonState(1,4,Action.MOVE2), Bulbasaur_4_M2);
		AnimationMap.put(new PokemonState(1,6,Action.MOVE2), Bulbasaur_6_M2);
		AnimationMap.put(new PokemonState(1,7,Action.MOVE2), Bulbasaur_7_M2);
		AnimationMap.put(new PokemonState(1,8,Action.MOVE2), Bulbasaur_8_M2);
		AnimationMap.put(new PokemonState(1,9,Action.MOVE2), Bulbasaur_9_M2);
		AnimationMap.put(new PokemonState(1,1,Action.HURT), Bulbasaur_1_H);
		AnimationMap.put(new PokemonState(1,2,Action.HURT), Bulbasaur_2_H);
		AnimationMap.put(new PokemonState(1,3,Action.HURT), Bulbasaur_3_H);
		AnimationMap.put(new PokemonState(1,4,Action.HURT), Bulbasaur_4_H);
		AnimationMap.put(new PokemonState(1,6,Action.HURT), Bulbasaur_6_H);
		AnimationMap.put(new PokemonState(1,7,Action.HURT), Bulbasaur_7_H);
		AnimationMap.put(new PokemonState(1,8,Action.HURT), Bulbasaur_8_H);
		AnimationMap.put(new PokemonState(1,9,Action.HURT), Bulbasaur_9_H);
		AnimationMap.put(new PokemonState(1,1,Action.IDLE), Bulbasaur_1_I);
		AnimationMap.put(new PokemonState(1,2,Action.IDLE), Bulbasaur_2_I);
		AnimationMap.put(new PokemonState(1,3,Action.IDLE), Bulbasaur_3_I);
		AnimationMap.put(new PokemonState(1,4,Action.IDLE), Bulbasaur_4_I);
		AnimationMap.put(new PokemonState(1,6,Action.IDLE), Bulbasaur_6_I);
		AnimationMap.put(new PokemonState(1,7,Action.IDLE), Bulbasaur_7_I);
		AnimationMap.put(new PokemonState(1,8,Action.IDLE), Bulbasaur_8_I);
		AnimationMap.put(new PokemonState(1,9,Action.IDLE), Bulbasaur_9_I);
		
	}
	private static void loadCharmander(){
		
	
		
		
		Charmander = new Texture(Gdx.files.internal("data/CharmanderSprite.png"));
		CharmanderRegions = new TextureRegion[Charmander.getWidth()/charmanderSize][Charmander.getWidth()/charmanderSize];
		for(int i = 0;i<Charmander.getWidth()/charmanderSize;i++)
		{
			for(int j = 0;j<Charmander.getHeight()/charmanderSize;j++)
			{
				CharmanderRegions[j][i] = new TextureRegion(Charmander, j*charmanderSize, i*charmanderSize, charmanderSize, charmanderSize);
			}
		}
		
		Charmander_1_R = new Animation(0.2f,CharmanderRegions[0][1], CharmanderRegions[1][1],CharmanderRegions[2][1]);
		Charmander_1_R.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		Charmander_1_I = new Animation(0.2f,CharmanderRegions[1][1]);
		

		Charmander_2_R = new Animation(0.2f,CharmanderRegions[0][0], CharmanderRegions[1][0],CharmanderRegions[2][0]);
		Charmander_2_R.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		Charmander_2_I = new Animation(0.2f,CharmanderRegions[1][0]);
		
		tempRegions[0] = new TextureRegion(CharmanderRegions[0][1]);
		tempRegions[1] = new TextureRegion(CharmanderRegions[1][1]);
		tempRegions[2] = new TextureRegion(CharmanderRegions[2][1]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		Charmander_3_R = new Animation(0.2f,tempRegions[0], tempRegions[1],tempRegions[2]);
		Charmander_3_R.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		Charmander_3_I = new Animation(0.2f,tempRegions[1]);

		Charmander_4_R = new Animation(0.2f,CharmanderRegions[6][0], CharmanderRegions[7][0],CharmanderRegions[8][0]);
		Charmander_4_R.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		Charmander_4_I = new Animation(0.2f, CharmanderRegions[7][0]);

		tempRegions[0] = new TextureRegion(CharmanderRegions[6][0]);
		tempRegions[1] = new TextureRegion(CharmanderRegions[7][0]);
		tempRegions[2] = new TextureRegion(CharmanderRegions[8][0]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		Charmander_6_R = new Animation(0.2f,tempRegions[0], tempRegions[1],tempRegions[2]);
		Charmander_6_R.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		Charmander_6_I = new Animation(0.2f,tempRegions[1]);
		

		Charmander_7_R = new Animation(0.2f,CharmanderRegions[3][1], CharmanderRegions[4][1],CharmanderRegions[5][1]);
		Charmander_7_R.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		Charmander_7_I = new Animation(0.2f, CharmanderRegions[4][1]);
		
		Charmander_8_R = new Animation(0.2f,CharmanderRegions[3][0], CharmanderRegions[4][0],CharmanderRegions[5][0]);
		Charmander_8_R.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		Charmander_8_I = new Animation(0.2f, CharmanderRegions[4][0]);
		
		tempRegions[0] = new TextureRegion(CharmanderRegions[3][1]);
		tempRegions[1] = new TextureRegion(CharmanderRegions[4][1]);
		tempRegions[2] = new TextureRegion(CharmanderRegions[5][1]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		Charmander_9_R = new Animation(0.2f,tempRegions[0], tempRegions[1],tempRegions[2]);
		Charmander_9_R.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		Charmander_9_I = new Animation(0.2f,tempRegions[1]);
		//todo hurt
		

		Charmander_1_M1 = new  Animation(0.2f,CharmanderRegions[2][3],CharmanderRegions[3][3],CharmanderRegions[4][3]);

		Charmander_2_M1 = new  Animation(0.2f,CharmanderRegions[2][2],CharmanderRegions[3][2],CharmanderRegions[4][2]);

		tempRegions[0] = new TextureRegion(CharmanderRegions[2][3]);
		tempRegions[1] = new TextureRegion(CharmanderRegions[3][3]);
		tempRegions[2] = new TextureRegion(CharmanderRegions[4][3]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		Charmander_3_M1 = new  Animation(0.2f,tempRegions[0], tempRegions[1],tempRegions[2]);

		Charmander_4_M1 = new  Animation(0.2f,CharmanderRegions[8][2],CharmanderRegions[0][3],CharmanderRegions[1][3]);

		tempRegions[0] = new TextureRegion(CharmanderRegions[8][2]);
		tempRegions[1] = new TextureRegion(CharmanderRegions[0][3]);
		tempRegions[2] = new TextureRegion(CharmanderRegions[1][3]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		Charmander_6_M1 = new  Animation(0.2f,tempRegions[0], tempRegions[1],tempRegions[2]);

		Charmander_7_M1 = new  Animation(0.2f,CharmanderRegions[5][3],CharmanderRegions[6][3],CharmanderRegions[7][3]);

		Charmander_8_M1 = new  Animation(0.2f,CharmanderRegions[5][2],CharmanderRegions[6][2],CharmanderRegions[7][2]);

		tempRegions[0] = new TextureRegion(CharmanderRegions[5][3]);
		tempRegions[1] = new TextureRegion(CharmanderRegions[6][3]);
		tempRegions[2] = new TextureRegion(CharmanderRegions[7][3]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		Charmander_9_M1 = new  Animation(0.2f,tempRegions[0], tempRegions[1],tempRegions[2]);
		
		Charmander_1_M1.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_2_M1.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_3_M1.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_4_M1.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_6_M1.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_7_M1.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_8_M1.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_9_M1.setPlayMode(Animation.PlayMode.LOOP);

		
		Charmander_1_M2 = new  Animation(0.2f,CharmanderRegions[2][5],CharmanderRegions[3][5],CharmanderRegions[4][5],CharmanderRegions[5][5]);

		Charmander_2_M2 = new  Animation(0.2f,CharmanderRegions[8][3],CharmanderRegions[0][4],CharmanderRegions[1][4],CharmanderRegions[2][4]);

		tempRegions[0] = new TextureRegion(CharmanderRegions[2][5]);
		tempRegions[1] = new TextureRegion(CharmanderRegions[3][5]);
		tempRegions[2] = new TextureRegion(CharmanderRegions[4][5]);
		tempRegions[3] = new TextureRegion(CharmanderRegions[5][5]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		tempRegions[3].flip(true, false);
		Charmander_3_M2 = new  Animation(0.2f,tempRegions[0] ,tempRegions[1] ,tempRegions[2] ,tempRegions[3] );

		Charmander_4_M2 =new  Animation(0.2f,CharmanderRegions[7][4],CharmanderRegions[8][4],CharmanderRegions[0][5],CharmanderRegions[1][5]);

		tempRegions[0] = new TextureRegion(CharmanderRegions[7][4]);
		tempRegions[1] = new TextureRegion(CharmanderRegions[8][4]);
		tempRegions[2] = new TextureRegion(CharmanderRegions[0][5]);
		tempRegions[3] = new TextureRegion(CharmanderRegions[1][5]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		tempRegions[3].flip(true, false);
		Charmander_6_M2 =  new  Animation(0.2f,tempRegions[0] ,tempRegions[1] ,tempRegions[2] ,tempRegions[3] );

		Charmander_7_M2 = new  Animation(0.2f,CharmanderRegions[6][5],CharmanderRegions[7][5],CharmanderRegions[8][5],CharmanderRegions[0][6]);

		Charmander_8_M2 = new  Animation(0.2f,CharmanderRegions[3][4],CharmanderRegions[4][4],CharmanderRegions[5][4],CharmanderRegions[6][4]);

		tempRegions[0] = new TextureRegion(CharmanderRegions[6][5]);
		tempRegions[1] = new TextureRegion(CharmanderRegions[7][5]);
		tempRegions[2] = new TextureRegion(CharmanderRegions[8][5]);
		tempRegions[3] = new TextureRegion(CharmanderRegions[0][6]);
		tempRegions[0].flip(true, false);
		tempRegions[1].flip(true, false);
		tempRegions[2].flip(true, false);
		tempRegions[3].flip(true, false);
		Charmander_9_M2 = new  Animation(0.2f,tempRegions[0] ,tempRegions[1] ,tempRegions[2] ,tempRegions[3] );
		
		Charmander_1_M2.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_2_M2.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_3_M2.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_4_M2.setPlayMode(Animation.PlayMode.LOOP);

		Charmander_6_M2.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_7_M2.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_8_M2.setPlayMode(Animation.PlayMode.LOOP);
		Charmander_9_M2.setPlayMode(Animation.PlayMode.LOOP);
		
		/*
		Charmander_1_M3 = new  Animation(0.2f,Charmander_1_M3_1);

		Charmander_2_M3 = new  Animation(0.2f,Charmander_2_M3_1);

		Charmander_3_M3 = new  Animation(0.2f,Charmander_3_M3_1);

		Charmander_4_M3 = new  Animation(0.2f,Charmander_4_M3_1);

		Charmander_6_M3 = new  Animation(0.2f,Charmander_6_M3_1);

		Charmander_7_M3 = new  Animation(0.2f,Charmander_7_M3_1);

		Charmander_8_M3 = new  Animation(0.2f,Charmander_8_M3_1);

		Charmander_9_M3 = new  Animation(0.2f,Charmander_9_M3_1);
		
		Charmander_1_H_1 = new TextureRegion(Charmander, 207, 399, 106, 106);
		Charmander_1_H_1.flip(true, false);
		Charmander_1_H = new  Animation(0.2f,Charmander_1_H_1);
		Charmander_2_H_1 = new TextureRegion(Charmander, 278, 399, 106, 106);
		Charmander_2_H = new  Animation(0.2f,Charmander_2_H_1);
		Charmander_3_H_1 = new TextureRegion(Charmander, 207, 399, 106, 106);
		Charmander_3_H = new  Animation(0.2f,Charmander_3_H_1);
		Charmander_4_H_1 = new TextureRegion(Charmander, 138, 399, 106, 106);
		Charmander_4_H_1.flip(true, false);
		Charmander_4_H = new  Animation(0.2f,Charmander_4_H_1);
		Charmander_6_H_1 = new TextureRegion(Charmander, 138, 399, 106, 106);
		Charmander_6_H = new  Animation(0.2f,Charmander_6_H_1);
		Charmander_7_H_1 = new TextureRegion(Charmander, 69, 399, 106, 106);
		Charmander_7_H_1.flip(true, false);
		Charmander_7_H = new  Animation(0.2f,Charmander_7_H_1);
		Charmander_8_H_1 = new TextureRegion(Charmander, 0, 399, 106, 106);
		Charmander_8_H = new  Animation(0.2f,Charmander_8_A_1);
		Charmander_9_H_1 = new TextureRegion(Charmander, 69, 399, 106, 106);
		Charmander_9_H = new  Animation(0.2f,Charmander_9_H_1);
		*/
		AnimationMap.put(new PokemonState(4,1,Action.RUN), Charmander_1_R);
		AnimationMap.put(new PokemonState(4,2,Action.RUN), Charmander_2_R);
		AnimationMap.put(new PokemonState(4,3,Action.RUN), Charmander_3_R);
		AnimationMap.put(new PokemonState(4,4,Action.RUN), Charmander_4_R);
		AnimationMap.put(new PokemonState(4,5,Action.RUN), Charmander_5_R);
		AnimationMap.put(new PokemonState(4,6,Action.RUN), Charmander_6_R);
		AnimationMap.put(new PokemonState(4,7,Action.RUN), Charmander_7_R);
		AnimationMap.put(new PokemonState(4,8,Action.RUN), Charmander_8_R);
		AnimationMap.put(new PokemonState(4,9,Action.RUN), Charmander_9_R);
		AnimationMap.put(new PokemonState(4,1,Action.HURT), Charmander_1_H);
		AnimationMap.put(new PokemonState(4,2,Action.HURT), Charmander_2_H);
		AnimationMap.put(new PokemonState(4,3,Action.HURT), Charmander_3_H);
		AnimationMap.put(new PokemonState(4,4,Action.HURT), Charmander_4_H);
		AnimationMap.put(new PokemonState(4,5,Action.HURT), Charmander_5_H);
		AnimationMap.put(new PokemonState(4,6,Action.HURT), Charmander_6_H);
		AnimationMap.put(new PokemonState(4,7,Action.HURT), Charmander_7_H);
		AnimationMap.put(new PokemonState(4,8,Action.HURT), Charmander_8_H);
		AnimationMap.put(new PokemonState(4,9,Action.HURT), Charmander_9_H);
		AnimationMap.put(new PokemonState(4,1,Action.MOVE1), Charmander_1_M1);
		AnimationMap.put(new PokemonState(4,2,Action.MOVE1), Charmander_2_M1);
		AnimationMap.put(new PokemonState(4,3,Action.MOVE1), Charmander_3_M1);
		AnimationMap.put(new PokemonState(4,4,Action.MOVE1), Charmander_4_M1);
		AnimationMap.put(new PokemonState(4,5,Action.MOVE1), Charmander_5_M1);
		AnimationMap.put(new PokemonState(4,6,Action.MOVE1), Charmander_6_M1);
		AnimationMap.put(new PokemonState(4,7,Action.MOVE1), Charmander_7_M1);
		AnimationMap.put(new PokemonState(4,8,Action.MOVE1), Charmander_8_M1);
		AnimationMap.put(new PokemonState(4,9,Action.MOVE1), Charmander_9_M1);
		AnimationMap.put(new PokemonState(4,1,Action.MOVE2), Charmander_1_M2);
		AnimationMap.put(new PokemonState(4,2,Action.MOVE2), Charmander_2_M2);
		AnimationMap.put(new PokemonState(4,3,Action.MOVE2), Charmander_3_M2);
		AnimationMap.put(new PokemonState(4,4,Action.MOVE2), Charmander_4_M2);
		AnimationMap.put(new PokemonState(4,5,Action.MOVE2), Charmander_5_M2);
		AnimationMap.put(new PokemonState(4,6,Action.MOVE2), Charmander_6_M2);
		AnimationMap.put(new PokemonState(4,7,Action.MOVE2), Charmander_7_M2);
		AnimationMap.put(new PokemonState(4,8,Action.MOVE2), Charmander_8_M2);
		AnimationMap.put(new PokemonState(4,9,Action.MOVE2), Charmander_9_M2);
		AnimationMap.put(new PokemonState(4,1,Action.MOVE3), Charmander_1_M1);
		AnimationMap.put(new PokemonState(4,2,Action.MOVE3), Charmander_2_M1);
		AnimationMap.put(new PokemonState(4,3,Action.MOVE3), Charmander_3_M1);
		AnimationMap.put(new PokemonState(4,4,Action.MOVE3), Charmander_4_M1);
		AnimationMap.put(new PokemonState(4,5,Action.MOVE3), Charmander_5_M1);
		AnimationMap.put(new PokemonState(4,6,Action.MOVE3), Charmander_6_M1);
		AnimationMap.put(new PokemonState(4,7,Action.MOVE3), Charmander_7_M1);
		AnimationMap.put(new PokemonState(4,8,Action.MOVE3), Charmander_8_M1);
		AnimationMap.put(new PokemonState(4,9,Action.MOVE3), Charmander_9_M1);
		AnimationMap.put(new PokemonState(4,1,Action.IDLE), Charmander_1_I);
		AnimationMap.put(new PokemonState(4,2,Action.IDLE), Charmander_2_I);
		AnimationMap.put(new PokemonState(4,3,Action.IDLE), Charmander_3_I);
		AnimationMap.put(new PokemonState(4,4,Action.IDLE), Charmander_4_I);
		AnimationMap.put(new PokemonState(4,5,Action.IDLE), Charmander_5_I);
		AnimationMap.put(new PokemonState(4,6,Action.IDLE), Charmander_6_I);
		AnimationMap.put(new PokemonState(4,7,Action.IDLE), Charmander_7_I);
		AnimationMap.put(new PokemonState(4,8,Action.IDLE), Charmander_8_I);
		AnimationMap.put(new PokemonState(4,9,Action.IDLE), Charmander_9_I);
		
	}

	/*
	 * public static void setHighScore(int val) { prefs.putInteger("highScore",
	 * val); prefs.flush(); }
	 * 
	 * public static int getHighScore() { return prefs.getInteger("highScore");
	 * }
	 */
	public static void dispose() {
		// We must dispose of the texture when we are finished.
		Bulbasaur.dispose();
		Charmander.dispose();

		// Dispose sounds
	/*	dead.dispose();
		flap.dispose();
		coin.dispose();

		font.dispose();
		shadow.dispose();*/
	}

}
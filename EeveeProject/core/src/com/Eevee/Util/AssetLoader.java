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
	public static TextureRegion Bulbasaur_1_R_1, Bulbasaur_1_R_2, Bulbasaur_1_R_3, 
								Bulbasaur_2_R_1, Bulbasaur_2_R_2, Bulbasaur_2_R_3,
								Bulbasaur_3_R_1, Bulbasaur_3_R_2, Bulbasaur_3_R_3,
								Bulbasaur_4_R_1, Bulbasaur_4_R_2, Bulbasaur_4_R_3,
								Bulbasaur_6_R_1, Bulbasaur_6_R_2, Bulbasaur_6_R_3,
								Bulbasaur_7_R_1, Bulbasaur_7_R_2, Bulbasaur_7_R_3,
								Bulbasaur_8_R_1, Bulbasaur_8_R_2, Bulbasaur_8_R_3,
								Bulbasaur_9_R_1, Bulbasaur_9_R_2, Bulbasaur_9_R_3,
								Bulbasaur_1_A_1, Bulbasaur_2_A_1, Bulbasaur_3_A_1, Bulbasaur_4_A_1, Bulbasaur_6_A_1, Bulbasaur_7_A_1, Bulbasaur_8_A_1, Bulbasaur_9_A_1,
								Bulbasaur_1_A_2, Bulbasaur_2_A_2, Bulbasaur_3_A_2, Bulbasaur_4_A_2, Bulbasaur_6_A_2, Bulbasaur_7_A_2, Bulbasaur_8_A_2, Bulbasaur_9_A_2,
								Bulbasaur_1_H_1, Bulbasaur_2_H_1, Bulbasaur_3_H_1, Bulbasaur_4_H_1, Bulbasaur_6_H_1, Bulbasaur_7_H_1, Bulbasaur_8_H_1, Bulbasaur_9_H_1, //Bulbasaur
								Charmander_1_R_1, Charmander_1_R_2, Charmander_1_R_3,Charmander_1_R_4, 
								Charmander_2_R_1, Charmander_2_R_2, Charmander_2_R_3,Charmander_2_R_4,
								Charmander_3_R_1, Charmander_3_R_2, Charmander_3_R_3,Charmander_3_R_4,
								Charmander_4_R_1, Charmander_4_R_2, Charmander_4_R_3,Charmander_4_R_4,
								Charmander_6_R_1, Charmander_6_R_2, Charmander_6_R_3,Charmander_6_R_4,
								Charmander_7_R_1, Charmander_7_R_2, Charmander_7_R_3,Charmander_7_R_4,
								Charmander_8_R_1, Charmander_8_R_2, Charmander_8_R_3,Charmander_8_R_4,
								Charmander_9_R_1, Charmander_9_R_2, Charmander_9_R_3,Charmander_9_R_4,
								Charmander_1_A_1, Charmander_2_A_1, Charmander_3_A_1, Charmander_4_A_1, Charmander_6_A_1, Charmander_7_A_1, Charmander_8_A_1, Charmander_9_A_1,
								Charmander_1_H_1, Charmander_2_H_1, Charmander_3_H_1, Charmander_4_H_1, Charmander_6_H_1, Charmander_7_H_1, Charmander_8_H_1, Charmander_9_H_1; //Charmander
	public static Animation Bulbasaur_1_R, Bulbasaur_2_R, Bulbasaur_3_R,
			Bulbasaur_4_R, Bulbasaur_5_R, Bulbasaur_6_R, Bulbasaur_7_R,
			Bulbasaur_8_R, Bulbasaur_9_R, Bulbasaur_1_A, Bulbasaur_2_A,
			Bulbasaur_3_A, Bulbasaur_4_A, Bulbasaur_5_A, Bulbasaur_6_A,
			Bulbasaur_7_A, Bulbasaur_8_A, Bulbasaur_9_A, Bulbasaur_1_H,
			Bulbasaur_2_H, Bulbasaur_3_H, Bulbasaur_4_H, Bulbasaur_5_H,
			Bulbasaur_6_H, Bulbasaur_7_H, Bulbasaur_8_H, Bulbasaur_9_H, // Bulbasaur
			Charmander_1_R, Charmander_2_R, Charmander_3_R,
			Charmander_4_R, Charmander_5_R, Charmander_6_R, Charmander_7_R,
			Charmander_8_R, Charmander_9_R, Charmander_1_A, Charmander_2_A,
			Charmander_3_A, Charmander_4_A, Charmander_5_A, Charmander_6_A,
			Charmander_7_A, Charmander_8_A, Charmander_9_A, Charmander_1_H,
			Charmander_2_H, Charmander_3_H, Charmander_4_H, Charmander_5_H,
			Charmander_6_H, Charmander_7_H, Charmander_8_H, Charmander_9_H; // Charmander
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
		Bulbasaur_1_R_1 = new TextureRegion(Bulbasaur, 210, 105, 105, 105);
		Bulbasaur_1_R_2 = new TextureRegion(Bulbasaur, 315, 105, 105, 105);
		Bulbasaur_1_R_3 = new TextureRegion(Bulbasaur, 420, 105, 105, 105);

		Bulbasaur_1_R = new Animation(0.2f,Bulbasaur_1_R_1, Bulbasaur_1_R_2,Bulbasaur_1_R_3);
		Bulbasaur_1_R.setPlayMode(Animation.PlayMode.LOOP);
		
		
		Bulbasaur_2_R_1 = new TextureRegion(Bulbasaur, 0, 0, 105, 105);
		Bulbasaur_2_R_2 = new TextureRegion(Bulbasaur, 105, 0, 105, 105);
		Bulbasaur_2_R_3 = new TextureRegion(Bulbasaur, 210, 0, 105, 105);
		Bulbasaur_2_R = new Animation(0.2f,Bulbasaur_2_R_1, Bulbasaur_2_R_2,Bulbasaur_2_R_3);
		Bulbasaur_2_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_3_R_1 = new TextureRegion(Bulbasaur, 210, 105, 105, 105);
		Bulbasaur_3_R_2 = new TextureRegion(Bulbasaur, 315, 105, 105, 105);
		Bulbasaur_3_R_3 = new TextureRegion(Bulbasaur, 420, 105, 105, 105);
		Bulbasaur_3_R_1.flip(true, false);
		Bulbasaur_3_R_2.flip(true, false);
		Bulbasaur_3_R_3.flip(true, false);
		Bulbasaur_3_R = new Animation(0.2f,Bulbasaur_3_R_1, Bulbasaur_3_R_2,Bulbasaur_3_R_3);
		Bulbasaur_3_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_4_R_1 = new TextureRegion(Bulbasaur, 630, 0, 105, 105);
		Bulbasaur_4_R_2 = new TextureRegion(Bulbasaur, 0, 105, 105, 105);
		Bulbasaur_4_R_3 = new TextureRegion(Bulbasaur, 105, 105, 105, 105);
		Bulbasaur_4_R = new Animation(0.2f,Bulbasaur_4_R_1, Bulbasaur_4_R_2,Bulbasaur_4_R_3);
		Bulbasaur_4_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_6_R_1 =  new TextureRegion(Bulbasaur, 630, 0, 105, 105);
		Bulbasaur_6_R_2 = new TextureRegion(Bulbasaur, 0, 105, 105, 105);
		Bulbasaur_6_R_3 =new TextureRegion(Bulbasaur, 105, 105, 105, 105);
		Bulbasaur_6_R_1.flip(true, false);
		Bulbasaur_6_R_2.flip(true, false);
		Bulbasaur_6_R_3.flip(true, false);
		Bulbasaur_6_R = new Animation(0.2f,Bulbasaur_6_R_1, Bulbasaur_6_R_2,Bulbasaur_6_R_3);
		Bulbasaur_6_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_7_R_1 = new TextureRegion(Bulbasaur, 525, 105, 105, 105);
		Bulbasaur_7_R_2 = new TextureRegion(Bulbasaur, 630, 105, 105, 105);
		Bulbasaur_7_R_3 = new TextureRegion(Bulbasaur, 0, 210, 105, 105);
		Bulbasaur_7_R = new Animation(0.2f,Bulbasaur_7_R_1, Bulbasaur_7_R_2,Bulbasaur_7_R_3);
		Bulbasaur_7_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_8_R_1 = new TextureRegion(Bulbasaur, 315, 0, 105, 105);
		Bulbasaur_8_R_2 = new TextureRegion(Bulbasaur, 420, 0, 105, 105);
		Bulbasaur_8_R_3 = new TextureRegion(Bulbasaur, 525, 0, 105, 105);
		Bulbasaur_8_R = new Animation(0.2f,Bulbasaur_8_R_1, Bulbasaur_8_R_2,Bulbasaur_8_R_3);
		Bulbasaur_8_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_9_R_1 =new TextureRegion(Bulbasaur, 525, 105, 105, 105);
		Bulbasaur_9_R_2 = new TextureRegion(Bulbasaur, 630, 105, 105, 105);
		Bulbasaur_9_R_3 =  new TextureRegion(Bulbasaur, 0, 210, 105, 105);
		Bulbasaur_9_R_1.flip(true, false);
		Bulbasaur_9_R_2.flip(true, false);
		Bulbasaur_9_R_3.flip(true, false);
		Bulbasaur_9_R = new Animation(0.2f,Bulbasaur_9_R_1, Bulbasaur_9_R_2,Bulbasaur_9_R_3);
		Bulbasaur_9_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_1_A_1 = new TextureRegion(Bulbasaur, 525, 315, 105, 105);
		Bulbasaur_1_A_2 = new TextureRegion(Bulbasaur, 630, 315, 105, 105);
		Bulbasaur_1_A = new  Animation(0.2f,Bulbasaur_1_A_1,Bulbasaur_1_A_2);
		Bulbasaur_1_A.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_2_A_1 = new TextureRegion(Bulbasaur, 630, 210, 105, 105);
		Bulbasaur_2_A_2 = new TextureRegion(Bulbasaur, 0, 315, 105, 105);
		Bulbasaur_2_A = new  Animation(0.2f,Bulbasaur_2_A_1,Bulbasaur_2_A_2);
		Bulbasaur_2_A.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_3_A_1 =new TextureRegion(Bulbasaur, 525, 315, 105, 105);
		Bulbasaur_3_A_2 = new TextureRegion(Bulbasaur, 630, 315, 105, 105);
		Bulbasaur_3_A_1.flip(true, false);
		Bulbasaur_3_A_2.flip(true, false);
		Bulbasaur_3_A = new  Animation(0.2f,Bulbasaur_3_A_1,Bulbasaur_3_A_2);
		Bulbasaur_3_A.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_4_A_1 = new TextureRegion(Bulbasaur, 315, 315, 105, 105);
		Bulbasaur_4_A_2 = new TextureRegion(Bulbasaur, 420, 315, 105, 105);
		Bulbasaur_4_A = new  Animation(0.2f,Bulbasaur_4_A_1,Bulbasaur_4_A_2);
		Bulbasaur_4_A.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_6_A_1 = new TextureRegion(Bulbasaur, 315, 315, 105, 105);
		Bulbasaur_6_A_2 = new TextureRegion(Bulbasaur, 420, 315, 105, 105);
		Bulbasaur_6_A_1.flip(true, false);
		Bulbasaur_6_A_2.flip(true, false);
		Bulbasaur_6_A = new  Animation(0.2f,Bulbasaur_6_A_1,Bulbasaur_6_A_2);
		Bulbasaur_6_A.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_7_A_1 = new TextureRegion(Bulbasaur, 0, 420, 105, 105);
		Bulbasaur_7_A_2 = new TextureRegion(Bulbasaur, 105, 420, 105, 105);
		Bulbasaur_7_A = new  Animation(0.2f,Bulbasaur_7_A_1,Bulbasaur_7_A_2);
		Bulbasaur_7_A.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_8_A_1 = new TextureRegion(Bulbasaur, 105, 315, 105, 105);
		Bulbasaur_8_A_2 = new TextureRegion(Bulbasaur, 210, 315, 105, 105);
		Bulbasaur_8_A = new  Animation(0.2f,Bulbasaur_8_A_1,Bulbasaur_8_A_2);
		Bulbasaur_8_A.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_9_A_1 =new TextureRegion(Bulbasaur, 0, 420, 105, 105);
		Bulbasaur_9_A_2 = new TextureRegion(Bulbasaur, 105, 420, 105, 105);
		Bulbasaur_9_A_1.flip(true, false);
		Bulbasaur_9_A_2.flip(true, false);
		Bulbasaur_9_A = new  Animation(0.2f,Bulbasaur_9_A_1,Bulbasaur_9_A_2);
		Bulbasaur_9_A.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_1_H_1 = new TextureRegion(Bulbasaur, 420, 210, 105, 105);
		
		Bulbasaur_1_H = new  Animation(0.2f,Bulbasaur_1_H_1);
		Bulbasaur_2_H_1 = new TextureRegion(Bulbasaur, 105, 210, 105, 105);
		Bulbasaur_2_H = new  Animation(0.2f,Bulbasaur_2_H_1);
		Bulbasaur_3_H_1 = new TextureRegion(Bulbasaur, 420, 210, 105, 105);
		Bulbasaur_3_H_1.flip(true, false);
		Bulbasaur_3_H = new  Animation(0.2f,Bulbasaur_3_H_1);
		Bulbasaur_4_H_1 = new TextureRegion(Bulbasaur, 330, 210, 105, 105);

		Bulbasaur_4_H = new  Animation(0.2f,Bulbasaur_4_H_1);
		Bulbasaur_6_H_1 = new TextureRegion(Bulbasaur, 330, 210, 105, 105);
		Bulbasaur_6_H_1.flip(true, false);
		Bulbasaur_6_H = new  Animation(0.2f,Bulbasaur_6_H_1);
		Bulbasaur_7_H_1 = new TextureRegion(Bulbasaur, 525, 210, 105, 105);
		
		Bulbasaur_7_H = new  Animation(0.2f,Bulbasaur_7_H_1);
		Bulbasaur_8_H_1 = new TextureRegion(Bulbasaur, 210, 210, 105, 105);
		Bulbasaur_8_H = new  Animation(0.2f,Bulbasaur_8_A_1);
		Bulbasaur_9_H_1 = new TextureRegion(Bulbasaur, 525, 210, 105, 105);
		Bulbasaur_9_H_1.flip(true, false);
		Bulbasaur_9_H = new  Animation(0.2f,Bulbasaur_9_H_1);
		
		AnimationMap.put(new PokemonState(1,1,Action.RUN), Bulbasaur_1_R);
		AnimationMap.put(new PokemonState(1,2,Action.RUN), Bulbasaur_2_R);
		AnimationMap.put(new PokemonState(1,3,Action.RUN), Bulbasaur_3_R);
		AnimationMap.put(new PokemonState(1,4,Action.RUN), Bulbasaur_4_R);
		AnimationMap.put(new PokemonState(1,5,Action.RUN), Bulbasaur_5_R);
		AnimationMap.put(new PokemonState(1,6,Action.RUN), Bulbasaur_6_R);
		AnimationMap.put(new PokemonState(1,7,Action.RUN), Bulbasaur_7_R);
		AnimationMap.put(new PokemonState(1,8,Action.RUN), Bulbasaur_8_R);
		AnimationMap.put(new PokemonState(1,9,Action.RUN), Bulbasaur_9_R);
		AnimationMap.put(new PokemonState(1,1,Action.MOVE1), Bulbasaur_1_A);
		AnimationMap.put(new PokemonState(1,2,Action.MOVE1), Bulbasaur_2_A);
		AnimationMap.put(new PokemonState(1,3,Action.MOVE1), Bulbasaur_3_A);
		AnimationMap.put(new PokemonState(1,4,Action.MOVE1), Bulbasaur_4_A);
		AnimationMap.put(new PokemonState(1,5,Action.MOVE1), Bulbasaur_5_A);
		AnimationMap.put(new PokemonState(1,6,Action.MOVE1), Bulbasaur_6_A);
		AnimationMap.put(new PokemonState(1,7,Action.MOVE1), Bulbasaur_7_A);
		AnimationMap.put(new PokemonState(1,8,Action.MOVE1), Bulbasaur_8_A);
		AnimationMap.put(new PokemonState(1,9,Action.MOVE1), Bulbasaur_9_A);
		AnimationMap.put(new PokemonState(1,1,Action.HURT), Bulbasaur_1_H);
		AnimationMap.put(new PokemonState(1,2,Action.HURT), Bulbasaur_2_H);
		AnimationMap.put(new PokemonState(1,3,Action.HURT), Bulbasaur_3_H);
		AnimationMap.put(new PokemonState(1,4,Action.HURT), Bulbasaur_4_H);
		AnimationMap.put(new PokemonState(1,5,Action.HURT), Bulbasaur_5_H);
		AnimationMap.put(new PokemonState(1,6,Action.HURT), Bulbasaur_6_H);
		AnimationMap.put(new PokemonState(1,7,Action.HURT), Bulbasaur_7_H);
		AnimationMap.put(new PokemonState(1,8,Action.HURT), Bulbasaur_8_H);
		AnimationMap.put(new PokemonState(1,9,Action.HURT), Bulbasaur_9_H);

		
		
		Charmander = new Texture(Gdx.files.internal("data/CharmanderSprite.png"));
		Charmander_1_R_1 = new TextureRegion(Charmander, 0, 69, 60, 79);
		Charmander_1_R_2 = new TextureRegion(Charmander, 60, 69, 60, 79);
		Charmander_1_R_3 = new TextureRegion(Charmander, 120, 69, 60, 79);
		Charmander_1_R_4 = new TextureRegion(Charmander, 180, 69, 60, 79);
		Charmander_1_R_1.flip(true, false);
		Charmander_1_R_2.flip(true, false);
		Charmander_1_R_3.flip(true, false);
		Charmander_1_R_4.flip(true, false);
		Charmander_1_R = new Animation(0.2f,Charmander_1_R_1, Charmander_1_R_2,Charmander_1_R_3,Charmander_1_R_4);
		Charmander_1_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Charmander_2_R_1 = new TextureRegion(Charmander, 0, 0, 57, 69);
		Charmander_2_R_2 = new TextureRegion(Charmander, 57, 0, 57, 69);
		Charmander_2_R_3 = new TextureRegion(Charmander, 114, 0, 57, 69);
		Charmander_2_R_4 = new TextureRegion(Charmander, 171, 0, 57, 69);
		Charmander_2_R = new Animation(0.2f,Charmander_2_R_1, Charmander_2_R_2,Charmander_2_R_3,Charmander_2_R_4);
		Charmander_2_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Charmander_3_R_1 = new TextureRegion(Charmander, 0, 69, 60, 79);
		Charmander_3_R_2 = new TextureRegion(Charmander, 60, 69, 60, 79);
		Charmander_3_R_3 = new TextureRegion(Charmander, 120, 69, 60, 79);
		Charmander_3_R_4 = new TextureRegion(Charmander, 180, 69, 60, 79);
		Charmander_3_R = new Animation(0.2f,Charmander_3_R_1, Charmander_3_R_2,Charmander_3_R_3,Charmander_3_R_4);
		Charmander_3_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Charmander_4_R_1 = new TextureRegion(Charmander, 0, 148, 63, 80);
		Charmander_4_R_2 = new TextureRegion(Charmander, 63, 148, 63, 80);
		Charmander_4_R_3 = new TextureRegion(Charmander, 126, 148, 63, 80);
		Charmander_4_R_4 = new TextureRegion(Charmander, 189, 148, 63,80);
		Charmander_4_R_1.flip(true, false);
		Charmander_4_R_2.flip(true, false);
		Charmander_4_R_3.flip(true, false);
		Charmander_4_R_4.flip(true, false);
		Charmander_4_R = new Animation(0.2f,Charmander_4_R_1, Charmander_4_R_2,Charmander_4_R_3,Charmander_4_R_4);
		Charmander_4_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Charmander_6_R_1 = new TextureRegion(Charmander, 0, 148, 63, 80);
		Charmander_6_R_2 = new TextureRegion(Charmander, 63, 148, 63, 80);
		Charmander_6_R_3 = new TextureRegion(Charmander, 126, 148, 63, 80);
		Charmander_6_R_4 = new TextureRegion(Charmander, 189, 148, 63, 80);
		Charmander_6_R = new Animation(0.2f,Charmander_6_R_1, Charmander_6_R_2,Charmander_6_R_3,Charmander_6_R_4);
		Charmander_6_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Charmander_7_R_1 = new TextureRegion(Charmander, 0, 230, 60, 82);
		Charmander_7_R_2 = new TextureRegion(Charmander, 60, 230, 60, 82);
		Charmander_7_R_3 = new TextureRegion(Charmander, 120, 230, 60, 82);
		Charmander_7_R_4 = new TextureRegion(Charmander, 180, 230, 60, 82);
		Charmander_7_R_1.flip(true, false);
		Charmander_7_R_2.flip(true, false);
		Charmander_7_R_3.flip(true, false);
		Charmander_7_R_4.flip(true, false);
		Charmander_7_R = new Animation(0.2f,Charmander_7_R_1, Charmander_7_R_2,Charmander_7_R_3,Charmander_7_R_4);
		Charmander_7_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Charmander_8_R_1 = new TextureRegion(Charmander, 264, 148, 45, 82);
		Charmander_8_R_2 = new TextureRegion(Charmander, 310, 148, 45, 82);
		Charmander_8_R_3 = new TextureRegion(Charmander, 355, 148, 45, 82);
		Charmander_8_R_4 = new TextureRegion(Charmander, 400, 148, 45, 82);
		Charmander_8_R = new Animation(0.2f,Charmander_8_R_1,Charmander_8_R_2,Charmander_8_R_3,Charmander_8_R_4);
		Charmander_8_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Charmander_9_R_1 = new TextureRegion(Charmander, 0, 230, 60, 82);
		Charmander_9_R_2 = new TextureRegion(Charmander, 60, 230, 60, 82);
		Charmander_9_R_3 = new TextureRegion(Charmander, 120, 230, 60, 82);
		Charmander_9_R_4 = new TextureRegion(Charmander, 180, 230, 60, 82);
		Charmander_9_R = new Animation(0.2f,Charmander_9_R_1, Charmander_9_R_2,Charmander_9_R_3,Charmander_9_R_4);
		Charmander_9_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Charmander_1_A_1 = new TextureRegion(Charmander, 207, 312, 69, 87);
		Charmander_1_A_1.flip(true, false);
		Charmander_1_A = new  Animation(0.2f,Charmander_1_A_1);
		Charmander_2_A_1 = new TextureRegion(Charmander, 278, 312, 69, 87);
		Charmander_2_A = new  Animation(0.2f,Charmander_2_A_1);
		Charmander_3_A_1 = new TextureRegion(Charmander, 207, 312, 69, 87);
		Charmander_3_A = new  Animation(0.2f,Charmander_3_A_1);
		Charmander_4_A_1 = new TextureRegion(Charmander, 138, 312, 69, 87);
		Charmander_4_A_1.flip(true, false);
		Charmander_4_A = new  Animation(0.2f,Charmander_4_A_1);
		Charmander_6_A_1 = new TextureRegion(Charmander, 138, 312, 69, 87);
		Charmander_6_A = new  Animation(0.2f,Charmander_6_A_1);
		Charmander_7_A_1 = new TextureRegion(Charmander, 69, 312, 69, 87);
		Charmander_7_A_1.flip(true, false);
		Charmander_7_A = new  Animation(0.2f,Charmander_7_A_1);
		Charmander_8_A_1 = new TextureRegion(Charmander, 0, 312, 69, 87);
		Charmander_8_A = new  Animation(0.2f,Charmander_8_A_1);
		Charmander_9_A_1 = new TextureRegion(Charmander, 69, 312, 69, 87);
		Charmander_9_A = new  Animation(0.2f,Charmander_9_A_1);
		
		Charmander_1_H_1 = new TextureRegion(Charmander, 207, 399, 69, 87);
		Charmander_1_H_1.flip(true, false);
		Charmander_1_H = new  Animation(0.2f,Charmander_1_H_1);
		Charmander_2_H_1 = new TextureRegion(Charmander, 278, 399, 69, 87);
		Charmander_2_H = new  Animation(0.2f,Charmander_2_H_1);
		Charmander_3_H_1 = new TextureRegion(Charmander, 207, 399, 69, 87);
		Charmander_3_H = new  Animation(0.2f,Charmander_3_H_1);
		Charmander_4_H_1 = new TextureRegion(Charmander, 138, 399, 69, 87);
		Charmander_4_H_1.flip(true, false);
		Charmander_4_H = new  Animation(0.2f,Charmander_4_H_1);
		Charmander_6_H_1 = new TextureRegion(Charmander, 138, 399, 69, 87);
		Charmander_6_H = new  Animation(0.2f,Charmander_6_H_1);
		Charmander_7_H_1 = new TextureRegion(Charmander, 69, 399, 69, 87);
		Charmander_7_H_1.flip(true, false);
		Charmander_7_H = new  Animation(0.2f,Charmander_7_H_1);
		Charmander_8_H_1 = new TextureRegion(Charmander, 0, 399, 69, 87);
		Charmander_8_H = new  Animation(0.2f,Charmander_8_A_1);
		Charmander_9_H_1 = new TextureRegion(Charmander, 69, 399, 69, 87);
		Charmander_9_H = new  Animation(0.2f,Charmander_9_H_1);
		
		
		
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
package com.Eevee.Util;

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

	public static Texture Bulbasaur;
	public static TextureRegion Bulbasaur_1_R_1, Bulbasaur_1_R_2, Bulbasaur_1_R_3, 
								Bulbasaur_2_R_1, Bulbasaur_2_R_2, Bulbasaur_2_R_3,
								Bulbasaur_3_R_1, Bulbasaur_3_R_2, Bulbasaur_3_R_3,
								Bulbasaur_4_R_1, Bulbasaur_4_R_2, Bulbasaur_4_R_3,
								Bulbasaur_6_R_1, Bulbasaur_6_R_2, Bulbasaur_6_R_3,
								Bulbasaur_7_R_1, Bulbasaur_7_R_2, Bulbasaur_7_R_3,
								Bulbasaur_8_R_1, Bulbasaur_8_R_2, Bulbasaur_8_R_3,
								Bulbasaur_9_R_1, Bulbasaur_9_R_2, Bulbasaur_9_R_3,
								Bulbasaur_1_A_1, Bulbasaur_2_A_1, Bulbasaur_3_A_1, Bulbasaur_4_A_1, Bulbasaur_6_A_1, Bulbasaur_7_A_1, Bulbasaur_8_A_1, Bulbasaur_9_A_1,
								Bulbasaur_1_H_1, Bulbasaur_2_H_1, Bulbasaur_3_H_1, Bulbasaur_4_H_1, Bulbasaur_6_H_1, Bulbasaur_7_H_1, Bulbasaur_8_H_1, Bulbasaur_9_H_1; 
	public static Animation Bulbasaur_1_R, Bulbasaur_2_R, Bulbasaur_3_R,
			Bulbasaur_4_R, Bulbasaur_5_R, Bulbasaur_6_R, Bulbasaur_7_R,
			Bulbasaur_8_R, Bulbasaur_9_R, Bulbasaur_1_A, Bulbasaur_2_A,
			Bulbasaur_3_A, Bulbasaur_4_A, Bulbasaur_5_A, Bulbasaur_6_A,
			Bulbasaur_7_A, Bulbasaur_8_A, Bulbasaur_9_A, Bulbasaur_1_H,
			Bulbasaur_2_H, Bulbasaur_3_H, Bulbasaur_4_H, Bulbasaur_5_H,
			Bulbasaur_6_H, Bulbasaur_7_H, Bulbasaur_8_H, Bulbasaur_9_H; // Bulbasaur

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

	private static void loadBulbasaur() {
		// TODO Auto-generated method stub
		Bulbasaur = new Texture(Gdx.files.internal("data/Bulbasaur.png"));
		Bulbasaur_2_R_1 = new TextureRegion(Bulbasaur, 0, 0, 57, 66);
		Bulbasaur_2_R_2 = new TextureRegion(Bulbasaur, 57, 0, 57, 66);
		Bulbasaur_2_R_3 = new TextureRegion(Bulbasaur, 114, 0, 57, 66);
		Bulbasaur_2_R = new Animation(0.2f,Bulbasaur_2_R_1, Bulbasaur_2_R_2,Bulbasaur_2_R_3);
		Bulbasaur_2_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_3_R_1 = new TextureRegion(Bulbasaur, 0, 66, 72, 66);
		Bulbasaur_3_R_2 = new TextureRegion(Bulbasaur, 72, 66, 72, 66);
		Bulbasaur_3_R_3 = new TextureRegion(Bulbasaur, 144, 66, 72, 66);
		Bulbasaur_3_R = new Animation(0.2f,Bulbasaur_3_R_1, Bulbasaur_3_R_2,Bulbasaur_3_R_3);
		Bulbasaur_3_R.setPlayMode(Animation.PlayMode.LOOP);
		
		Bulbasaur_1_R_1 = new TextureRegion(Bulbasaur, 0, 66, 72, 66);
		Bulbasaur_1_R_2 = new TextureRegion(Bulbasaur, 72, 66, 72, 66);
		Bulbasaur_1_R_3 = new TextureRegion(Bulbasaur, 144, 66, 72, 66);
		Bulbasaur_1_R_1.flip(true, false);
		Bulbasaur_1_R_2.flip(true, false);
		Bulbasaur_1_R_3.flip(true, false);
		Bulbasaur_1_R = new Animation(0.2f,Bulbasaur_1_R_1, Bulbasaur_1_R_2,Bulbasaur_1_R_3);
		Bulbasaur_1_R.setPlayMode(Animation.PlayMode.LOOP);
		
		
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

		// Dispose sounds
	/*	dead.dispose();
		flap.dispose();
		coin.dispose();

		font.dispose();
		shadow.dispose();*/
	}

}
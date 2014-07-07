package com.Eevee;

import com.Eevee.PokemonData.PokeDex;
import com.Eevee.Screens.TestScreen;
import com.Eevee.Util.AssetLoader;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class EeveeProjectGame extends Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create() {
		AssetLoader.load();
		PokeDex.load();
		setScreen(new TestScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}




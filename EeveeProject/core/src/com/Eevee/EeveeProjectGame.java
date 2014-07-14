package com.Eevee;

import com.Eevee.PokemonData.PokeDex;
import com.Eevee.Screens.ArenaScreen;
import com.Eevee.Util.AssetLoader;
import com.Eevee.Util.PokemonBoundMap;
import com.Eevee.Util.ProjectileBoundMap;
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
		PokemonBoundMap.load();
		ProjectileBoundMap.load();
		setScreen(new ArenaScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}




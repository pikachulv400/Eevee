package com.Eevee.Util;

import java.util.HashMap;

import com.Eevee.PokemonData.PokemonName;

public class PokemonBoundMap {
	public static HashMap<PokemonName,PokemonBoundData> boundmap = new HashMap<PokemonName,PokemonBoundData>();
	
	public static void load(){
		boundmap.put(PokemonName.BULBASAUR, PokemonBoundData.BULBASAUR);
		boundmap.put(PokemonName.CHARMANDER, PokemonBoundData.CHARMANDER);
		boundmap.put(PokemonName.SQUIRTLE, PokemonBoundData.SQUIRTLE);
	}
	public static PokemonBoundData getBoundDataByPokemonName(PokemonName name)
	{
		return boundmap.get(name);
	}
}

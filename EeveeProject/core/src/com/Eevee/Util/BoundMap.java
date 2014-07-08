package com.Eevee.Util;

import java.util.HashMap;

import com.Eevee.PokemonData.PokemonName;

public class BoundMap {
	public static HashMap<PokemonName,BoundData> boundmap = new HashMap<PokemonName,BoundData>();
	
	public static void load(){
		boundmap.put(PokemonName.BULBASAUR, BoundData.BULBASAUR);
		boundmap.put(PokemonName.CHARMANDER, BoundData.CHARMANDER);
		boundmap.put(PokemonName.SQUIRTLE, BoundData.SQUIRTLE);
	}
	public static BoundData getBoundDataByPokemonName(PokemonName name)
	{
		return boundmap.get(name);
	}
}

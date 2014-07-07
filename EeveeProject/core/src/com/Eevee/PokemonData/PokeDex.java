package com.Eevee.PokemonData;

import java.util.HashMap;

public class PokeDex {

	private static HashMap<PokemonName,PokemonInfo> pokedex = new HashMap<PokemonName,PokemonInfo>();

	public static void load() {
		// TODO Auto-generated method stub
		pokedex.put(PokemonName.BULBASAUR, new PokemonInfo(1, 45, 100, 100, 49, 49, 65, 65, 45, PokemonType.GRASS));
		pokedex.put(PokemonName.CHARMANDER, new PokemonInfo(4, 39, 100, 100, 52, 43,60, 50, 65, PokemonType.FIRE)); 
		pokedex.put(PokemonName.SQUIRTLE, new PokemonInfo(7, 44, 100, 100, 48, 65, 50, 64, 43, PokemonType.WATER));
	}

	
	public static PokemonInfo lookUpPokemon(PokemonName pokemonName)
	{
		return pokedex.get(pokemonName);
	}
	
}

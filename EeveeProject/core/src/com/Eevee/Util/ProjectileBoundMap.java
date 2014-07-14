package com.Eevee.Util;

import java.util.HashMap;

import com.Eevee.PokemonData.Action;



public class ProjectileBoundMap {
	public static HashMap<Action,ProjectileBoundData> boundmap = new HashMap<Action,ProjectileBoundData>();
	
	public static void load(){
		boundmap.put(Action.MOVE1, ProjectileBoundData.MOVE1);
		boundmap.put(Action.MOVE2, ProjectileBoundData.MOVE2);
		boundmap.put(Action.MOVE3, ProjectileBoundData.MOVE3);
	}
	public static ProjectileBoundData getBoundDataByMoveName(Action name)
	{
		return boundmap.get(name);
	}
}

package com.Eevee.Util;

import com.Eevee.PokemonData.Action;

public class PokemonState {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + direction;
		result = prime * result + index;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokemonState other = (PokemonState) obj;
		if (action != other.action)
			return false;
		if (direction != other.direction)
			return false;
		if (index != other.index)
			return false;
		return true;
	}
	private int index;
	private int direction;
	private Action action;
	
	
	
	public PokemonState(int index, int direction, Action action) {
		this.index = index;
		this.direction = direction;
		this.action = action;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(byte direction) {
		this.direction = direction;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	
	

}

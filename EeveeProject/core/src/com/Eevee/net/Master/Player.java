package com.Eevee.net.Master;

import java.util.ArrayList;

import com.Eevee.GameObjects.Pokemon;
import com.Eevee.Util.InputHandler;
import com.Eevee.net.GameClient;
import com.Eevee.net.GameServer;

public class Player {
	private int ID;
	private InputHandler input;
	private Pokemon pokemon;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public InputHandler getInput() {
		return input;
	}
	public void setInput(InputHandler input) {
		this.input = input;
	}
	public Pokemon getPokemon() {
		return pokemon;
	}
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	
}

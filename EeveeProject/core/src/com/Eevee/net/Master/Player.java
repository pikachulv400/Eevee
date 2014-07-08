package com.Eevee.net.Master;

import java.util.ArrayList;

import com.Eevee.GameObjects.Pokemon;
import com.Eevee.Util.InputHandler;
import com.Eevee.net.GameClient;
import com.Eevee.net.GameServer;

public class Player {
	public Player(int iD, InputHandler input) {
		super();
		ID = iD;
		this.input = input;
	}
	private int ID;
	private InputHandler input;

	
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
	public void update(float delta) {
		// TODO Auto-generated method stub
		input.getInputUpdater().update();
		input.getPokemon().update(delta);
		
	}
	
}

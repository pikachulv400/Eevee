package com.Eevee.PokemonData;

public enum PokeData {
	BULBASAUR(1, 45, 100, 100, 49, 49, 65, 65, 45), CHARMANDER(4, 39, 100, 100,
			52, 43, 60, 50, 65), SQUIRTLE(7, 44, 100, 100, 48, 65, 50, 64, 43);

	private int index;
	private int baseHp;
	private int basePp;
	private int baseStamina;
	private int baseAtk;
	private int baseDef;
	private int baseSpAtk;
	private int baseSpDef;
	private int baseSpeed;

	public int getBaseHp() {
		return baseHp;
	}

	public void setBaseHp(int baseHp) {
		this.baseHp = baseHp;
	}

	public int getBasePp() {
		return basePp;
	}

	public void setBasePp(int basePp) {
		this.basePp = basePp;
	}

	public int getBaseStamina() {
		return baseStamina;
	}

	public void setBaseStamina(int baseStamina) {
		this.baseStamina = baseStamina;
	}

	public int getBaseAtk() {
		return baseAtk;
	}

	public void setBaseAtk(int baseAtk) {
		this.baseAtk = baseAtk;
	}

	public int getBaseDef() {
		return baseDef;
	}

	public void setBaseDef(int baseDef) {
		this.baseDef = baseDef;
	}

	public int getBaseSpAtk() {
		return baseSpAtk;
	}

	public void setBaseSpAtk(int baseSpAtk) {
		this.baseSpAtk = baseSpAtk;
	}

	public int getBaseSpDef() {
		return baseSpDef;
	}

	public void setBaseSpDef(int baseSpDef) {
		this.baseSpDef = baseSpDef;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private PokeData(int index, int baseHp, int basePp, int baseStamina,
			int baseAtk, int baseDef, int baseSpAtk, int baseSpDef,
			int baseSpeed) {
		this.index = index;
		this.baseHp = baseHp;
		this.basePp = basePp;
		this.baseStamina = baseStamina;
		this.baseAtk = baseAtk;
		this.baseDef = baseDef;
		this.baseSpAtk = baseSpAtk;
		this.baseSpDef = baseSpDef;
		this.baseSpeed = baseSpeed;
	}

	public int getIndex() {
		return index;
	}
}

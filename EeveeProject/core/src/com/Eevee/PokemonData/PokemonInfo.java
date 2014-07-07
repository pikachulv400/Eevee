package com.Eevee.PokemonData;

public class PokemonInfo {

	private int index;
	private int baseHp;
	private int basePp;
	private int baseStamina;
	private int baseAtk;
	private int baseDef;
	private int baseSpAtk;
	private int baseSpDef;
	private int baseSpeed;
	private PokemonType type;

	public PokemonInfo(int index, int baseHp, int basePp, int baseStamina,
			int baseAtk, int baseDef, int baseSpAtk, int baseSpDef,
			int baseSpeed, PokemonType type) {
		super();
		this.index = index;
		this.baseHp = baseHp;
		this.basePp = basePp;
		this.baseStamina = baseStamina;
		this.baseAtk = baseAtk;
		this.baseDef = baseDef;
		this.baseSpAtk = baseSpAtk;
		this.baseSpDef = baseSpDef;
		this.baseSpeed = baseSpeed;
		this.type = type;
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}

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

	public int getIndex() {
		return index;
	}
}

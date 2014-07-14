package com.Eevee.GameObjects;

import com.Eevee.GameWorld.GameWorld;
import com.Eevee.MoveMachines.Move;
import com.Eevee.PokemonData.Action;
import com.Eevee.PokemonData.PokeDex;
import com.Eevee.PokemonData.PokemonName;
import com.Eevee.PokemonData.Status;
import com.Eevee.Util.AssetLoader;
import com.Eevee.Util.PokemonBoundData;
import com.Eevee.Util.PokemonBoundMap;
import com.Eevee.Util.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Vector2;

public class Pokemon extends Entity {

	private PokemonName name;
	private int direction; // 1-9
	private Status status;
	private Action action;
	private int level;
	private int maxHp;
	private int hp; // health point
	private int maxPp;
	private int pp; // energy point
	private int maxStamina;
	private int stamina;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int speed;
	private int exp;
	private boolean isAlive;
	private Move move1;
	private Move move2;
	private Move move3;
	private Move move4;
	private Ellipse bound;
	private PokemonBoundData bd;
	private int recoverRate = 50;
	private int shouldRecover = 0;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Vector2 getBoundOrigin(){
		return new Vector2(bound.x+(bound.width/2),bound.y+(bound.height/2));
	}
	public Move getMove1() {
		return move1;
	}

	public void setMove1(Move move1) {
		this.move1 = move1;
	}

	public Move getMove2() {
		return move2;
	}

	public void setMove2(Move move2) {
		this.move2 = move2;
	}

	public Move getMove3() {
		return move3;
	}

	public void setMove3(Move move3) {
		this.move3 = move3;
	}

	public Move getMove4() {
		return move4;
	}

	public void setMove4(Move move4) {
		this.move4 = move4;
	}

	public Ellipse getBound() {
		return bound;
	}

	public void setBound(Ellipse bound) {
		this.bound = bound;
	}

	public PokemonName getName() {
		return name;
	}

	public boolean update(float delta) {
		shouldRecover++;
		if(shouldRecover>=recoverRate && pp<maxPp)
		{
			pp+=1;
			shouldRecover =0;
		}
		if (hp <= 0) {
			isAlive = false;
		}
		if (action == Action.RUN) {
			switch (direction) {
			case 1:
				this.setVelocity(new Vector2(-2.1213f, -2.1213f));
				break;
			case 2:
				this.setVelocity(new Vector2(0, -3));
				break;
			case 3:
				this.setVelocity(new Vector2(2.1213f, -2.1213f));
				break;
			case 4:
				this.setVelocity(new Vector2(-3, 0));
				break;
			case 6:
				this.setVelocity(new Vector2(3, 0));
				break;
			case 7:
				this.setVelocity(new Vector2(-2.1213f, 2.1213f));
				break;
			case 8:
				this.setVelocity(new Vector2(0, 3));
				break;
			case 9:
				this.setVelocity(new Vector2(2.1213f, 2.1213f));
				break;
			}
			this.getVelocity().scl(delta).scl(65);
		} else {
			this.setVelocity(new Vector2(0, 0));
		}
		if(bound.x+bound.width+this.getVelocity().x>GameWorld.getBackground().getX()+GameWorld.getBackground().getWidth()||
		   bound.x+this.getVelocity().x<GameWorld.getBackground().getX())
		{
			this.getVelocity().x=0;
		}
		if(bound.y+bound.height+this.getVelocity().y>GameWorld.getBackground().getY()+GameWorld.getBackground().getHeight()||
		   bound.y+this.getVelocity().y<GameWorld.getBackground().getY())
		{
			this.getVelocity().y=0;
		}
		this.getPosition().add(this.getVelocity());
		bound.setPosition(super.getPosition().cpy().add(bd.getOffset()));


		return isAlive;
	}
	

	public void setName(PokemonName name) {
		this.name = name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxPp() {
		return maxPp;
	}

	public void setMaxPp(int maxPp) {
		this.maxPp = maxPp;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getMaxStamina() {
		return maxStamina;
	}

	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpAtk() {
		return spAtk;
	}

	public void setSpAtk(int spAtk) {
		this.spAtk = spAtk;
	}

	public int getSpDef() {
		return spDef;
	}

	public void setSpDef(int spDef) {
		this.spDef = spDef;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Pokemon(Vector2 position, int height, int width, PokemonName name) {
		super(position, new Vector2(0, 0), height, width);
		this.level = 1;
		this.name = name;
		this.isAlive = true;
		this.status = Status.NORMAL;
		this.action = Action.IDLE;
		this.direction = 2;
		this.setExp(0);
		this.maxHp = PokeDex.lookUpPokemon(name).getBaseHp();
		this.hp = maxHp; // health point
		this.maxPp = PokeDex.lookUpPokemon(name).getBasePp();
		this.pp = maxPp; // energy point
		this.maxStamina = PokeDex.lookUpPokemon(name).getBaseStamina() ;
		this.stamina =maxStamina;
		this.atk = PokeDex.lookUpPokemon(name).getBaseAtk();
		this.def =  PokeDex.lookUpPokemon(name).getBaseDef();
		this.spAtk =  PokeDex.lookUpPokemon(name).getBaseSpAtk();
		this.spDef =  PokeDex.lookUpPokemon(name).getBaseSpDef();
		this.speed =  PokeDex.lookUpPokemon(name).getBaseSpeed();
		bd = PokemonBoundMap.getBoundDataByPokemonName(name);
		Vector2 ellipsePosition = super.getPosition().cpy();
		bound = new Ellipse(ellipsePosition, bd.getWidth(), bd.getHeight());
	}

	public Pokemon(Vector2 position, int height, int width, PokemonName name,
			int maxHp, int hp, int maxPp, int pp, int maxStamina, int stamina,
			int atk, int def, int spAtk, int spDef, int speed) {
		super(position, new Vector2(0, 0), height, width);
		this.level = 1;
		this.name = name;
		this.maxHp = maxHp;
		this.hp = hp;
		this.maxPp = maxPp;
		this.pp = pp;
		this.setExp(0);
		this.maxStamina = maxStamina;
		this.stamina = stamina;
		this.atk = atk;
		this.def = def;
		this.spAtk = spAtk;
		this.spDef = spDef;
		this.speed = speed;
		this.isAlive = true;
		this.status = Status.NORMAL;
		this.action = Action.IDLE;
		this.direction = 2;
		bd = PokemonBoundMap.getBoundDataByPokemonName(name);
		Vector2 ellipsePosition = super.getPosition().cpy().add(bd.getOffset());
		bound = new Ellipse(ellipsePosition, bd.getWidth(), bd.getHeight());
	}

	public Animation getCurrentAnimation() {
		return AssetLoader.getAnimationFor(PokeDex.lookUpPokemon(name)
				.getIndex(), direction, action);
	}
	private InputHandler inputHandler;
	public void setInputhandler(InputHandler inputHandler) {
		// TODO Auto-generated method stub
		this.inputHandler = inputHandler;
		
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

}

package edu.kh.game.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Player implements Serializable {

	private String name;
	private int hp;
	private int defense;
	private int power;
	private int stamina;
	private int floor;
	private String[] item;
	private boolean key;
	

	public Player() {
		super();
	}

	public Player(String name, int hp, int defense, int power, int stamina, int floor, boolean key) {
		super();
		this.name = name;
		this.hp = hp;
		this.defense = defense;
		this.power = power;
		this.stamina = stamina;
		this.floor = floor;
		this.key = key;
	}
	 public Player(String name) { /* 플레이어 이름 짓기 */
	      this.name = name;
	   }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String[] getItem() {
		return item;
	}

	public void setItem(String[] item) {
		this.item = item;
	}

	public boolean getKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(item);
		result = prime * result + Objects.hash(defense, floor, hp, key, name, power, stamina);
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
		Player other = (Player) obj;
		return defense == other.defense && floor == other.floor && hp == other.hp && Arrays.equals(item, other.item)
				&& key == other.key && Objects.equals(name, other.name) && power == other.power
				&& stamina == other.stamina;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", hp=" + hp + ", defense=" + defense + ", power=" + power + ", stamina="
				+ stamina + ", floor=" + floor + ", item=" + Arrays.toString(item) + ", key=" + key + "]";
	}

}
package edu.kh.game.dto;

import java.util.Objects;

public class Player {
	
	private String name;
	private int hp;
	private int defense;
	private int power;
	private int stamina;
	private int floor;
	private String item1;
	private String item2;
	private String item3;
	private String item4;
	private String item5;
	
	public Player() {}

	public Player(String name, int hp, int defense, int power, int stamina, int floor, 
			String item1, String item2, String item3, String item4, String item5) {
		this.name = name;
		this.hp = hp;
		this.defense = defense;
		this.power = power;
		this.stamina = stamina;
		this.floor = floor;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
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

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public String getItem3() {
		return item3;
	}

	public void setItem3(String item3) {
		this.item3 = item3;
	}

	public String getItem4() {
		return item4;
	}

	public void setItem4(String item4) {
		this.item4 = item4;
	}

	public String getItem5() {
		return item5;
	}

	public void setItem5(String item5) {
		this.item5 = item5;
	}

	@Override
	public int hashCode() {
		return Objects.hash(stamina, defense, floor, hp,
				item1, item2, item3, item4, item5, name, power);
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
		return stamina == other.stamina && defense == other.defense && floor == other.floor && hp == other.hp
				&& Objects.equals(item1, other.item1) && Objects.equals(item2, other.item2)
				&& Objects.equals(item3, other.item3) && Objects.equals(item4, other.item4)
				&& Objects.equals(item5, other.item5) && Objects.equals(name, other.name) && power == other.power;
	}
}

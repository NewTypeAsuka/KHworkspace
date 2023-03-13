package edu.kh.game.dto;

import java.util.Objects;

public class Zombie {
	
	private String name;
	private int hp;
	private int power;
	
	public Zombie() {
		super();
	}

	public Zombie(String name, int hp, int power) {
		super();
		this.name = name;
		this.hp = hp;
		this.power = power;
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

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hp, name, power);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zombie other = (Zombie) obj;
		return hp == other.hp && Objects.equals(name, other.name) && power == other.power;
	}
	
}

package edu.kh.game.dto;
import java.io.Serializable;
import java.util.Objects;
public class Equipment implements Serializable{
	private String name;
	private int Status = 0;
	private int evasion = 0;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getEvasion() {
		return evasion;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public Equipment() {
		super();
	}

	public Equipment(String name, int status, int evasion) {
		super();
		this.name = name;
		this.Status = status;
		this.evasion = evasion;
	}
	

	

}

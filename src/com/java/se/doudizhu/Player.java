package com.java.se.doudizhu;


import java.util.HashSet;
import java.util.Set;

public class Player {

	private String name;
	private Set<PuKe> puKe;
	public Player() {
		this.puKe = new HashSet<PuKe>();
	}
	public Player(String name) {
		this();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<PuKe> getPuKe() {
		return puKe;
	}
	public void setPuKe(Set<PuKe> puKe) {
		this.puKe = puKe;
	}
	
	
}

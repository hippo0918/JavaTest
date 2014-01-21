package com.java.se.doudizhu;


public class PuKe {
	public PuKe() {
		
	}
	public PuKe(String name) {
		this();
		this.name = name;
	}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

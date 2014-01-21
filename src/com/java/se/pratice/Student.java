package com.java.se.pratice;

public class Student {

	private String name;
	private float score;
	private String classNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Student(String name, float score, String classNumber) {
		super();
		this.name = name;
		this.score = score;
		this.classNumber = classNumber;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
}

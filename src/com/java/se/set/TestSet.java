package com.java.se.set;

public class TestSet {

	public static void main(String[] args) {
		DefinitionSet<String> set = new LizebinHashSet<String>();
		boolean a = set.add("lizebin");
		System.out.println(a);
		a = set.add("lizebin1");
		System.out.println(a);
		a = set.add("lizebin2");
		System.out.println(a);
		a = set.add("lizebin3");
		System.out.println(a);
		a = set.add("lizebin1");
		System.out.println(a);
		a = set.add("lizebin");
		System.out.println(a);
		
	}
}

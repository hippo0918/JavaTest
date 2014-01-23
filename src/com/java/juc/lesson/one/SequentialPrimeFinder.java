package com.java.juc.lesson.one;

public class SequentialPrimeFinder extends AbstractPrimeFinder {

	@Override
	public int countPrimes(final int number) {
		// TODO Auto-generated method stub
		return countPrimesInRange(1, number);
	}
	
	public static void main(String[] args) {
		new SequentialPrimeFinder().timeAndComputer(100);
	}

}

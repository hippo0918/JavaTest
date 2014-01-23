package com.java.juc.lesson.one;

public abstract class AbstractPrimeFinder {

	public boolean isPrime(final int number) {
		if (number <= 1) {
			return false;
		}

		//区间：[1, 100000] 
		//素数个数：9592
		//耗时：0.105569098
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		
		//区间：[1, 100000] 
		//素数个数：9592
		//耗时：4.589483212
		/*for(int i=2; i<number; i++) {
			if (number % i == 0) {
				return false;
			}
		}*/
		return true;
	}

	public int countPrimesInRange(final int lower, final int upper) {
		int total = 0;
		for (int i = lower; i <= upper; i++) {
			if (isPrime(i)) {
				total++;
			}
		}
		return total;
	}
	
	public void timeAndComputer(final int number) {
		final long start = System.nanoTime();
		final long numberOfPrimes = countPrimes(number);
		final long end = System.nanoTime();
		System.out.printf("总区间：[%d, %d] \n",1, number);
		System.out.println("素数个数：" + numberOfPrimes);
		System.out.println("耗时：" + (end - start)/1.0e9);
	}
	
	public abstract int countPrimes(final int number);
}

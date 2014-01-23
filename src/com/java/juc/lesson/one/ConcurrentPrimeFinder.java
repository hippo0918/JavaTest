package com.java.juc.lesson.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentPrimeFinder extends AbstractPrimeFinder {

	private final int poolSize;
	private final int numberOfParts;
	
	public ConcurrentPrimeFinder(final int poolSize, final int numberOfParts) {
		this.poolSize = poolSize;
		this.numberOfParts = numberOfParts;
	}

	@Override
	public int countPrimes(int number) {
		int count = 0;
		try {
			final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
			final List<Callable<Integer>> partitions = new ArrayList<Callable<Integer>>();
			//随机划分区间
			final int chunksPerPartition = number / numberOfParts;
			for(int i=0; i<numberOfParts; i++) {
				final int lower = (i * chunksPerPartition) + 1;
				final int upper = (i == numberOfParts - 1) ? number : lower + chunksPerPartition - 1;
				partitions.add(new Callable<Integer>() {
					@Override
					public Integer call() throws Exception {
						System.out.printf("划分区间  [%d, %d] \n", lower, upper);
						return countPrimesInRange(lower, upper);
					}
				});
			}
			final List<Future<Integer>> resultFromParts = executorPool.invokeAll(partitions);
			executorPool.shutdown();
			for(final Future<Integer> result : resultFromParts) {
				count += result.get();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static void main(String[] args) {
		//划分区间  [1, 100] 
		/*总区间：[1, 100] 
		素数个数：25
		耗时：0.061330183*/
		new ConcurrentPrimeFinder(2, 1).timeAndComputer(100);
	}
	
}

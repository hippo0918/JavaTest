package com.java.juc.lesson.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 生成10000个范围为[10,100]的整数
 * 并计算List<Integer>里面所有的总数之和
 * */
public class IntegerListTotal {

	public static final int MAX = 10000000;
	public static List<Integer> static_list = new ArrayList<Integer>();
	public static final int threadSize = 10;
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<MAX; i++) {
			int num = new Random().nextInt(100) + 10;
			list.add(num);
		}
		
		singleThreadCalculate(list);
		multiplyThreadCalculate(list);
		try {
			useCyclicBarrierCalculate(list);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long startTime = System.nanoTime();
		long sum = CountListIntegerSum.getIntegerSum(list, threadSize);
		long endTime = System.nanoTime();
		System.out.println("总数：" + sum);
		System.out.println("CountListIntegerSum 所需时间：" + ((endTime - startTime)/1.0e9) + "秒");
	}
	
	/**
	 * single thread calculate
	 * */
	public static void singleThreadCalculate(List<Integer> list) {
		long startTime = System.nanoTime();
		int total = 0;
		if(list != null) {
			for(Integer num : list) {
				total += num.intValue();
			}
		}
		long endTime = System.nanoTime();
		System.out.println("总数：" + total);
		System.out.println("singleThreadCalculate 所需时间：" + ((endTime - startTime)/1.0e9) + "秒");
	}
	
	/**
	 * multiply thread calculate
	 * @param list
	 */
	public static void multiplyThreadCalculate(final List<Integer> list) {
		long startTime = System.nanoTime();
		ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);
		List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
		//区间大小
		final int positionSize = MAX/threadSize;
		//区间坐标
		for(int j=0; j<threadSize; j++) {
			final int position = j;
			tasks.add(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					//System.out.printf("区间：" + "[%d,%d]",position * positionSize, (position+1) * positionSize);
					List<Integer> l = list.subList(position * positionSize, (position+1) * positionSize);
					int total = 0;
					if(l != null) {
						for(Integer i : l) {
							total += i.intValue();
						}
					}
					return total;
				}
				
			});
		}
		
		int total = 0;
		try {
			List<Future<Integer>> results = threadPool.invokeAll(tasks);
			if(results != null) {
				for(Future<Integer> result : results) {
					total += result.get().intValue();
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.nanoTime();
		System.out.println("总数：" + total);
		System.out.println("multiplyThreadCalculate 所需时间：" + ((endTime - startTime)/1.0e9) + "秒");
		threadPool.shutdown();
	}
	
	/**
	 * use CyclicBarrier calculate
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @throws BrokenBarrierException 
	 * */
	public static void useCyclicBarrierCalculate(final List<Integer> list) throws InterruptedException, ExecutionException, BrokenBarrierException {
		long startTime = System.nanoTime();
		ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);
		//障栅集合点(同步器) ,为什么+1,因为这里还有一条归并所有线程总数的线程，就是main线程。
		CyclicBarrier barrier = new CyclicBarrier(threadSize + 1);
		//区间大小
		final int positionSize = MAX/threadSize;
		for(int j=0; j<threadSize; j++) {
			final int position = j;
			List<Integer> l = list.subList(position * positionSize, (position+1) * positionSize);
			threadPool.execute(new Calculate(l, barrier));
		}
		//等待threadSize集齐,main线程还要等待，如果没有这里。。main线程会一直走下去，其他线程的等待都是无用功
		barrier.await();
		//System.out.println("Should Waiting Thread = " + barrier.getParties());
		//System.out.println("Outing Waiting Thread = " + barrier.getNumberWaiting());
		int total = 0;
		//最后用main线程来求总和
		//System.out.println(Thread.currentThread().getName());
		for(Integer i :static_list) {
			total += i.intValue();
		}
		long endTime = System.nanoTime();
		System.out.println("总数：" + total);
		System.out.println("useCyclicBarrierCalculate 所需时间：" + ((endTime - startTime)/1.0e9) + "秒");
		threadPool.shutdown();
	}
}

class Calculate implements Runnable {
	private List<Integer> list;
	private CyclicBarrier cyclicBarrier;
	
	public Calculate(List<Integer> list, CyclicBarrier cyclicBarrier) {
		this.list = list;
		this.cyclicBarrier = cyclicBarrier;
	}
	
	@Override
	public void run() {
		int total = 0;
		if(list != null) {
			for(Integer num : list) {
				total += num.intValue();
			}
		}
		try {
			IntegerListTotal.static_list.add(total);
			cyclicBarrier.await();
			//cyclicBarrier.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}  
	
}

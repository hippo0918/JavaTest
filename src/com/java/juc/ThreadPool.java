package com.java.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	
	public static void main(String[] args) {
		//ExecutorService execute = Executors.newCachedThreadPool();
		//ExecutorService execute = Executors.newFixedThreadPool(3);
		ExecutorService execute = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			final int task = i;
			execute.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 5; j++) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " The loop is " + j + ";" + "The task is " + task);
					}
				}
				
			});
		}
		execute.shutdown();
	}
}

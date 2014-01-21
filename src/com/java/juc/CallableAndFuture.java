package com.java.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class CallableAndFuture {

	public static void main(String[] args) {
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(Executors.newCachedThreadPool());
		for(int i=0; i<10; i++) {//提交10个任务
			final int task = i;
			cs.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					Thread.sleep(1000);
					System.out.println("第" + task + "个任务正在执行 。。。");
					return task;
				}
			});
		}
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("最先运行完的是:" + cs.take().get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

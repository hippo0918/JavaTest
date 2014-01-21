package com.java.se.pratice;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Test {

	public static void main(String[] args) {
		final ArrayBlockingQueue<String> logs = new ArrayBlockingQueue<String>(16);
		for (int i = 0; i < 4; i++) {
			//一秒打4个
			new Thread(new Runnable(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0; i<4; i++) {
						String log;
						try {
							log = logs.take();
							Test.parseLog(log);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}).start();
		}
		System.out.println("begin:" + (System.currentTimeMillis() / 1000));
		/*
		 * 模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印完
		 * 这些日志。修改程序代码，开四个线程让这16个对象在4秒钟打完。
		 */
		for (int i = 0; i < 16; i++) { // 这行代码不能改动
			final String log = "" + (i + 1);// 这行代码不能改动
			{
				logs.add(log);
			}
		}
	}

	// parseLog方法内部的代码不能改动
	public static void parseLog(String log) {
		System.out.println(Thread.currentThread().getName() + ":" + log + "." + (System.currentTimeMillis() / 1000));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
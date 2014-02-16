package com.java.se.pratice.answer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyAnswer {
	
	public static void main(String[] args){
        final ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(4);
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		/*模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印完这些日志。
		修改程序代码，开四个线程让这16个对象在4秒钟打完。
		*/
		//Test.parseLog(log);
		for(int j=0; j<4; j++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int k=0; k<4; k++) {
						try {
							MyAnswer.parseLog(abq.take());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
		for(int i=0;i<16;i++){  //这行代码不能改动
			final String log = ""+(i+1);//这行代码不能改动
			{
				try {
					abq.put(log);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("aaa abc ddd abc abc ".replaceAll(" abc", " "));
		
	}
	
	//parseLog方法内部的代码不能改动
	public static void parseLog(String log){
		System.out.println(Thread.currentThread().getName() + ":" + log + "." + (System.currentTimeMillis() / 1000));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}
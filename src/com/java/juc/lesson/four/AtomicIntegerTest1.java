package com.java.juc.lesson.four;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest1 {

	public int i = 0;
	public AtomicInteger j = new AtomicInteger(0);
	
	public static void main(String[] args) {
		AtomicIntegerTest1 instance = new AtomicIntegerTest1();
		
		//创建100个线程对变量进行自增
		for(int i=0; i<10; i++) {
			new Thread(new Add1(instance)).start();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("i = " + instance.i);
		System.out.println("j = " + instance.j.get());
	}
	
}

class Add1 implements Runnable {
	
	private AtomicIntegerTest1 instance;
	
	public Add1(AtomicIntegerTest1 instance) {
		this.instance = instance;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		instance.i++;
		instance.j.addAndGet(1);
	}
	
}

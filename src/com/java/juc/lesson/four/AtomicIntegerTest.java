package com.java.juc.lesson.four;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

	public static int i = 0;
	public static AtomicInteger j = new AtomicInteger(0);
	
	public static void main(String[] args) {
		//创建100个线程对变量进行自增
		for(int i=0; i<100; i++) {
			new Thread(new Add()).start();
			new Thread(new Decrease()).start();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("i = " + AtomicIntegerTest.i);
		System.out.println("j = " + AtomicIntegerTest.j.get());
	}
	
}

class Add implements Runnable {
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AtomicIntegerTest.i++;
		AtomicIntegerTest.j.addAndGet(1);
		//System.out.println("i = " + AtomicIntegerTest.i);
		//System.out.println("j = " + AtomicIntegerTest.j.get());
	}
	
}

class Decrease implements Runnable {
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AtomicIntegerTest.i--;
		AtomicIntegerTest.j.decrementAndGet();
		//System.out.println("i = " + AtomicIntegerTest.i);
		//System.out.println("j = " + AtomicIntegerTest.j.get());
	}
	
}

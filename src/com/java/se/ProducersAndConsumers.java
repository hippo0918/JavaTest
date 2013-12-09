package com.java.se;

import java.util.Arrays;

/*
生产者消费者问题
*/
public class ProducersAndConsumers {
	public static void main(String[] args) {
		Basket basket = new Basket();
		Thread p = new Thread(new Producers(basket));
		Thread c1 = new Thread(new Consumers(basket));
		Thread c2 = new Thread(new Consumers(basket));
		p.start();
		c1.start();
		c2.start();
	}
}

class Bread {
	public int id = 0;
	
	public Bread(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
class Basket {
	public Bread[] breads = new Bread[0];
	
	/*
	拿包子
	*/
	public synchronized Bread pop() {
		if(breads.length == 0) {
			this.notify();
			try {
 				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Bread b = breads[breads.length - 1];
		breads = Arrays.copyOf(breads, breads.length - 1);
		System.out.println("Poping Bread's id is " + b.getId());
		return b;
	}
	
	/*
	放包子
	*/
	public synchronized void push(Bread b) {
		if(breads.length == 20) {
			this.notify();
			try {
 				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int oldSize = breads.length;
		breads = Arrays.copyOf(breads, oldSize + 1);
		breads[oldSize] = b;
		System.out.println("Pushing Bread's id is " + b.getId());
	}
}

class Producers implements Runnable {
	private Basket basket;
	public Producers(Basket b) {
		this.basket = b;
	}
	
	public void run() {
		int i = 1;
		while(System.currentTimeMillis() < (System.currentTimeMillis() + 1000 * 10L)) {
			Bread b = new Bread(i);
			basket.push(b);
			i++;
		}
	}
}

class Consumers implements Runnable {
	private Basket basket;
	public Consumers(Basket b) {
		this.basket = b;
	}
	
	public void run() {
		while(System.currentTimeMillis() < (System.currentTimeMillis() + 1000 * 10L)) {
			basket.pop();
		}
	}
}


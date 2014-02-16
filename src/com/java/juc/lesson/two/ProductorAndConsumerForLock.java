package com.java.juc.lesson.two;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorAndConsumerForLock {

	public static void main(String[] args) {
		Basket b = new Basket();
		new Thread(new Productor(b)).start();
		new Thread(new Productor(b)).start();
		new Thread(new Productor(b)).start();
		new Thread(new Consumer(b)).start();
		new Thread(new Consumer(b)).start();
	}
	
}

class Bread {
	private static AtomicInteger id = new AtomicInteger(0);
	public Bread() {
		id.addAndGet(1);
	}
	public AtomicInteger getId() {
		return id;
	}

	public void setId(AtomicInteger id) {
		this.id = id;
	}
}

class Basket {
	private int maxSize = 10;
	private List<Bread> breads = new ArrayList<Bread>(maxSize);
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
	
	//取包子
	public Bread push() {
		Bread bread = null;
		try {
			lock.lock();
			while(breads.size() == 0) {
				condition.await();
			}
			bread = breads.get(breads.size() - 1);
			System.out.println(Thread.currentThread().getName() + "【取出】包子id=" + bread.getId().get());
			condition.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return bread;
	}
	
	//放包子
	public void pop(Bread bread) {
		try {
			lock.lock();
			while(breads.size() == maxSize) {
				condition.await();
			}
			breads.add(bread);
			System.out.println(Thread.currentThread().getName() + "【放入】包子id=" + bread.getId());
			condition.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	} 
	
}

class Productor implements Runnable {
	private Basket basket;
	
	public Productor(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		while(System.currentTimeMillis() < (System.currentTimeMillis() + 1000 * 10L)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Bread b = new Bread();
			basket.pop(b);
		}
	}
}

class Consumer implements Runnable {
	private Basket basket;
	
	public Consumer(Basket basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		while(System.currentTimeMillis() < (System.currentTimeMillis() + 1000 * 10L)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			basket.push();
		}
	}
}
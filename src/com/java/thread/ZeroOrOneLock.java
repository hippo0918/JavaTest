package com.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ZeroOrOneLock implements ZeroOrOne {

	private static int num = 1;
	private Lock lock = new ReentrantLock(); 
	//private Condition conditionZero = lock.newCondition();
	private Condition conditionOne = lock.newCondition();
	
	public void increase() {
		lock.lock();
		try {
			while(num == 1) {
				conditionOne.await();
			}
			num++;
			System.out.println(Thread.currentThread().getName() + " is increasing, num++,num=" + num);
			conditionOne.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void decrease() {
		lock.lock();
		try {
			while(num == 0) {
				conditionOne.await();
			}
			num--;
			System.out.println(Thread.currentThread().getName() + " is decreasing, num--,num=" + num);
			conditionOne.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}


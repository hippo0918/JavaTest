package com.java.thread;

public class ZeroOrOneSynchronized implements ZeroOrOne {

	private static int num = 1;
	
	public synchronized void increase() {
		try {
			while(num == 1) {
				this.wait();
			}
			num++;
			System.out.println(Thread.currentThread().getName() + " is increasing, num++,num=" + num);
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void decrease() {
		try {
			while(num == 0) {
				this.wait();
			}
			num--;
			System.out.println(Thread.currentThread().getName() + " is decreasing, num--,num=" + num);
			this.notify();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}




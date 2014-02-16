package com.java.juc.lesson.three;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account implements Comparable<Account> {

	private int balance;
	public final Lock monitor = new ReentrantLock();
	
	public Account(final int initialBalance) {
		this.balance = initialBalance;
	}
	
	@Override
	public int compareTo(Account o) {
		return new Integer(hashCode()).compareTo(o.hashCode());
	}
	
	public void deposit(final int amount) {
		monitor.lock();
		try {
			if(amount > 0) {
				balance += amount;
			}
		} finally {
			monitor.unlock();
		}
	}

	public boolean withdraw(final int amount) {
		try {
			monitor.lock();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(amount >0 && balance >= amount) {
				balance -= amount;
				return true;
			}
			return false;
		} finally {
			monitor.unlock();
		}
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}

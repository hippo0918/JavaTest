package com.java.juc.lesson.three;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AccountService {

	public boolean transfer(final Account from, final Account to,
			final int amount) throws Exception {
		final Account[] accounts = new Account[] { from, to };
		Arrays.sort(accounts);
		if (accounts[0].monitor.tryLock(20, TimeUnit.SECONDS)) {
			try {
				while (accounts[1].monitor.tryLock(20, TimeUnit.SECONDS)) {
					try {
						if (from.withdraw(amount)) {
							to.deposit(amount);
							return true;
						} 
						return false;
					} finally {
						accounts[1].monitor.unlock();
					}
				}
			} finally {
				accounts[0].monitor.unlock();
			}
		}
		throw new Exception("没有可用锁");
	}
	
	public static void main(String[] args) {
		final AccountService as = new AccountService();
		final Account from = new Account(1000);
		final Account to = new Account(800);
		for(int i=0; i<5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						as.transfer(from, to, 200);
						System.out.println("取钱：" + from.getBalance());
						System.out.println("取钱：" + to.getBalance());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						as.transfer(to, from, 200);
						System.out.println("收钱：" + from.getBalance());
						System.out.println("收钱：" + to.getBalance());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}).start();
			System.out.println("最终：" + from.getBalance());
			System.out.println("最终：" + to.getBalance());
		}
	}
}

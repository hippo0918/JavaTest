package com.java.thread;

class CalculatorIncrease implements Runnable {
	private ZeroOrOne zo;

	CalculatorIncrease(ZeroOrOne zo) {
		this.zo = zo;
	}
	
	@Override
	public void run() {
		int i = 10000;
		while(i > 0) {
			zo.increase();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
		}
	}
}
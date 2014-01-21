package com.java.thread;
class CalculatorDecrease implements Runnable {
	private ZeroOrOne zo;

	CalculatorDecrease(ZeroOrOne zo) {
		this.zo = zo;
	}
	
	@Override
	public void run() {
		int i = 10000;
		while(i > 0) {
			zo.decrease();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i--;
		}
	}
	
}
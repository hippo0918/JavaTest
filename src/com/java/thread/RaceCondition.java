package com.java.thread;

public class RaceCondition {

	private static boolean done;
	
	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while(!done) {
					i++;
				}
				System.out.println("Done!");
			}
			
		}).start();
		
		System.out.println("OS:" + System.getProperty("os.name"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		done = true;
		System.out.println("flag done set to true");
	}
}

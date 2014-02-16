package com.java.juc.lesson.two;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * 使用CountDoenLatch
 * 
 * */
public class CalculateTotalForStandarByCountDownLatch {

	private ExecutorService service;
	final private AtomicLong pendingFileVisits = new AtomicLong();
	final private AtomicLong totalSize = new AtomicLong();
	final private CountDownLatch latch = new CountDownLatch(1);
	
	public void updateTotalSizeOfFilesInDir(final File file) {
		long fileSize = 0;
		if(file.isFile()) {
			fileSize = file.length();
		} else {
			File[] children = file.listFiles();
			if(children != null) {
				for(final File child : children) {
					if(child.isFile()) {
						fileSize += child.length();
					} else {
						pendingFileVisits.incrementAndGet();
						service.execute(new Runnable() {
							public void run() {
								updateTotalSizeOfFilesInDir(child);
							}
						});
					}
				}
			}
		}
		totalSize.addAndGet(fileSize);
		if(pendingFileVisits.decrementAndGet() == 0) {
			latch.countDown();
		}
	}
	
	
	private long getTotalSizeOfFile(final String fileName) throws InterruptedException {
		try {
			service = Executors.newFixedThreadPool(100);
			pendingFileVisits.incrementAndGet();
			updateTotalSizeOfFilesInDir(new File(fileName));
			latch.await(100, TimeUnit.SECONDS);
			return totalSize.longValue();
		} finally {
			service.shutdown();
		}
	}
	
	public static void main(String[] args) {
		final long start = System.nanoTime();
		long total = 0;
		try {
			total = new CalculateTotalForStandarByCountDownLatch().getTotalSizeOfFile("e://MyEclipseWorkSpace");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final long end = System.nanoTime();
		System.out.println("文件总大小：" + (total/1024/1024) + "M");
		double time = (end - start)/1.0e9;
		System.out.println("总耗时：" + time);
	}
}

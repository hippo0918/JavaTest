package com.java.juc.lesson.two;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CalculateTotalForMutiplThread {

	public static final String LINE = "--";
	public static void main(String[] args) {
		File file = new File("e://MyEclipseWorkSpace");
		System.out.println(file.length());
		//forEachFile(file, LINE);
		//calculateTime(file);
	}
	
	/*遍历文件目录*/
	public static long forEachFile(File file, String line) {
		long fileSize = 0;
		System.out.print(line);
		System.out.println(file.getName());
		if(file.isFile()) {
			return file.length();
		} 
		for(File _file : file.listFiles()) {
			fileSize += forEachFile(_file, line + LINE);
		}
		return fileSize;
	}
	
	public static double calculateTime(File file) {
		long start = System.nanoTime();
		try {
			System.out.println("文件总大小：" + (new CalculateTotalForMutiplThread().getTotalSizeOfFile(file)/1024/1024) + "M");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.nanoTime();
		double time = (end - start)/1.0e9;
		System.out.println("总耗时：" + time);
		return time;
	} 
	
	private long getTotalSizeOfFilesDir(final ExecutorService service, final File file) throws InterruptedException, ExecutionException, TimeoutException {
		long total = 0;
		if(file.isFile()) return file.length();
		final File[] children = file.listFiles();
		
		if(null != children) {
			final List<Future<Long>> results = new ArrayList<Future<Long>>();
			for(final File child : children) {
				//每一个子目录都会新建一个线程，但是你的线程池里面只有100条线程。。。没有可用线程调度了。
				results.add(service.submit(new Callable<Long>() {
					@Override
					public Long call() throws Exception {
						return getTotalSizeOfFilesDir(service, child);
					}
					
				}));
			}
			for(final Future<Long> result : results) {
				total += result.get(20, TimeUnit.SECONDS);
			}
		}
		
		return total;
	}
	
	private long getTotalSizeOfFile(final File file) throws InterruptedException, ExecutionException, TimeoutException {
		final ExecutorService service = Executors.newFixedThreadPool(100);
		try {
			return getTotalSizeOfFilesDir(service, file);
		} finally {
			service.shutdown();
		}
	}
}

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

/**
 * 设计很巧妙
 * 
 * 
 * */
public class CalculateTotalForStandar {

	class SubDirAndSize {
		final public long size;
		final public List<File> subDirs;
		
		public SubDirAndSize(final long totalSize, List<File> subDirs) {
			this.size = totalSize;
			this.subDirs = subDirs;
		}
	}
	
	private SubDirAndSize getTotalAndSunDir(final File file) {
		long total = 0;
		final List<File> subDirs = new ArrayList<File>();
		if(file.isDirectory()) {
			final File[] children = file.listFiles();
			if(children != null) {
				for(final File child : children) {
					if(child.isFile()) {
						total += child.length();
					} else {
						subDirs.add(child);
					}
				}
			}
		}
		return new SubDirAndSize(total, subDirs);
	}
	
	private long getTotalSizeOfFileInDir(final File file) throws InterruptedException, ExecutionException, TimeoutException {
		final ExecutorService service = Executors.newFixedThreadPool(100);
		try {
			long total = 0;
			final List<File> dirs = new ArrayList<File>();
			dirs.add(file);
			while(!dirs.isEmpty()) {
				final List<Future<SubDirAndSize>> results = new ArrayList<Future<SubDirAndSize>>();
				for(final File dir : dirs) {
					results.add(service.submit(new Callable<SubDirAndSize>() {
						@Override
						public SubDirAndSize call() throws Exception {
							return getTotalAndSunDir(dir);
						}
					}));
				}
				dirs.clear();
				for(final Future<SubDirAndSize> result : results) {
					final SubDirAndSize s = result.get(20, TimeUnit.SECONDS);
					dirs.addAll(s.subDirs);
					total += s.size;
				}
			}
			return total;
		} finally {
			service.shutdown();
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		final long start = System.nanoTime();
		final long total = new CalculateTotalForStandar().getTotalSizeOfFileInDir(new File("e://MyEclipseWorkSpace"));
		final long end = System.nanoTime();
		System.out.println("文件总大小：" + (total/1024/1024) + "M");
		double time = (end - start)/1.0e9;
		System.out.println("总耗时：" + time);
	}
}

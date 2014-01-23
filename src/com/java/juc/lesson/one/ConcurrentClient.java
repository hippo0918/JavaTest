package com.java.juc.lesson.one;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentClient extends AbstractBroad {

	private ExecutorService executorPool;
	
	public ConcurrentClient() {
		//假设这里的阻塞系数是0.1
		//Runtime.getRuntime().availableProcessors();
		executorPool = Executors.newFixedThreadPool(40);
	}
	
	@Override
	public double calculate() throws IOException, InterruptedException {
		List<Callable<Double>> assigment = new ArrayList<Callable<Double>>();
		double value = 0;
		Map<String, Double> stocks = getGuPiaos();
		Set<Entry<String, Double>> entrySet = stocks.entrySet();
		Iterator<Entry<String, Double>> i = entrySet.iterator();
		long start = System.nanoTime();
		while(i.hasNext()) {
			final Entry<String, Double> entry = i.next();
			assigment.add(new Callable<Double>() {
				@Override
				public Double call() throws Exception {
					// TODO Auto-generated method stub
					return entry.getValue() * YahooFinace.getPrice(entry.getKey());
				}
				
			});
		}
		List<Future<Double>> results = executorPool.invokeAll(assigment);
		if(results != null) {
			for(Future<Double> result : results) {
				try {
					value = value + result.get();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		long end = System.nanoTime();
		executorPool.shutdown();
		System.out.println("总耗时:" + (end - start)/1.0e9);
		System.out.println("总价值:" + new DecimalFormat("$##,##0.00").format(value));
		return value;
	}

	public static void main(String[] args) {
		try {
			//总耗时:6.016939851
			//总价值:$24,128,723.98
			new ConcurrentClient().calculate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

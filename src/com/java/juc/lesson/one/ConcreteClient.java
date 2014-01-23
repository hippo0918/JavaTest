package com.java.juc.lesson.one;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ConcreteClient extends AbstractBroad {

	@Override
	public double calculate() throws IOException {
		double value = 0;
		Map<String, Double> stocks = getGuPiaos();
		Set<Entry<String, Double>> entrySet = stocks.entrySet();
		Iterator<Entry<String, Double>> i = entrySet.iterator();
		long start = System.nanoTime();
		while(i.hasNext()) {
			Entry<String, Double> entry = i.next();
			value = value + entry.getValue() * YahooFinace.getPrice(entry.getKey());
		}
		long end = System.nanoTime();
		System.out.println("总耗时:" + (end - start)/1.0e9);
		System.out.println("总价值:" + new DecimalFormat("$##,##0.00").format(value));
		return value;
	}

	public static void main(String[] args) {
		try {
			//总耗时:73.591915289
			//总价值:$24,128,723.98
			new ConcreteClient().calculate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

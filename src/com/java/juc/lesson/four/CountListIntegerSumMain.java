package com.java.juc.lesson.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 计算List中所有整数的和测试类
 * @author 飞雪无情
 * @since 2010-7-12
 */
public class CountListIntegerSumMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int threadCounts = 10;//采用的线程数
		//生成的List数据
		for (int i = 1; i <= 1000000; i++) {
			list.add(i);
		}
		long sum=CountListIntegerSum.getIntegerSum(list, threadCounts);
		System.out.println("List中所有整数的和为:"+sum);
	}

}
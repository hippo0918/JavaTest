package com.java.juc.lesson.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class YahooFinace {

	public static double getPrice(final String ticket) throws IOException {
		final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticket);
		BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		String discardHeader = reader.readLine();
		System.out.println("header : " + discardHeader);
		String data = reader.readLine();
		System.out.println("data : " + data);
		String[] dataItems = data.split(",");
		double price = Double.valueOf(dataItems[dataItems.length - 1]);
		return price;
	}
	
	public static void main(String[] args) {
		try {
			//获取最后一个收盘价
			System.out.println(getPrice("MS"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.java.juc.lesson.one;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBroad {

	private Map<String, Double> guPiaos = new HashMap<String, Double>();

	public Map<String, Double> getGuPiaos() {
		//获取此用户拥有的股票
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("d://temp/stocks.txt")));
			String str = null;
			while((str = br.readLine()) != null) {
				if(str.indexOf(",") != -1) {
					String[] stock = str.split(",");
					guPiaos.put(stock[0], Double.parseDouble(stock[1]));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guPiaos;
	}

	public void setGuPiaos(Map<String, Double> guPiaos) {
		this.guPiaos = guPiaos;
	}
	
	public abstract double calculate() throws IOException, InterruptedException;
	
}

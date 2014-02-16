package com.java.juc.lesson.two;

import java.io.File;
import java.util.concurrent.Executors;

public class CalculateTotalFile {

	public static final String LINE = "--";
	public static void main(String[] args) {
		File file = new File("e://MyEclipseWorkSpace");
		//forEachFile(file, LINE);
		calculateTime(file);
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
		System.out.println("文件总大小：" + (forEachFile(file, LINE)/1024/1024) + "M");
		long end = System.nanoTime();
		double time = (end - start)/1.0e9;
		System.out.println("总耗时：" + time);
		return time;
	} 
}

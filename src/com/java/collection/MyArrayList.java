package com.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<E> {

	
	private transient Object[] elementData = null;
	private int size;
	
	public MyArrayList() {
		size = 10;
		elementData = new Object[size];
	}
	
	public MyArrayList(int size) throws Exception{
		if(size < 0) {
			throw new Exception("集合初始化异常,不合法长度" + size);
		} else {
			this.size = size;
			elementData = new Object[size];
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add(null);
		list.add(null);
		list.add("");
		list.trimToSize();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		Object[] objects = new Object[10];
		for(int i=0; i<objects.length; i++) {
			objects[i] = "" + i;
		}
		objects = Arrays.copyOf(objects, 20);//这个可以扩展数组长度
		System.out.println(objects.length);
		for(int i=0; i<objects.length; i++) {
			System.out.println(objects[i]);
		}
		
		System.out.println("********************************************");
	}
	
	public boolean add(E e) {
		boolean flag = false;
		ensureAdd(elementData.length);
		elementData[size++] = e;
		return flag;
	}
	
	private void ensureAdd(int oldSize) {
		if(oldSize > elementData.length) {
			int newLength = (elementData.length/2) * 3;
			elementData = Arrays.copyOf(elementData, newLength);
		}
	}
	
}

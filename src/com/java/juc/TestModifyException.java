package com.java.juc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestModifyException {
	private final List<String> l = new ArrayList<String>();
	public static void main(String[] args) {
		TestModifyException t = new TestModifyException();
		t.l.add("a");
		t.l.add("a");
		t.l.add("a");
		t.l.add("a");
		t.l.add("a");
		t.l.add("a");
		t.l.add("a");
		t.l.add("a");
		t.l.add("a");
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		Iterator<String> i = list.iterator();
		while(i.hasNext()) {
			String str = i.next();
			//if(str.equals("a")) {
				//if(str.equals("b")) {
					//if(str.equals("c")) {
						//if(str.equals("d")) {
							if(str.equals("e")) {
				list.remove(str);
			} else {
				System.out.println("元素：" + str);
			}
		}
	}
}

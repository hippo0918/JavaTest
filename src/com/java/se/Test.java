package com.java.se;

import java.io.Serializable;

import com.java.se.list.DefinitionList;
import com.java.se.list.LizebinLinkedList;



public class Test {
	public static void main(String[] args) {
		// DefinitionList<String> list = new LizebinList<String>();
		// list.add("li");
		// list.add("ze");
		// list.add("bin");
		// list.set(0, "LinXiangJun");
		// list.add(3, "lin");
		// list.set(0, "xiangjun");
		// System.out.println(list.size());
		// printList(list);
		// list.clear();
		DefinitionList<String> list =  new LizebinLinkedList<String>();
		list.add("li");
		list.add("ze");
		list.add("bin");
		list.add("bin1");
		list.add("bin2");
		list.add("bin3");
		list.add("bin4");
		list.add("bin5");
		list.add("bin6");
		list.add("bin7");
		
		list.add(1, "bin0.1");
		list.add(2, "bin0.2");
		list.add(3, "bin0.3");
		list.add(13, "bin7.1");
		
		System.out.println("list.size = " + list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	public static void printList(DefinitionList<?> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void t(Serializable... ids) {
		for(Serializable id :ids) {
			System.out.println(id);
		}
	}
}
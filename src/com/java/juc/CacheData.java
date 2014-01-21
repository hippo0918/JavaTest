package com.java.juc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheData {
	private CacheData() {}
	private static CacheData cacheData = new CacheData();
	public static Map<String, String> map = new HashMap<String, String>();
	
	ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public static CacheData getInstance() {
		if(cacheData == null) {
			cacheData = new CacheData();
		}
		return cacheData;
	}
	
	
	static {
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		map.put("d", "d");
		map.put("e", "e");
		map.put("f", "f");
	}
	
	//防止出现Null
	public String getValue(String key) {
		lock.readLock().lock();
		String value = map.get(key);
		try {
			if (value == null) {
				lock.readLock().unlock();
				lock.writeLock().lock();
				try {
					if (value == null) {
						value = "The value is nothing! The time is " + System.currentTimeMillis();
					}
				} finally {
					lock.writeLock().unlock();
					lock.readLock().lock();
				}
			}
		} finally {
			lock.readLock().unlock();
		}
		return value;
	} 
	
	public static void main(String[] args) {
		new Thread(new Test()).start();
		new Thread(new Test()).start();
		new Thread(new Test()).start();
		new Thread(new Test()).start();
		new Thread(new Test()).start();
		new Thread(new Test()).start();
	}
	
}

class Test implements Runnable {

	@Override
	public void run() {
		Set<String> set = new HashSet<String>();
		set.add("s");
		set.add("q");
		set.add("p");
		set.add("l");
		set.add("z");
		set.add("y");
		set.add("x");
		set.add("a");
		set.add("b");
		set.add("c");
		set.add("d");
		set.add("e");
		while(set.size() != 0) {
			Iterator<String> i = set.iterator();
			while(i.hasNext()) {
				System.out.println(CacheData.getInstance().getValue(i.next()));
				i.remove();
			}
		}
	}
	
}
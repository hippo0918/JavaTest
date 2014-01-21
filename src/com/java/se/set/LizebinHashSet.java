package com.java.se.set;

import com.java.se.map.LizebinHashMap20140106;

public class LizebinHashSet<E> implements DefinitionSet<E> {

	private LizebinHashMap20140106<E, Object> map = new LizebinHashMap20140106<E, Object>();
	
	private final Object PERSISTENT_VALUE = new Object();
	
	private int size = 0;
	
	@Override
	public boolean add(E e) {
		if(!map.containsKey(e)) {
			map.put(e, PERSISTENT_VALUE);
			size++;
			return true;
		} 
		return false;
	}

	@Override
	public E remove(E e) {
		E old = null;
		if(map.containsKey(e)) {
			old = (E)map.remove(e);
			size--;
		}
		return old;
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return map.containsKey(e);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public void clear() {
		map.clear();
	}

}

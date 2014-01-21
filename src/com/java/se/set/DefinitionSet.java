package com.java.se.set;

public interface DefinitionSet<E> {

	boolean add(E e);
	
	E remove(E e);
	
	boolean contains(E e);
	
	int size();
	
	boolean isEmpty();
	
	void clear();
	
}

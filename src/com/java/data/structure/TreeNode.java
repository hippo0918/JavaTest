package com.java.data.structure;
public class TreeNode<T> {
	
	private TreeNode<T> leftTreeNode;
	private TreeNode<T> rightTreeNode;
	private T nodeValue;
	
	TreeNode() {
		this(null, null, null);
	}
	
	TreeNode(T nodeValue) {
		this(null, nodeValue, null);
	}
	
	TreeNode(TreeNode<T> leftTreeNode, T nodeValue, TreeNode<T> rightTreeNode) {
		this.leftTreeNode = leftTreeNode;
		this.rightTreeNode = rightTreeNode;
		this.nodeValue = nodeValue;
	}
	
	public TreeNode<T> getLeftTreeNode() {
		return leftTreeNode;
	}
	
	public void setLeftTreeNode(TreeNode<T> leftTreeNode) {
		this.leftTreeNode = leftTreeNode;
	}
	
	
	public TreeNode<T> getRightLeftNode() {
		return rightTreeNode;
	}
	
	public void setRightTreeNode(TreeNode<T> rightTreeNode) {
		this.rightTreeNode = rightTreeNode;
	}
	
	public T getNodeValue() {
		return nodeValue;
	}
	
	public void setNodeValue(T nodeValue) {
		this.nodeValue = nodeValue;
	}
	
	public String toString() {
		return "";
	}
	
	public static void main(String[] args) {
		TreeNode<String> a = new TreeNode<String>("A");
		TreeNode<String> b = new TreeNode<String>("B");
		TreeNode<String> c = new TreeNode<String>("C");
		TreeNode<String> d = new TreeNode<String>("D");
		TreeNode<String> e = new TreeNode<String>("E");
		TreeNode<String> f = new TreeNode<String>("F");
		TreeNode<String> g = new TreeNode<String>("G");
		//TreeNode<String> h = new TreeNode<String>("H");
		
		a.setLeftTreeNode(b);
		a.setRightTreeNode(c);
		b.setLeftTreeNode(d);
		b.setRightTreeNode(e);
		c.setLeftTreeNode(f);
		c.setRightTreeNode(g);
		
		System.out.println();
		
	}
}
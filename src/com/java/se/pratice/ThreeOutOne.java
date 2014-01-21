package com.java.se.pratice;

import java.util.Arrays;

/**
 * 数三退一：500个编号的小朋友左手牵右手围成一圈，数三下，每数到第三个，就退出。直到最后一个小孩的编号是多少？
 * */
public class ThreeOutOne {

	private static Kid[] kids;
	
	private static final int size = 500;
	
	static {
		kids = new Kid[size];
		for(int i=0; i<size; i++) {
			Kid kid = new Kid();
			kid.id = i;
			kids[i] = kid;
		}
		for(int i=0; i<size; i++) {
			int left = i - 1;
			int right = i + 1;
			if(left == -1) {
				left = size - 1;
			}
			if(right == size) {
				right = 0;
			}
			kids[i].left = kids[left];
			kids[i].right = kids[right];
		}
	}
	
	public static void main(String[] args) {
		int i = threeOutOne(kids);
		System.out.println(i);
	}
	
	private static int threeOutOne(Kid[] kids) {
		int count = 1;
		Kid kid = kids[0];
		while(kid != null && kid.left != kid && kid.right != kid) {
			if(count == 3) {
				System.out.println(kid);
				kid.right.left = kid.left;
				kid.left.right = kid.right;
				count = 0;
			}
			kid = kid.right;
			count++;
		}
		return kid.id;
	}
	
	static class Kid {
		Kid right;
		Kid left;
		int id;
		
		public Kid() {}
		
		public Kid(int id, Kid left, Kid right) {
			this.id = id;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{id : "+id+",right:"+right.id+",left:"+left.id+"}";
		}
	}
}

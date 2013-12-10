package com.java.se;

import java.util.ArrayList;
import java.util.List;



/**
 * �����У����ܷŶ��ٸ��ʺ�
 * 
 * */
public class NQueuen {

	//����취������
	private int solutionsCount = 0;
	//��������
	private int row = 0;
	//����
	private boolean[][] board = null;
	//�ʺ�����
	private int queuenCount = 0;
	
	public NQueuen(int size) {
		row = size;
		board = new boolean[size][size];
	}

	public void soleNQueuen(int y) {
		if (y == 8)
			return;// ����8�����˳�
		for (int i = 0; i < row; i++) {
			if (!checkColomn(i,y) && !checkLine(i, y)) {
				board[i][y] = true;
				queuenCount++;
				if (queuenCount == 8) {
					printQueuen(board);// �ڷŻʺ�8�����ӡ���
					board[i][y] = false;// �ٴ�Ѱ���������
					queuenCount--;
					continue;
				}
				soleNQueuen(y + 1);// �ݹ�
				board[i][y] = false;
				queuenCount--;
			}
		}
		return;

	}
	
	//�������Ƿ��лʺ�
	public boolean checkColomn(int x, int y) {
		for(int i=0; i<row; i++) {
			if(board[x][i]) {
				return true;
			}
			if(board[i][y]) {
				return true;
			}
		}
		return false;
	}
	
	//���б���Ƿ��лʺ�
	public boolean checkLine(int x, int y) {
		int i=0,j=0;
		for(i=x, j=y; i<row && j <row; i++,j++) {
			if(board[i][j]) {
				return true;
			}
		}
		for(i=x,j=y; i<row && j>=0; i++,j--) {
			if(board[i][j]) {
				return true;
			}
		}
		for(i=x,j=y; i>=0 && j>=0; i--,j--) {
			if(board[i][j]) {
				return true;
			}
		}
		for(i=x,j=y; i>=0 && j<row; i--,j++) {
			if(board[i][j]) {
				return true;
			}
		}
		return false;
	}
	
	//�Żʺ�
	public void put(int i, int j) {
		solutionsCount++;
		board[i][j] = true;
	}
	
	public void printQueuen(boolean[][] board) {
		solutionsCount++;
		System.out.println("*******************��"+solutionsCount+"��*****************");
		for(int i=0; i<row; i++) {
			for(int j=0; j<row; j++) {
				if(!board[i][j]) {
					System.out.print(" �� ");
				} else {
					System.out.print(" * ");
				}
				if(j == row - 1) {
					System.out.println("");
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {  
		NQueuen q = new NQueuen(8);
		q.soleNQueuen(0);
    }   

}

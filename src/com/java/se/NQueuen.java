package com.java.se;

import java.util.ArrayList;
import java.util.List;



/**
 * 多少列，就能放多少个皇后
 * 
 * */
public class NQueuen {

	//解决办法的总数
	private int solutionsCount = 0;
	//棋盘列数
	private int row = 0;
	//棋盘
	private boolean[][] board = null;
	//皇后总数
	private int queuenCount = 0;
	
	public NQueuen(int size) {
		row = size;
		board = new boolean[size][size];
	}

	public void soleNQueuen(int y) {
		if (y == 8)
			return;// 超过8行则退出
		for (int i = 0; i < row; i++) {
			if (!checkColomn(i,y) && !checkLine(i, y)) {
				board[i][y] = true;
				queuenCount++;
				if (queuenCount == 8) {
					printQueuen(board);// 摆放皇后8个则打印结果
					board[i][y] = false;// 再次寻找其他情况
					queuenCount--;
					continue;
				}
				soleNQueuen(y + 1);// 递归
				board[i][y] = false;
				queuenCount--;
			}
		}
		return;

	}
	
	//检查此行是否有皇后
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
	
	//检查斜边是否有皇后
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
	
	//放皇后
	public void put(int i, int j) {
		solutionsCount++;
		board[i][j] = true;
	}
	
	public void printQueuen(boolean[][] board) {
		solutionsCount++;
		System.out.println("*******************第"+solutionsCount+"种*****************");
		for(int i=0; i<row; i++) {
			for(int j=0; j<row; j++) {
				if(!board[i][j]) {
					System.out.print(" ○ ");
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

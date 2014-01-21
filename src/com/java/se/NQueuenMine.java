package com.java.se;




/**
 * 多少列，就能放多少个皇后
 * 
 * */
public class NQueuenMine {

	//解决办法的总数
	private int solutionsCount = 0;
	//棋盘列数
	private int row = 0;
	//棋盘
	private boolean[][] board = null;
	//已皇后数
	private int queueCount = 0;
	
	public NQueuenMine(int size) {
		row = size;
		board = new boolean[size][size];
	}

	public void soleNQueuen(int x) {
		testPrint(board);
		if (x == row)
			return;// 超过8行则退出
		for (int y = 0; y < row; y++) {
			if(!checkColomn(x, y) && !checkLine(x, y)) {
				queueCount++;
				board[x][y] = true;
				if(queueCount == row) {
					printQueuen(board);
				}
				soleNQueuen(x + 1);
				board[x][y] = false;
				queueCount--;
				continue;
			}
		}
		//return;

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
	
	public void testPrint(boolean[][] board) {
		System.out.println("*******************测试*****************");
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
		NQueuenMine q = new NQueuenMine(8);
		q.soleNQueuen(0);
    }   

}

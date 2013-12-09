package com.java.se;


import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 以一个7×9的长方阵表示迷宫，0和1分别表示迷宫中的通路和障碍。设计一个程序，对任意设定的迷宫，求出一条从入口到出口的通路，或得出没有通路的结论。
 * 
 * 迷宫:入口(0,0);出口(6,8):
 * ****************************************
 * * * 0 1 2 3 4 5 6 7 8
 * ****************************************
 * 0 * 0 1 1 0 0 1 1 1 1
 * 1 * 0 0 1 0 1 0 0 0 1
 * 2 * 1 0 1 0 0 1 0 1 1
 * 3 * 1 0 1 1 0 1 0 1 1
 * 4 * 1 0 0 0 0 0 0 1 1
 * 5 * 1 0 1 0 1 1 0 0 1
 * 6 * 1 0 1 1 1 1 1 0 0
 * 
 * 
 * */
public class MNMaze {
	List<Point> putedPoints = new ArrayList<Point>();
	//迷宫数组
	public int[][] maze = null;
	
	//行数
	public int rowSize = 7;
	//列数
	public int columnSize = 9;
	//入口
	public Point enterPoint = new Point();
	//出口
	public Point outPoint = new Point();
	
	public static void main(String[] args) {
		MNMaze m = new MNMaze();
		/*Point startPoint = new Point();
		startPoint.setX(0);
		startPoint.setY(0);
		startPoint.setLastPoint(startPoint);
		m.go(startPoint);*/
		m.test();
		
	}
	public MNMaze() {
		maze = new int[rowSize][columnSize];
		maze[0][1] = 1;
		maze[0][2] = 1;
		maze[0][5] = 1;
		maze[0][6] = 1;
		maze[0][7] = 1;
		maze[0][8] = 1;
		maze[1][2] = 1;
		maze[1][4] = 1;
		maze[1][8] = 1;
		maze[2][0] = 1;
		maze[2][2] = 1;
		maze[2][5] = 1;
		maze[2][7] = 1;
		maze[2][8] = 1;
		maze[3][0] = 1;
		maze[3][2] = 1;
		maze[3][3] = 1;
		maze[3][5] = 1;
		maze[3][7] = 1;
		maze[3][8] = 1;
		maze[4][8] = 1;
		maze[4][0] = 1;
		maze[4][7] = 1;
		maze[5][0] = 1;
		maze[5][2] = 1;
		maze[5][4] = 1;
		maze[5][5] = 1;
		maze[5][8] = 1;
		maze[6][0] = 1;
		maze[6][2] = 1;
		maze[6][3] = 1;
		maze[6][4] = 1;
		maze[6][5] = 1;
		maze[6][6] = 1;
		outPoint.setX(6);
		outPoint.setY(8);
		System.out.println("**************************初始化棋盘*******************************");
		printPoint(maze, putedPoints);
	}
	
	//所在位置
	public void go(Point enterPoint) {
System.out.println("enterPoint" + enterPoint);
		while(enterPoint != null) {
			if(enterPoint.getX() == rowSize && enterPoint.getY() == columnSize) {
				System.out.println("***************************答案：***************************");
				printPoint(maze, putedPoints);
				return;
			}
			Point nextPoint = nextPoint(enterPoint);
			if(nextPoint != null) {
				putedPoints.add(enterPoint);
			} else {
				return;
			}
			go(nextPoint);
			putedPoints.remove(putedPoints.size() - 1);
			nextPoint = putedPoints.get(putedPoints.size() - 2);
			continue;
		}
		
	}
	
	public void removePointFromPutPoints(Point p) {
		for(int i=0; i<putedPoints.size(); i++) {
			Point _p = putedPoints.get(i);
			if(_p.getX() == p.getX() && _p.getY() == p.getY()) {
				putedPoints.remove(i);
			}
		}
	}
	//是否有下一个
	public Point nextPoint(Point nowPoint) {
		Point nextPoint = new Point();
		nextPoint.setLastPoint(nowPoint);
		int nowX = nowPoint.getX();
		int nowY = nowPoint.getY();
		if(nowY != 0 && maze[nowX][nowY-1] == 0 && nowY-1 != nowPoint.getLastPoint().getY()) {
			nextPoint.setX(nowX);
			nextPoint.setY(nowY-1);
			if(!isInPutPoints(nextPoint)) {
				return nextPoint;
			}
		}
		if(nowX < rowSize-1 && maze[nowX+1][nowY] == 0 && nowX+1 != nowPoint.getLastPoint().getX()) {
			nextPoint.setX(nowX+1);
			nextPoint.setY(nowY);
			if(!isInPutPoints(nextPoint)) {
				return nextPoint;
			}
		}
		if(nowY < columnSize-1 && maze[nowX][nowY+1] == 0 && nowY+1 != nowPoint.getLastPoint().getY()) {
			nextPoint.setX(nowX);
			nextPoint.setY(nowY+1);
			if(!isInPutPoints(nextPoint)) {
				return nextPoint;
			}
		}
		if(nowX != 0 && maze[nowX-1][nowY] == 0 && nowX-1 != nowPoint.getLastPoint().getX()) {
			nextPoint.setX(nowX-1);
			nextPoint.setY(nowY);
			if(!isInPutPoints(nextPoint)) {
				return nextPoint;
			}
		}
		return null;
	}
	
	public void test() {
		int[] a = new int[]{1,2,9,5,6,4,7,3,8};
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length-i-1; j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
	public boolean isInPutPoints(Point p) {
		Iterator<Point> iterator = putedPoints.iterator();
		while(iterator.hasNext()) {
			Point _p = iterator.next();
			if(_p.getX() == p.getX() && _p.getY() == p.getY()) {
				return true;
			}
		}
		return false;
	}
	public void printPoint(int[][] maze, List<Point> putedPoints) {
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[i].length; j++) {
				Iterator<Point> iterator = putedPoints.iterator();
				while(iterator.hasNext()) {
					Point _p = iterator.next();
					if(_p.getX() == i && _p.getY() == j) {
						maze[i][j] = 3;
					}
				}
				System.out.print(" " + maze[i][j] + " ");
				if(j == columnSize - 1) {
					System.out.println("");
				}
			}
		}
	}
}

class Point {
	private int x;
	private int y;
	private Point lastPoint;
	public Point getLastPoint() {
		return lastPoint;
	}
	public void setLastPoint(Point lastPoint) {
		this.lastPoint = lastPoint;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "坐标为("+x+","+y+")";
	}
}
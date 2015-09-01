package com.driedtoast.grid.model;

/** 
 * To remove the dependency on awt just for a point class
 * 
 * @author driedtoast
 */
public class Point {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;		
	}
}

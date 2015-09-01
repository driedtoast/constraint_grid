package com.driedtoast.grid.model;

import com.driedtoast.grid.model.Point;

public abstract class AbstractGridObject implements GridObject {

	private Point point;
	

	private int height = 1;
	private int width = 1;

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public Point position() {
		return point;
	}

	@Override
	public void setPosition(Point point) {
		this.point = point;
	}

	@Override
	public int height() {
		return height;
	}

	@Override
	public int width() {
		return width;
	}

}

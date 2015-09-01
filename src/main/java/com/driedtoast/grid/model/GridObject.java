package com.driedtoast.grid.model;

import com.driedtoast.grid.model.Point;
import java.util.List;

import com.driedtoast.grid.event.EventListener;

public interface GridObject {
	
	/**
	 * Update / reposition listeners
	 * @return
	 */
	List<EventListener> listeners();

	/**
	 * Top right corner position in the grid, starting point of the object
	 * @return Point
	 */
	Point position();
	
	/**
	 * Sets the top right point of the object
	 * @param point
	 */
	void setPosition(Point point);

	/**
	 * How many grid spaces is the height of the object
	 * @return number of squares
	 */
	int height();
	
	/**
	 * How many grid spaces is the width of the object
	 * @return number of squares
	 */
	int width();
}

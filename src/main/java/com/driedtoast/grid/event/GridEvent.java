package com.driedtoast.grid.event;

import com.driedtoast.grid.model.Point;

import com.driedtoast.grid.model.GridObject;

/**
 * Represents an event type
 * 
 * @author dmarchant
 */
public class GridEvent {

	private GridObject object;
	private Point previousPosition;
	private EventType type;
	
	public GridEvent(GridObject object, Point previousPosition, EventType type) {
		this.object = object;
		this.type = type;
		this.previousPosition = previousPosition;
	}
	
	public EventType type() {
		return type;
	}
	
	public GridObject object() {
		return object;
	}
	
	public Point previousPosition() {
		return this.previousPosition;
	}
	
}

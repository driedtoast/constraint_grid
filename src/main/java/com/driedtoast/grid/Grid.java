package com.driedtoast.grid;

import com.driedtoast.grid.model.Point;
import com.driedtoast.grid.util.CollisionException;
import com.driedtoast.grid.util.GridException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.driedtoast.grid.event.EventListener;
import com.driedtoast.grid.event.EventType;
import com.driedtoast.grid.event.GridEvent;
import com.driedtoast.grid.model.GridObject;

public class Grid {

	private GridConfig config;
	private Map<EventType, List<EventListener>> listeners;

	public Grid(GridConfig config) {
		this.config = config;
		this.listeners = new HashMap<EventType, List<EventListener>>();
	}

	/**
	 * Adds object to a grid
	 * 
	 * @param obj
	 *            - object to add to the grid
	 * @return boolean indicating addition
	 */
	public boolean add(GridObject obj) {
		boolean added = false;
		try {
			if (setObject(obj, false)) {
				notifyListeners(EventType.OBJECT_ADDED, obj, obj.position());
				added = true;
			}
		} catch (CollisionException ce) {
			// since its a silent fail, because we should never get here
			// needs to compile though
		}
		return added;
	}

	/**
	 * Set object in grid
	 * 
	 * @param obj
	 * @param collisionCheck
	 * @return true if it was added
	 */
	// TODO add height and width fill
	protected boolean setObject(GridObject obj, boolean collisionCheck) throws CollisionException {
		boolean added = false;
		Point point = obj.position();
		GridObject[] columns = config.getRow(point.y());
		GridObject current = columns[point.x()];
		if (current != null) {
			if (current == obj) {
				added = true;
			} else if (collisionCheck) {
				throw new CollisionException(current, obj);
			}
		} else {
			columns[point.x()] = obj;
			added = true;
		}
		return added;
	}

	public void move(int x, int y) {
		// TODO update view port and return
		// or return colliding images based on viewport?
	}

	// TODO add preview commit model as well?
	public void moveObject(GridObject obj, Point point) throws CollisionException {
		Point previousPosition = obj.position();
		removeObject(obj);
		obj.setPosition(point);
		if (setObject(obj, true)) {

			// Move object and notify the listeners
			GridEvent event = new GridEvent(obj, previousPosition, EventType.POSITION_CHANGE);
			List<EventListener> objListeners = obj.listeners();
			for (EventListener listener : objListeners) {
				if (listener.type() != event.type()) {
					continue;
				}
				listener.triggered(event);
			}
		}
		// TODO figure out moving and viewport changes?
	}

	public void moveObject(GridObject obj, int x, int y) throws GridException {
		moveObject(obj, new Point(x, y));
	}

	/**
	 * Remove the object from the grid
	 * 
	 * @param obj
	 *            that needs to be removed
	 */
	public void removeObject(GridObject obj) {
		// TODO add fill and such
		Point point = obj.position();
		GridObject[] columns = config.getRow(point.y());
		GridObject currentObject = columns[point.x()];
		if (currentObject == null)
			return;
		if (currentObject == obj) {
			columns[point.x()] = null;
			notifyListeners(EventType.OBJECT_REMOVED, obj, obj.position());
		}
	}

	/**
	 * Notify listeners for a given event type
	 * 
	 * @param type
	 *            - event type
	 * @param obj
	 *            - object that triggered the event
	 * @param previousPosition
	 *            - previous position if one
	 */
	protected void notifyListeners(EventType type, GridObject obj, Point previousPosition) {
		List<EventListener> eventListeners = listeners.get(type);
		if (eventListeners == null)
			return;
		GridEvent event = new GridEvent(obj, previousPosition, type);
		for (EventListener eventListener : eventListeners) {
			eventListener.triggered(event);
		}
	}

	/**
	 * Multi-dimensional array representing the view port
	 * 
	 * @param startingBlock
	 * @param endingBlock
	 * @return rows and columns
	 */
	public GridObject[][] viewPort(Point start, Point end) {
		return null;
	}

	public GridObject at(Point point) {
		return at(point.x(), point.y());

	}

	public GridObject at(int x, int y) {
		return config.getRow(y)[x];
	}

}

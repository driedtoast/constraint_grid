package com.driedtoast.grid.model;

import java.util.ArrayList;
import java.util.List;

import com.driedtoast.grid.event.EventListener;
import com.driedtoast.grid.event.EventType;
import com.driedtoast.grid.model.Point;

public abstract class AbstractGridObject implements GridObject {

	private Point point;
	

	private int height = 1;
	private int width = 1;
	
	private List<EventListener> listeners;
	protected List<EventType> supportedTypes;
	
	@Override
	public List<EventListener> listeners() {		
		return listeners;
	}

	public void addListener(EventListener listener) {
		if(supportedEventTypes().contains(listener.type())) {
			if(listeners == null) {
				listeners = new ArrayList<EventListener>();
			}
			if (!listeners.contains(listener)) listeners.add(listener);
		}
	}
	
	protected List<EventType> supportedEventTypes() {
		if (supportedTypes == null) {
			supportedTypes = new ArrayList<EventType>();
			supportedTypes.add(EventType.POSITION_CHANGE);
		}
		return supportedTypes;
	}
	
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

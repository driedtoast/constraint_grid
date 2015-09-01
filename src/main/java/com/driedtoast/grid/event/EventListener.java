package com.driedtoast.grid.event;

public interface EventListener {

	EventType type();
	
	void triggered(GridEvent event);
	
}

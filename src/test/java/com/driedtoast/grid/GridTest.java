package com.driedtoast.grid;

import java.util.List;

import com.driedtoast.grid.event.EventListener;
import com.driedtoast.grid.event.EventType;
import com.driedtoast.grid.event.GridEvent;
import com.driedtoast.grid.model.AbstractGridObject;
import com.driedtoast.grid.model.GridObject;
import com.driedtoast.grid.model.Point;

import junit.framework.TestCase;

public class GridTest extends TestCase {

	class TestEventListener implements EventListener {
		private EventType type;
		private GridEvent triggeredEvent;
		
		public TestEventListener(EventType type) {
			this.type = type;
		}
		
		@Override
		public EventType type() {
			return type;
		}

		@Override
		public void triggered(GridEvent event) {
			triggeredEvent = event;
		}
		
		public GridEvent triggeredEvent() {
			return triggeredEvent;
		}
		
	}
	
	public void testEmptyGridSetup() throws Exception {		
		GridConfig config = new GridConfig(4,4);
		Grid grid = new Grid(config);
		assertNull(grid.at(1, 1));		
	}

	
	public void testAddGridSetup() throws Exception {		
		GridConfig config = new GridConfig(4,4);
		Grid grid = new Grid(config);
		AbstractGridObject obj = new AbstractGridObject() {
		};
		obj.setPosition(new Point(0,0));
		grid.add(obj);
		assertEquals(obj, grid.at(0, 0));
	}
	
	public void testMoveObject() throws Exception {
		GridConfig config = new GridConfig(4,4);
		Grid grid = new Grid(config);
		AbstractGridObject obj = new AbstractGridObject() {
		};
		obj.setPosition(new Point(0,0));
		grid.add(obj);
		// test without listener
		grid.moveObject(obj, 3, 3);
		assertEquals(obj, grid.at(3, 3));
		
		// test with listener
		TestEventListener listener = new TestEventListener(EventType.POSITION_CHANGE);
		obj.addListener(listener);
		grid.moveObject(obj, 2, 2);
		assertEquals(obj, grid.at(2, 2));
		assertNull(grid.at(0,0));
		assertNull(grid.at(3,3));
		GridEvent event = listener.triggeredEvent();
		assertNotNull(event);
		assertEquals(EventType.POSITION_CHANGE, event.type());
	}
	
	
}

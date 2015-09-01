package com.driedtoast.grid;

import junit.framework.TestCase;

public class GridTest extends TestCase {

	public void testGridSetup() throws Exception {
		
		GridConfig config = new GridConfig(4,4);
		Grid grid = new Grid(config);
		assertNull(grid.at(1, 1));
		
	}
	
}

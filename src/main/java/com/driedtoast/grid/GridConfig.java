package com.driedtoast.grid;

import com.driedtoast.grid.model.GridObject;

/**
 * Configuration of the grid and the row and column definition
 * 
 * @author driedtoast
 *
 */
public class GridConfig {

	private int width;
	private int height;

	private GridObject[][] rows;

	public GridConfig(int width, int height) {
		this.width = width;
		this.height = height;
		initializeGrid();
	}

	/**
	 * Grid width in number of blocks
	 * 
	 * @return width - number of blocks
	 */
	public int width() {
		return width;
	}

	/**
	 * Grid height in number of blocks
	 * 
	 * @return height - number of blocks
	 */
	public int height() {
		return height;
	}

	/**
	 * Sets up an empty grid TODO performance optimizations, lazy instantiation?
	 * 
	 */
	protected void initializeGrid() {
		rows = new GridObject[height][width];
		for (int i = 0; i < height; i++) {
			rows[i] = new GridObject[width];
		}
	}

	/**
	 * Get row based on 0 index
	 * 
	 * @param idx
	 * @return column array
	 */
	public GridObject[] getRow(int idx) {
		return rows[idx];
	}

	/**
	 * A multi-dimensional array representing rows and columns of a grid
	 * 
	 * @return rows and column array
	 */
	public GridObject[][] getRows() {
		return rows;
	}

}

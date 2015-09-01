package com.driedtoast.grid.util;

import com.driedtoast.grid.model.GridObject;

@SuppressWarnings("serial")
public class CollisionException extends GridException {

	private GridObject existing;
	private GridObject incoming;

	public CollisionException(GridObject existing, GridObject incoming, Throwable cause) {
		super("Collision occured", cause);
	}

	public CollisionException(GridObject existing, GridObject incoming) {
		super("Collision occured");
		setObjects(existing, incoming);
	}

	private void setObjects(GridObject existing, GridObject incoming) {
		this.existing = existing;
		this.incoming = incoming;
	}

	public GridObject getExisting() {
		return existing;
	}

	public GridObject getIncoming() {
		return incoming;
	}

}

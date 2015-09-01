package com.driedtoast.grid.util;

@SuppressWarnings("serial")
public class GridException extends Exception {

	public GridException() {
		super();
	}

	public GridException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GridException(String message, Throwable cause) {
		super(message, cause);
	}

	public GridException(String message) {
		super(message);
	}

	public GridException(Throwable cause) {
		super(cause);
	}

	
}

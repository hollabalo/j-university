package com.orangeandbronze.enlistment.domain;

public class RoomCapacityFullException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RoomCapacityFullException() {
		super();
	}

	public RoomCapacityFullException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RoomCapacityFullException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoomCapacityFullException(String message) {
		super(message);
	}

	public RoomCapacityFullException(Throwable cause) {
		super(cause);
	}

}

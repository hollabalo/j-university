package com.orangeandbronze.enlistment.domain;

public class SubjectConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SubjectConflictException() {
		super();
	}

	public SubjectConflictException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SubjectConflictException(String message, Throwable cause) {
		super(message, cause);
	}

	public SubjectConflictException(String message) {
		super(message);
	}

	public SubjectConflictException(Throwable cause) {
		super(cause);
	}

}

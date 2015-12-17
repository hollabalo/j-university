package com.orangeandbronze.enlistment.domain;

public class SectionIdAlreadyExistingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SectionIdAlreadyExistingException() {
		super();
	}

	public SectionIdAlreadyExistingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SectionIdAlreadyExistingException(String message, Throwable cause) {
		super(message, cause);
	}

	public SectionIdAlreadyExistingException(String message) {
		super(message);
	}

	public SectionIdAlreadyExistingException(Throwable cause) {
		super(cause);
	}

}

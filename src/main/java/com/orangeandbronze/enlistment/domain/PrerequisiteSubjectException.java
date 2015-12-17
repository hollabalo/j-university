package com.orangeandbronze.enlistment.domain;

public class PrerequisiteSubjectException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PrerequisiteSubjectException() {
	}

	public PrerequisiteSubjectException(String message) {
		super(message);
	}

	public PrerequisiteSubjectException(Throwable cause) {
		super(cause);
	}

	public PrerequisiteSubjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrerequisiteSubjectException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

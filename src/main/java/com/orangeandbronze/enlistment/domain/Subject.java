package com.orangeandbronze.enlistment.domain;

public enum Subject {
	ENGL1(null), MATH1(null), ENGL2(ENGL1), MATH2(MATH1);
	
	private final Subject preReq;
	
	private Subject(Subject preReq){
		this.preReq = preReq;
	}
	
	public Subject getPreReq() {
		return preReq;
	}
	
}
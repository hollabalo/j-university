package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

import java.util.*;

public class Semester {
	private final String semesterName;
	private Collection<Section> sections = new HashSet<>();
	
	public Semester(String semesterName) {
		notBlank(semesterName);
		if(!semesterName.matches("[-\\p{Alnum}]+")) {
			throw new IllegalArgumentException("semesterName is not alphanumeric");
		}
		this.semesterName = semesterName;
	}
	
	public void add(Section newSection) {
		sections.forEach(section -> {
			section.checkForConflict(newSection);
		});
		sections.add(newSection);
	}
	
	public String getSemester() {
		return semesterName;
	}
	
	public Collection<Section> getSections() {
		return new ArrayList<>(sections);
	}
	
}

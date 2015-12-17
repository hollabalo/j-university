package com.orangeandbronze.enlistment.domain;

import static com.orangeandbronze.enlistment.domain.Days.*;
import static com.orangeandbronze.enlistment.domain.Period.*;

import org.junit.Test;

public class SemesterTest {
	
	@Test(expected = SectionIdAlreadyExistingException.class)
	public void addSectionsWithConflict() {
		Semester sem1 = new Semester("SEM1");
		new Section("ABC123", new Schedule(MTH, H0830), new Room("Room1", 2), Subject.MATH1, sem1);
		new Section("ABC123", new Schedule(MTH, H1000), new Room("Room2", 2), Subject.MATH2, sem1);
	}
	
}

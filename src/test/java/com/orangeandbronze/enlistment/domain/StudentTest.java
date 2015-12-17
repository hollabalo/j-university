package com.orangeandbronze.enlistment.domain;

import static com.orangeandbronze.enlistment.domain.Days.*;
import static com.orangeandbronze.enlistment.domain.Period.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.orangeandbronze.enlistment.domain.Room;
import com.orangeandbronze.enlistment.domain.RoomCapacityFullException;
import com.orangeandbronze.enlistment.domain.Schedule;
import com.orangeandbronze.enlistment.domain.ScheduleConflictException;
import com.orangeandbronze.enlistment.domain.Section;
import com.orangeandbronze.enlistment.domain.Student;

public class StudentTest {

	@Test
	public void enlistNoConflict() {
		Student student = new Student(1);
		Semester sem1 = new Semester("SEM1");
		Section section1 = new Section("ABC123", new Schedule(MTH, H0830), new Room("Room1", 2), Subject.MATH1, sem1);
		Section section2 = new Section("DEF456", new Schedule(MTH, H1000), new Room("Room2", 2), Subject.MATH2, sem1);
		student.enlist(section1);
		student.enlist(section2);
		assertTrue(student.getSections().containsAll(Arrays.asList(section1, section2)));
		assertEquals(2, student.getSections().size());
		assertEquals(2, sem1.getSections().size());
	}
	
	@Test(expected = ScheduleConflictException.class)
	public void enlistSameSchedule() {
		Student student = new Student(1);
		Semester sem1 = new Semester("SEM1");
		Section section1 = new Section("ABC123", new Schedule(MTH, H0830), new Room("Room1", 2), Subject.MATH1, sem1);
		Section section2 = new Section("DEF456", new Schedule(MTH, H0830), new Room("Room2", 2), Subject.MATH2, sem1);
		student.enlist(section1);
		student.enlist(section2);
	}
	
	@Test(expected = RoomCapacityFullException.class)
	public void enlistRoomCapacityExceeded() {
		Semester sem1 = new Semester("SEM1");
		Section section = new Section("ABC123", new Schedule(MTH, H0830), new Room("Room1", 2), Subject.MATH1, sem1);
		Student student1 = new Student(1);
		Student student2 = new Student(2);
		Student student3 = new Student(3);
		student1.enlist(section);
		student2.enlist(section);
		student3.enlist(section);
	}
	
	@Test
	public void enlistWithPrerequisiteSubjectHappy() {
		Student student = new Student(1);
		Semester sem1 = new Semester("SEM1");
		Semester sem2 = new Semester("SEM2");
		Section section1 = new Section("ABC123", new Schedule(MTH, H0830), new Room("Room1", 2), Subject.ENGL1, sem1);
		Section section2 = new Section("DEF456", new Schedule(MTH, H1000), new Room("Room2", 2), Subject.ENGL2, sem2);
		student.enlist(section1);
		student.enlist(section2);
	}
	
	@Test (expected = PrerequisiteSubjectException.class)
	public void enlistPreReqOnSem2() {
		Student student = new Student(1);
		Semester sem1 = new Semester("SEM1");
		Semester sem2 = new Semester("SEM2");
		Section section1 = new Section("ABC123", new Schedule(MTH, H0830), new Room("Room1", 2), Subject.ENGL2, sem1);
		Section section2 = new Section("DEF456", new Schedule(MTH, H1000), new Room("Room2", 2), Subject.ENGL1, sem2);
		student.enlist(section1);
		student.enlist(section2);
	}
	
	@Test (expected = PrerequisiteSubjectException.class)
	public void enlistWithPrerequisiteSubject() {
		Student student = new Student(1);
		Semester sem1 = new Semester("SEM1");
		Section section1 = new Section("ABC123", new Schedule(MTH, H0830), new Room("Room1", 2), Subject.MATH1, sem1);
		Section section2 = new Section("DEF456", new Schedule(MTH, H1000), new Room("Room2", 2), Subject.ENGL2, sem1);
		student.enlist(section1);
		student.enlist(section2);
	}
	
	@Test(expected = SubjectConflictException.class)
	public void enlistSubjectConflict() {
		Student student = new Student(1);
		Semester sem1 = new Semester("SEM1");
		Section section1 = new Section("ABC123", new Schedule(MTH, H0830), new Room("Room1", 2), Subject.MATH1, sem1);
		Section section2 = new Section("DEF456", new Schedule(MTH, H1300), new Room("Room2", 2), Subject.MATH1, sem1);
		student.enlist(section1);
		student.enlist(section2);
	}
	
}

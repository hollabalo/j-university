package com.orangeandbronze.enlistment.service;

import static com.orangeandbronze.enlistment.domain.Days.MTH;
import static com.orangeandbronze.enlistment.domain.Period.H0830;

import com.orangeandbronze.enlistment.dao.*;
import com.orangeandbronze.enlistment.domain.*;

public class EnlistService {
	
	private SectionDAO sectionDao;
	private StudentDAO studentDao;
	
	public void enlist(int studentNo, String sectionId) {
		Student student = new Student(studentNo);
		Semester sem = new Semester("SEM1");
		Section section = new Section(sectionId, new Schedule(MTH, H0830), new Room("Room1", 2), Subject.MATH1, sem);
		student.enlist(section);
		studentDao.save(student);
		sectionDao.save(section);
	}

	public void setSectionDao(SectionDAO sectionDao) {
		this.sectionDao = sectionDao;
	}

	public void setStudentDao(StudentDAO studentDao) {
		this.studentDao = studentDao;
	}
	
	
}

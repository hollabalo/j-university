package com.orangeandbronze.enlistment.service;

import org.junit.Test;

import com.orangeandbronze.enlistment.dao.SectionDAO;
import com.orangeandbronze.enlistment.dao.StudentDAO;
import com.orangeandbronze.enlistment.domain.Room;
import com.orangeandbronze.enlistment.domain.Schedule;
import com.orangeandbronze.enlistment.domain.Section;
import com.orangeandbronze.enlistment.domain.Semester;
import com.orangeandbronze.enlistment.domain.Student;
import com.orangeandbronze.enlistment.domain.Subject;

import static com.orangeandbronze.enlistment.domain.Days.MTH;
import static com.orangeandbronze.enlistment.domain.Period.H0830;
import static org.mockito.Mockito.*;

public class EnlistServiceTest {

	@Test
	public void enlistTestWithMockDAO() {
		StudentDAO studentDao = mock(StudentDAO.class);
		SectionDAO sectionDao = mock(SectionDAO.class);
		EnlistService service = new EnlistService();
		service.setStudentDao(studentDao);
		service.setSectionDao(sectionDao);
		
		final int studentId = 1;
		final String sectionId = "ABC123";
		final Semester sem = new Semester("Sem1");
		final Section section = new Section(sectionId, new Schedule(MTH, H0830), new Room("Room1", 2), Subject.MATH1, sem);
		
		when(studentDao.findByStudentId(studentId)).thenReturn(new Student(studentId));
		when(sectionDao.findBySectionId(sectionId)).thenReturn(section);
		
		
		
	}
	
}

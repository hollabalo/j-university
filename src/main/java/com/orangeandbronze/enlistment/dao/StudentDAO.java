package com.orangeandbronze.enlistment.dao;

import com.orangeandbronze.enlistment.domain.Student;

public interface StudentDAO {
	Student findByStudentId(int studentId);
	void save(Student student);
}

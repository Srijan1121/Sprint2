package com.LabAssessment.project1.service;

import java.util.List;

import com.LabAssessment.project1.entity.Student;

public interface StudentService {
	
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
    void deleteAllStudents ();
}



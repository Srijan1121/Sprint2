package com.LabAssessment.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LabAssessment.project1.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

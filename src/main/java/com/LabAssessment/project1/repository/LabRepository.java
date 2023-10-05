package com.LabAssessment.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LabAssessment.project1.entity.Lab;

public interface LabRepository extends JpaRepository<Lab, Long> {
}


package com.LabAssessment.project1.service;

import java.util.List;

import com.LabAssessment.project1.entity.Lab;

public interface LabService {
	
    Lab createLab(Lab lab);
    List<Lab> getAllLabs();
    Lab getLabById(Long id);
    Lab updateLab(Long id, Lab lab);
    void deleteLab(Long id);
    void deleteAllLabs();
}


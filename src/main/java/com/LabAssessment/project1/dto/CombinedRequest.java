package com.LabAssessment.project1.dto;

import java.util.List;

import com.LabAssessment.project1.entity.Lab;
import com.LabAssessment.project1.entity.Student;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class CombinedRequest {
    @Valid
    private Student student;

    @Valid
    private List<Lab> labs;
}


package com.LabAssessment.project1.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Lab_Table")

@Data //Getter & Setter
@NoArgsConstructor
@AllArgsConstructor

public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "PC Number is required")
    private String pcNumber;

    @NotBlank(message = "Room Number is required")
    private String roomNumber;

    @NotBlank(message = "Assigned Task is required")
    private String assignedTask;

    @NotNull(message = "Allotted Time is required")
    private LocalDateTime allottedTime;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}

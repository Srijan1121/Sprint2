package com.LabAssessment.project1.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Student_Table")
@Data //Getter & Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name="Stu_id")
    private Long id;

    @Column(name="Name",length=25, nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(name="Email",length=25, nullable = false, unique = true)
    @Email(message = "Email should be valid -abc@gmail.com")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number should be 10 digits")
    @Column(name="Phone No",length=25, nullable = false, unique = true)
    private String phoneNumber;

    @Column(name="Course",length=20, nullable = false)
    @NotBlank(message = "Course is required")
    private String course;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore 
    private List<Lab> labs;
}


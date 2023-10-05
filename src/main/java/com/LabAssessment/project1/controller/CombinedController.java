package com.LabAssessment.project1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LabAssessment.project1.dto.CombinedRequest;
import com.LabAssessment.project1.entity.Lab;
import com.LabAssessment.project1.entity.Student;
import com.LabAssessment.project1.service.LabService;
import com.LabAssessment.project1.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/combined")
public class CombinedController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private LabService labService;

    @PostMapping("/create")
    public ResponseEntity<Object> createStudentWithLabs(@Valid @RequestBody CombinedRequest request, BindingResult bindingResult) {
    	
    	 if (bindingResult.hasErrors()) {
             // Validation errors occurred, build a response with error messages
             Map<String, Object> errors = new HashMap<>();
             for (FieldError error : bindingResult.getFieldErrors()) {
                 errors.put(error.getField(), error.getDefaultMessage());
             }
             return ResponseEntity.badRequest().body(errors);
         }
        Student student = request.getStudent();
        List<Lab> labs = request.getLabs();

        student = studentService.createStudent(student);

        for (Lab lab : labs) {
            lab.setStudent(student);
            labService.createLab(lab);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Student and Labs created successfully");
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok().body(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok().body(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().body("Student detail deleted successfully");
    }
    
    @DeleteMapping("/delete/allStudents")
    public ResponseEntity<String> deleteAllStudents() {
        studentService.deleteAllStudents();
        return ResponseEntity.ok().body("All Students Detail have been deleted successfully");
    }


    @GetMapping("/labs")
   public List<Lab> getAllLabs() {
       return labService.getAllLabs();
   }
    
      @GetMapping("/labs/{id}")
      public ResponseEntity<Lab> getLabById(@PathVariable Long id) {
        Lab lab = labService.getLabById(id);
        return ResponseEntity.ok().body(lab);
    }

    @PutMapping("/labs/{id}")
    public ResponseEntity<Lab> updateLab(@PathVariable Long id, @RequestBody Lab lab) {
        Lab updatedLab = labService.updateLab(id, lab);
        return ResponseEntity.ok().body(updatedLab);
    }

    @DeleteMapping("/labs/{id}")
    public ResponseEntity<String> deleteLab(@PathVariable Long id) {
        labService.deleteLab(id);
        return ResponseEntity.ok().body("Lab deleted successfully");
    }
    
    @DeleteMapping("/delete/allLabs")
    public ResponseEntity<String> deleteAllLabs() {
        labService.deleteAllLabs();
        return ResponseEntity.ok().body("All labs have been deleted successfully");
    }

}

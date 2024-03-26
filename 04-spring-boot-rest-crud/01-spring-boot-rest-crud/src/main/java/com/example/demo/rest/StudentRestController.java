package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> listStudent;

    @PostConstruct
    public void loadData() {
        listStudent = new ArrayList<>();
        listStudent.add(new Student("John", "Marvel"));
        listStudent.add(new Student("Debbie", "Smith"));
        listStudent.add(new Student("Carl", "Johnson"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return listStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= listStudent.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return listStudent.get(studentId);
    }
}

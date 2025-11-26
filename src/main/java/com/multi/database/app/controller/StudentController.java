package com.multi.database.app.controller;

import com.multi.database.app.entity.Student;
import com.multi.database.app.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(studentService.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudent() {
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(studentService.getAllStudents());
    }
}

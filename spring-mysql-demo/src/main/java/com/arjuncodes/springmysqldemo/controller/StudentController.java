/**
 * @author Arjun Gautam
 * Project :spring-mysql-demo
 * Date : 2021-06-11
 */
package com.arjuncodes.springmysqldemo.controller;

import com.arjuncodes.springmysqldemo.model.Student;
import com.arjuncodes.springmysqldemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> list() {
        return studentService.listAll();
    }

    @PostMapping("/students")
    public String add(@RequestBody Student student) {
        studentService.save(student);
        return "New Student Added";
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id) {
        try {
            Student student = studentService.get(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id) {
        try {
            Student existingStudent = studentService.get(id);
            studentService.save(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.delete(id);
        return "Deleted Student with id:" + id;
    }


}

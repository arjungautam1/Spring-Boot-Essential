/**
 * @author Arjun Gautam
 * Project :spring-mvc
 * Date : 2021-05-26
 */
package com.arjun.springmvc.controller;

import com.arjun.springmvc.model.Student;
import com.arjun.springmvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
  StudentRepository studentRepository;

    @GetMapping("/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable("id") int id){
        return studentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid user id:"+id));
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

}

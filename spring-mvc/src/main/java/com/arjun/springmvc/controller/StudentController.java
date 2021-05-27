/**
 * @author Arjun Gautam
 * Project :spring-mvc
 * Date : 2021-05-26
 */
package com.arjun.springmvc.controller;

import com.arjun.springmvc.model.Student;
import com.arjun.springmvc.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    final
    StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /*http://localhost:8080/student/add?name="Arjun"&regNumber=123*/

    @PostMapping("/addByParam")
    @ResponseBody
    public String addNewStudent(@RequestParam String name, @RequestParam Long regNumber) {
        Student student = new Student();
        student.setName(name);
        student.setRegNumber(regNumber);
        studentRepository.save(student);
        return "New Student added";
    }

    /*{
    "name": "Arjun Gautam",
    "regNumber": "1234"
    }*/

    @PostMapping("/add")
    @ResponseBody
    public String saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
        int id = student.getId();
        return "New Student with id " + id + " Added";
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable("id") int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    /*http://localhost:8080/student/name/arjun*/


/*    Query DSL (Domain Specific Language)  ->Querydsl is an extensive Java framework,
    which helps with creating and running type-safe queries in a domain specific language that is similar to SQL.*/

    @GetMapping("name/{name}")
    @ResponseBody
    public List<Student> getStudentByName(@PathVariable("name") String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/reg/{regNumber}")
    @ResponseBody
    public List<Student> getStudentByRegNumber(@PathVariable("regNumber") Long regNumber){
        return studentRepository.findByReg(regNumber);
    }



}

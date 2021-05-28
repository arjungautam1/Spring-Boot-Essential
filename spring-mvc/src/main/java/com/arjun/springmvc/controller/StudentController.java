/**
 * @author Arjun Gautam
 * Project :spring-mvc
 * Date : 2021-05-26
 */
package com.arjun.springmvc.controller;

import com.arjun.springmvc.model.Student;
import com.arjun.springmvc.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    final
    StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /*http://localhost:8080/student/add?name="Arjun"&regNumber=123*/

    @PostMapping("/addByParam")
//    @ResponseBody   /*We don't need to use ResponseBody once we use RestController*/
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

    @PostMapping(value = "/add",consumes = {"application/json"})
    public Student saveStudent(@RequestBody Student student) {
        studentRepository.save(student);
//        int id = student.getId();
//        return "New Student with id " + id + " Added";
        return student;
    }


    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id:" + id));
    }

    @GetMapping(value = "/all",produces = {"application/xml"})
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    /*http://localhost:8080/student/name/arjun*/


/*    Query DSL (Domain Specific Language)  ->Querydsl is an extensive Java framework,
    which helps with creating and running type-safe queries in a domain specific language that is similar to SQL.*/

    @GetMapping("name/{name}")
    public List<Student> getStudentByName(@PathVariable("name") String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/reg/{regNumber}")
    public List<Student> getStudentByRegNumber(@PathVariable("regNumber") Long regNumber) {
        return studentRepository.findByReg(regNumber);
    }


    /*http://localhost:8080/student/28*/

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentRepository.deleteById(id);
        return "deleted student with id :" + id;

    }

    @GetMapping("/queryName/{name}")
    public List<Student> findStudentByName1(@PathVariable("name") String name) {
        return studentRepository.find(name);
    }


}

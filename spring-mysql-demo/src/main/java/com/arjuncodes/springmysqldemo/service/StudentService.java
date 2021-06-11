/**
 * @author Arjun Gautam
 * Project :spring-mysql-demo
 * Date : 2021-06-11
 */
package com.arjuncodes.springmysqldemo.service;

import com.arjuncodes.springmysqldemo.model.Student;
import com.arjuncodes.springmysqldemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public List<Student> listAll(){
        return studentRepository.findAll();
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public Student get(Integer id){
        return studentRepository.findById(id).get();
    }

    public void delete(Integer id){
        studentRepository.deleteById(id);
    }


}

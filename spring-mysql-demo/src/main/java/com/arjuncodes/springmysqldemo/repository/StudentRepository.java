package com.arjuncodes.springmysqldemo.repository;

import com.arjuncodes.springmysqldemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}

/**
 * @author Arjun Gautam
 * Project :spring-mvc
 * Date : 2021-05-26
 */
package com.arjun.springmvc.repository;

import com.arjun.springmvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);

    @Query("select s from Student s where s.regNumber= ?1")
    List<Student> findByReg(Long regNumber);

    @Query("from Student where name=:studentName")
    List<Student> find(@Param("studentName") String name);
}

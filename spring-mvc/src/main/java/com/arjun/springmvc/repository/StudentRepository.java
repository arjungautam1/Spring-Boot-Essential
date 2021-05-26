/**
 * @author Arjun Gautam
 * Project :spring-mvc
 * Date : 2021-05-26
 */
package com.arjun.springmvc.repository;

import com.arjun.springmvc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

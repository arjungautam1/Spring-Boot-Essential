/**
 * @author Arjun Gautam
 * Project :spring-crud
 * Date : 2021-06-10
 */
package com.arjuncodes.springcrud.repository;

import com.arjuncodes.springcrud.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
}

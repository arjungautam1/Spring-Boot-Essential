/**
 * @author Arjun Gautam
 * Project :spring-mvc
 * Date : 2021-05-26
 */
package com.arjun.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private Long regNumber;


    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Long regNumber) {
        this.regNumber = regNumber;
    }
}

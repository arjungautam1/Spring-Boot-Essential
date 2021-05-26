/**
 * @author Arjun Gautam
 * Project :spring-core
 * Date : 2021-05-26
 */
package com.udemy.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    @Autowired
    Keyboard keyboard;

    void code()
    {
        keyboard.write();
    }

}

//Component is responsible for creating object

/**
 * @author Arjun Gautam
 * Project :spring-core
 * Date : 2021-05-26
 */
package com.udemy.spring.core;

import org.springframework.stereotype.Component;

@Component
public class Keyboard {
    public void write() {
        System.out.println("Writing in Keyboard");
    }
}

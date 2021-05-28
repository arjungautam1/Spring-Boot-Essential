/**
 * @author Arjun Gautam
 * Project :spring-mvc
 * Date : 2021-05-28
 */
package com.arjun.springmvc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public * com.arjun.springmvc.controller.StudentController.getStudents())")
    public void log() {
        System.out.println("Getting all data from Student");
    }

}

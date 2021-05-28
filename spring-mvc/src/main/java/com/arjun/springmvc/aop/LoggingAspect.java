/**
 * @author Arjun Gautam
 * Project :spring-mvc
 * Date : 2021-05-28
 */
package com.arjun.springmvc.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * com.arjun.springmvc.controller.StudentController.getStudents())")
    public void logBefore() {
        LOGGER.info("Student got.");
    }

    //this works as finally in exception
    @After("execution(public * com.arjun.springmvc.controller.StudentController.getStudents())")
    public void logAfter() {
        LOGGER.info("Student got using after");
    }

//    instead we can use @AfterReturning only if code works

    //@AfterThrowing for exception

}

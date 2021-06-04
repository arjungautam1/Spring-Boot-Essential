/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.thymeleaf.roomwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

}

/**
 * @author Arjun Gautam
 * Project :spring-security
 * Date : 2021-05-28
 */
package com.arjun.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }


}

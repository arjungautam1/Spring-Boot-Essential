/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.thymeleaf.roomwebapp.controllers;

import com.thymeleaf.roomwebapp.models.StaffMember;
import com.thymeleaf.roomwebapp.service.StaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/staff")
public class StaffRestController {

    private StaffService staffService;

    StaffRestController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("")
    public List<StaffMember> getAllStaffs() {
        return staffService.getStaff();
    }

    @GetMapping("/repo")
    public List<StaffMember> getAll(){
        return staffService.getAllStaff();
    }

}

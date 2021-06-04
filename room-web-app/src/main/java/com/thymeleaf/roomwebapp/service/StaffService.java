/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.thymeleaf.roomwebapp.service;

import com.thymeleaf.roomwebapp.models.Position;
import com.thymeleaf.roomwebapp.models.StaffMember;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {
    public static final List<StaffMember> staff = new ArrayList<>();

    static {

        staff.add(new StaffMember("126", "Pooja", "Poudel", Position.FRONT_DESK));
        staff.add(new StaffMember("125", "Ram", "Gautam", Position.SECURITY));
        staff.add(new StaffMember("124", "Arjun", "Gautam", Position.MANAGER));
        staff.add(new StaffMember("123", "Arjun", "Gautam", Position.HOUSEKEEPING));

    }

    public List<StaffMember> getStaff() {
        return staff;
    }
}

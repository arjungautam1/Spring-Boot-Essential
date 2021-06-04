/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.thymeleaf.roomwebapp.service;

import com.thymeleaf.roomwebapp.models.Position;
import com.thymeleaf.roomwebapp.models.StaffMember;
import com.thymeleaf.roomwebapp.repository.StaffMemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StaffService {

    private final StaffMemberRepository staffMemberRepository;

    public StaffService(StaffMemberRepository staffMemberRepository) {
        this.staffMemberRepository = staffMemberRepository;
    }

    public List<StaffMember> getAllStaff() {
        return staffMemberRepository.findAll();
    }






        public static final List<StaffMember> staff = new ArrayList<>();

    static {

        staff.add(new StaffMember(UUID.randomUUID().toString(), "Pooja", "Poudel", Position.FRONT_DESK));
        staff.add(new StaffMember(UUID.randomUUID().toString(), "Ram", "Gautam", Position.SECURITY));
        staff.add(new StaffMember(UUID.randomUUID().toString(), "Arjun", "Gautam", Position.MANAGER));
        staff.add(new StaffMember(UUID.randomUUID().toString(), "Arjun", "Gautam", Position.HOUSEKEEPING));

    }

    public List<StaffMember> getStaff() {
        return staff;
    }


}

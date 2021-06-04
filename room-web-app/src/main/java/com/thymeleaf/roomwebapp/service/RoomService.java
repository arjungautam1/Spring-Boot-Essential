/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.thymeleaf.roomwebapp.service;

import com.thymeleaf.roomwebapp.models.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private static final List<Room> rooms=new ArrayList<>();
    static {
        for (int i=0;i<10;i++)
        {
            rooms.add(new Room(i,"Room"+i,"R"+2,"Bead Size"+1));
        }
    }

    public List<Room> getAllRooms(){
        return rooms;
    }

}

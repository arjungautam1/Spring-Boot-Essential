/**
 * @author Arjun Gautam
 * Project :Spring-Boot-Essential
 * Date : 2021-06-04
 */
package com.thymeleaf.roomwebapp.service;

import com.thymeleaf.roomwebapp.models.Room;
import com.thymeleaf.roomwebapp.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

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

    public Room getById(long id) {
        return roomRepository.findById(id).get();
    }
}

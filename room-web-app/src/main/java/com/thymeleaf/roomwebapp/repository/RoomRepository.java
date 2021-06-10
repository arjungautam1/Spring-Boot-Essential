package com.thymeleaf.roomwebapp.repository;

import com.thymeleaf.roomwebapp.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}

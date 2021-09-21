package com.webchat.webchat.repository;

import com.webchat.webchat.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepositoty extends JpaRepository<Room, String> {
    @Query("select o from Room o where o.id = ?1")
    List<Room> findRoomById(String id);
}

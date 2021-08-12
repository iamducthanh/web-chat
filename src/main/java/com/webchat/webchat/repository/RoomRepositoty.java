package com.webchat.webchat.repository;

import com.webchat.webchat.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepositoty extends JpaRepository<Room, String> {
}

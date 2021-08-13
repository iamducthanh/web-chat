package com.webchat.webchat.repository;

import com.webchat.webchat.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("select o from Message o where o.room.id = ?1 order by o.time asc")
    List<Message> findByRoom(String id);
}

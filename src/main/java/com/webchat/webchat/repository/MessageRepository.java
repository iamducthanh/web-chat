package com.webchat.webchat.repository;

import com.webchat.webchat.entities.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("select o from Message o where o.room.id = ?1 order by o.time asc")
    List<Message> findByRoom(String id);

    @Query("select o from Message  o where o.room.id = ?1 and o.user.username = ?2 and o.status = ?3")
    List<Message> findByRoomAndUserAndStatus(String roomId, String username, String status);

    @Query("select o from Message  o where o.room.id = ?1 order by o.time desc")
    List<Message> findMessageLast(String roomId, Pageable pageable);

    @Query("select o from Message  o where o.room.id = ?1 and o.user.username = ?2 and o.status = 'SEND'")
    List<Message> countMessageSend(String roomId, String username);
}

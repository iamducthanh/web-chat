package com.webchat.webchat.repository;

import com.webchat.webchat.entities.Attach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttachRepository extends JpaRepository<Attach, Integer> {
    @Query("select o from Attach o where o.message.id = ?1")
    List<Attach> findByMessage(String messageId);

    @Query("select o from Attach o where o.message.id in (select o.id from Message o where o.room.id = ?1)")
    List<Attach> findByRoom(String roomId);
}

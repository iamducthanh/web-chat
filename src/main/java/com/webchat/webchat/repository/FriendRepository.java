package com.webchat.webchat.repository;

import com.webchat.webchat.entities.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
    @Query("select o from Friend o where o.user.username = ?1 or o.friend.username = ?2")
    List<Friend> findByUser(String username1, String username2);
}

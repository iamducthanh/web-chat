package com.webchat.webchat.repository;

import com.webchat.webchat.entities.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Integer> {
}

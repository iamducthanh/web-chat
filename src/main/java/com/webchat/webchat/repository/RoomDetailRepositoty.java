package com.webchat.webchat.repository;

import com.webchat.webchat.entities.RoomDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomDetailRepositoty extends JpaRepository<RoomDetail, Integer> {
    @Query("select o from RoomDetail o where o.user.id = ?1")
    List<RoomDetail> findRoomDetailByUser(Integer userId);

    @Query("select o from RoomDetail o where o.user.id = ?1 and o.room.id = ?2")
    List<RoomDetail> findRoomDetailByUserAndRoom(Integer userId, String roomId);
}

package com.webchat.webchat.service;

import com.webchat.webchat.entities.RoomDetail;

import java.util.List;

public interface IRoomDetailService {
    List<RoomDetail> findByUser(Integer userId);
    RoomDetail findRoomDetailByUserAndRoom(Integer userId, String roomId);
    RoomDetail findRoomDetailBy2User(Integer userId1, Integer userId2);
    void saveRoomDetail(List<RoomDetail> roomDetails);
}

package com.webchat.webchat.service.impl;

import com.webchat.webchat.entities.RoomDetail;
import com.webchat.webchat.repository.RoomDetailRepositoty;
import com.webchat.webchat.service.IRoomDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomDetailService implements IRoomDetailService {
    @Autowired
    RoomDetailRepositoty roomDetailRepo;

    @Override
    public List<RoomDetail> findByUser(Integer userId) {
        List<RoomDetail> list = roomDetailRepo.findRoomDetailByUser(userId);
        return list.isEmpty() ? null : list;
    }

    @Override
    public RoomDetail findRoomDetailByUserAndRoom(Integer userId, String roomId) {
        List<RoomDetail> list = roomDetailRepo.findRoomDetailByUserAndRoom(userId, roomId);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public RoomDetail findRoomDetailBy2User(Integer userId1, Integer userId2) {
        List<RoomDetail> list = roomDetailRepo.findRoomDetailBy2User(userId1, userId2);
        return list.isEmpty() ? null : list.get(0);
    }
}

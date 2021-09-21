package com.webchat.webchat.service.impl;

import com.webchat.webchat.entities.Room;
import com.webchat.webchat.repository.RoomRepositoty;
import com.webchat.webchat.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private RoomRepositoty roomRepositoty;

    @Override
    public void saveRoom(Room room) {
        roomRepositoty.save(room);
    }
}

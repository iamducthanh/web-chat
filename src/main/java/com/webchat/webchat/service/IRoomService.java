package com.webchat.webchat.service;

import com.webchat.webchat.entities.Room;

import java.util.List;

public interface IRoomService {
    void saveRoom(Room room);
    Room findRoomById(String id);
}

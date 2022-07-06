package com.example.davr_task.service;

import com.example.davr_task.DTO.RoomDTO;
import com.example.davr_task.entity.Room;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class RoomService {

    private RoomRepository roomRepository;


    public ApiResponse<List<Room>> findAll() {
        List<Room> rooms =
                StreamSupport.stream(roomRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<Room>>("List of room", true, rooms);
    }

    public ApiResponse<Room> findByName(String Name) {
        Optional<Room> room = roomRepository.findByName(Name);
        if (room.isEmpty()) {
            return new ApiResponse<Room>("Room's name not found", false);
        } else
            return new ApiResponse<Room>("Room",  true, room.get());
    }


    public ApiResponse<Room> findById(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isEmpty()) {
            return new ApiResponse<>("Room not found", false);
        } else
            return new ApiResponse<Room>("Room",  true, room.get());
    }

    public ApiResponse<Room> save(RoomDTO dto){
        Room room = new Room();
        room.setName(dto.getName());
        room.setCapacity(dto.getCapacity());
        return new ApiResponse<Room>("room saved", true, roomRepository.save(room));
    }

    public ApiResponse<Room> edit(Long id, RoomDTO dto) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isEmpty()) {
            return new ApiResponse<>("Room not found", false);
        } else {
            Room room = roomOptional.get();
            room.setName(dto.getName());
            room.setCapacity(dto.getCapacity());
            return new ApiResponse<Room>("room edited", true, roomRepository.save(room));
        }
    }

    public ApiResponse<Room> delete(Long id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isEmpty()) {
            return new ApiResponse<>("Room not found", false);
        } else {
            Room room = roomOptional.get();
            roomRepository.delete(room);
            return new ApiResponse<>("room deleted", true);
        }
    }
}




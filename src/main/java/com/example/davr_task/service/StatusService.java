package com.example.davr_task.service;

import com.example.davr_task.DTO.StatusDTO;
import com.example.davr_task.entity.Status;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.RoomRepository;
import com.example.davr_task.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class StatusService {

    private StatusRepository statusRepository;


    public ApiResponse<List<Status>> findAll() {
        List<Status> statuses =
                StreamSupport.stream(statusRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<Status>>("List of status", true, statuses);
    }

    public ApiResponse<Status> findByName(String Name) {
        Optional<Status> status = statusRepository.findByName(Name);
        if (status.isEmpty()) {
            return new ApiResponse<Status>("Status's name not found", false);
        } else
            return new ApiResponse<Status>("Status",  true, status.get());
    }


    public ApiResponse<Status> findById(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        if (status.isEmpty()) {
            return new ApiResponse<>("Status not found", false);
        } else
            return new ApiResponse<Status>("Status",  true, status.get());
    }

    public ApiResponse<Status> save(StatusDTO dto){
        Status status = new Status();
        status.setName(dto.getName());
        status.setDescription(dto.getDescription());
        return new ApiResponse<Status>("status saved", true, statusRepository.save(status));
    }

    public ApiResponse<Status> edit(Long id, StatusDTO dto) {
        Optional<Status> statusOptional = statusRepository.findById(id);
        if (statusOptional.isEmpty()) {
            return new ApiResponse<>("Status not found", false);
        } else {
            Status status = statusOptional.get();
            status.setName(dto.getName());
            status.setDescription(dto.getDescription());
            return new ApiResponse<Status>("status edited", true, statusRepository.save(status));
        }
    }

    public ApiResponse<Status> delete(Long id) {
        Optional<Status> statusOptional = statusRepository.findById(id);
        if (statusOptional.isEmpty()) {
            return new ApiResponse<>("Status not found", false);
        } else {
            Status status = statusOptional.get();
            statusRepository.delete(status);
            return new ApiResponse<>("status deleted", true);
        }
    }
}




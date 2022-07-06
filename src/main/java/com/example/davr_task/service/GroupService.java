package com.example.davr_task.service;

import com.example.davr_task.DTO.GroupDTO;
import com.example.davr_task.entity.Group;
import com.example.davr_task.entity.Group;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.GroupRepository;
import com.example.davr_task.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class GroupService {

    private GroupRepository groupRepository;


    public ApiResponse<List<Group>> findAll() {
        List<Group> groups =
                StreamSupport.stream(groupRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<Group>>("List of group", true, groups);
    }

    public ApiResponse<Group> findByName(String Name) {
        Optional<Group> group = groupRepository.findByName(Name);
        if (group.isEmpty()) {
            return new ApiResponse<Group>("Group's name not found", false);
        } else
            return new ApiResponse<Group>("Group",  true, group.get());
    }


    public ApiResponse<Group> findById(Long id) {
        Optional<Group> group = groupRepository.findById(id);
        if(group.isEmpty()){
            return new ApiResponse<>("group not found", false);
        }
            return new ApiResponse<Group>("Group",  true, group.get());
    }

    public ApiResponse<Group> save(GroupDTO dto){
        Group group = new Group();

        Optional<Group> groupOptional = groupRepository.findByName(dto.getName());
        if(!groupOptional.isEmpty()){
            return new ApiResponse<>("This group name already exists", false);
        }

       group.setName(dto.getName());
       group.setCourseId(dto.getCourseId());
       group.setTeacherId(dto.getTeacherId());
       group.setStudent(dto.getStudents());
       group.setRoomId(dto.getRoomId());
       group.setStartDate(dto.getStartDate());
       group.setEndDate(dto.getEndDate());
       group.setStatusId(dto.getStatusId());
        return new ApiResponse<Group>("group saved", true, groupRepository.save(group));
    }

    public ApiResponse<Group> edit(Long id, GroupDTO dto) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        if (groupOptional.isEmpty()) {
           return  new ApiResponse<>("Group not found", false);
        } else {
            Group group = groupOptional.get();
            group.setName(dto.getName());
            group.setCourseId(dto.getCourseId());
            group.setTeacherId(dto.getTeacherId());
            group.setRoomId(dto.getRoomId());
            group.setStudent(dto.getStudents());
            group.setStartDate(dto.getStartDate());
            group.setEndDate(dto.getEndDate());
            group.setStatusId(dto.getStatusId());
            return new ApiResponse<Group>("group edited", true, groupRepository.save(group));
        }
    }


    public  ApiResponse<Group> delete(Long id) {
        Optional<Group> groupOptional = groupRepository.findById(id);
        if (groupOptional.isEmpty()) {
            return  new ApiResponse<>("Group not found", false);
        } else {
            Group group = groupOptional.get();
            groupRepository.delete(group);
            return new ApiResponse<>("group deleted", true);
        }
    }
}




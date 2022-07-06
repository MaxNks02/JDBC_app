package com.example.davr_task.service;

import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.GroupStudentRepository;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupStudentService {

    private GroupStudentRepository groupTableRepository;

    public ApiResponse<String> addStudentToGroup(Long student_id, Long group_id){
        if(!groupTableRepository.findByIdStudent(student_id).isEmpty()){
            return new ApiResponse<>("student already added", false);
        }
         groupTableRepository.insertIntoGroupStudent(student_id, group_id);
        return new ApiResponse<>("successfully added", true);

    }

    public ApiResponse<List<Long>> studentIdListByGroupId(Long group_id){

        Optional<List<Long>> list = groupTableRepository.studentListByGroupId(group_id);
        return new ApiResponse<List<Long>>("Student list by group_id", true, list.get());

    }

    public ApiResponse<Long> deleteStudentFromGroup(Long student_id){

        Optional<Long> student = groupTableRepository.deleteStudentFromGroup(student_id);
        return new ApiResponse<Long>("deleted", true, student.get());

    }
    public ApiResponse<Long> groupIdByStudentId(Long student_id){

        Optional<Long> id = groupTableRepository.groupIdByStudentId(student_id);
        return new ApiResponse<Long>("student's group_id", true, id.get());

    }

    public ApiResponse<List<JSONObject>> listOfStudentWithGroup(){

        Optional<List<JSONObject>> list = groupTableRepository.listOfStudentsWithGroup();
        return new ApiResponse<List<JSONObject>>("student's group_id", true, list.get());

    }


}

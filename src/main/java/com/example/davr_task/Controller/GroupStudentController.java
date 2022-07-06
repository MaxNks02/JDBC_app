package com.example.davr_task.Controller;

import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.service.GroupStudentService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/groupStudent")
@RequiredArgsConstructor
public class GroupStudentController {

    private GroupStudentService groupStudentService;

    @GetMapping("/listOfAllStudent")
    public HttpEntity<?> getAllStudent(){
        ApiResponse<List<JSONObject>> apiResponse = groupStudentService.listOfStudentWithGroup();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/listOfAllStudentByGroupId")
    public HttpEntity<?> getAllStudent(@RequestBody Long id){
        ApiResponse<List<Long>> response = groupStudentService.studentIdListByGroupId(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/{studentId}")
    public HttpEntity<?> getGroupIdByStudentId(@RequestParam("studentId") Long id){
        ApiResponse<Long> response=groupStudentService.groupIdByStudentId(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }



    @PostMapping("/saveStudentToGroup")
    public HttpEntity<?> save (@RequestBody Long studentId, Long groupId){
        ApiResponse<String> response =groupStudentService.addStudentToGroup(studentId, groupId);;
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE).body(response);
    }



    @DeleteMapping("/deleteStudentFromGroup/{studentId}")
    public HttpEntity<?> delete(@RequestParam Long studentId){
        ApiResponse<Long> response = groupStudentService.deleteStudentFromGroup(studentId);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }






}

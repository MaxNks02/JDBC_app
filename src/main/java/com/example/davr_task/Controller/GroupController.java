package com.example.davr_task.Controller;

import com.example.davr_task.DTO.GroupDTO;
import com.example.davr_task.entity.Group;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/group")
@RequiredArgsConstructor
public class GroupController {

    private GroupService groupService;

    @GetMapping("/all")
    public HttpEntity<?> getAllStudent(){
        ApiResponse<List<Group>> apiResponse = groupService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@RequestParam("id") Long id){
        ApiResponse<Group> response=groupService.findById(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/{name}")
    public HttpEntity<?> getByName(@RequestParam("name") String name){
        ApiResponse<Group> response = groupService.findByName(name);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save (@RequestBody GroupDTO groupDTO){
        ApiResponse<Group> response = groupService.save(groupDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@RequestParam("id") @RequestBody Long id, GroupDTO groupDTO){
        ApiResponse<Group> response = groupService.edit(id, groupDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@RequestParam Long id){
        ApiResponse<Group> response = groupService.delete(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }






}

package com.example.davr_task.Controller;

import com.example.davr_task.DTO.StatusDTO;
import com.example.davr_task.entity.Status;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/status")
@RequiredArgsConstructor
public class StatusController {

    private StatusService statusService;

    @GetMapping("/all")
    public HttpEntity<?> getAllStudent(){
        ApiResponse<List<Status>> apiResponse = statusService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@RequestParam("id") Long id){
        ApiResponse<Status> response=statusService.findById(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/{name}")
    public HttpEntity<?> getByName(@RequestParam("name") String name){
        ApiResponse<Status> response = statusService.findByName(name);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save (@RequestBody StatusDTO statusDTO){
        ApiResponse<Status> response = statusService.save(statusDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.CREATED : HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@RequestParam("id") @RequestBody Long id, StatusDTO statusDTO){
        ApiResponse<Status> response = statusService.edit(id, statusDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@RequestParam Long id){
        ApiResponse<Status> response = statusService.delete(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }






}

package com.example.davr_task.Controller;

import com.example.davr_task.DTO.TimeTableDTO;
import com.example.davr_task.entity.TimeTable;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.service.TimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/timeTable")
@RequiredArgsConstructor
public class TimeTableController {

    private TimeTableService timeTableService;

    @GetMapping("/all")
    public HttpEntity<?> getAllStudent(){
        ApiResponse<List<TimeTable>> apiResponse = timeTableService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@RequestParam("id") Long id){
        ApiResponse<TimeTable> response=timeTableService.findById(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }



    @PostMapping("/save")
    public HttpEntity<?> save (@RequestBody TimeTableDTO timeTableDTO){
        ApiResponse<TimeTable> response = timeTableService.save(timeTableDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@RequestParam("id") @RequestBody Long id, TimeTableDTO timeTableDTO){
        ApiResponse<TimeTable> response = timeTableService.edit(id, timeTableDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@RequestParam Long id){
        ApiResponse<TimeTable> response = timeTableService.delete(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }






}

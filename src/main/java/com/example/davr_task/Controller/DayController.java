package com.example.davr_task.Controller;


import com.example.davr_task.entity.Day;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.service.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/day")
@RequiredArgsConstructor
public class DayController {

    private DayService dayService;

    @GetMapping("/all")
    public HttpEntity<?> getAllStudent() {
        ApiResponse<List<Day>> apiResponse = dayService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@RequestParam("id") Long id) {
        ApiResponse<Day> response = dayService.findById(id);
        return ResponseEntity.status(response.getSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/{name}")
    public HttpEntity<?> getByName(@RequestParam("name") String name) {
        ApiResponse<Day> response = dayService.findByName(name);
        return ResponseEntity.status(response.getSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(@RequestBody String name) {
        ApiResponse<Day> response = dayService.save(name);
        return ResponseEntity.status(response.getSuccess() ? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@RequestParam("id") @RequestBody Long id, String name) {
        ApiResponse<Day> response = dayService.edit(id, name);
        return ResponseEntity.status(response.getSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@RequestParam Long id) {
        ApiResponse<Day> response = dayService.delete(id);
        return ResponseEntity.status(response.getSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }


}

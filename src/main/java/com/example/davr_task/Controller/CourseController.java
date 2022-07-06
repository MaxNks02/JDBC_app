package com.example.davr_task.Controller;

import com.example.davr_task.DTO.CourseDTO;
import com.example.davr_task.entity.Course;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {

    private CourseService courseService;

    @GetMapping("/all")
    public HttpEntity<?> getAllStudent(){
        ApiResponse<List<Course>> apiResponse = courseService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@RequestParam("id") Long id){
        ApiResponse<Course> response=courseService.findById(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/{name}")
    public HttpEntity<?> getByName(@RequestParam("name") String name){
        ApiResponse<Course> response = courseService.findByName(name);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save (@RequestBody CourseDTO courseDTO){
        ApiResponse<Course> response = courseService.save(courseDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@RequestParam("id") @RequestBody Long id, CourseDTO courseDTO){
        ApiResponse<Course> response = courseService.edit(id, courseDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@RequestParam Long id){
        ApiResponse<Course> response = courseService.delete(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }






}

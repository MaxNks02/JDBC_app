package com.example.davr_task.Controller;

import com.example.davr_task.DTO.StudentDTO;
import com.example.davr_task.entity.Student;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public HttpEntity<?> getAllStudent(){
        ApiResponse<List<Student>> apiResponse = studentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    @GetMapping("/alll")
    public HttpEntity<?> getAllStudentt(){
        ApiResponse<List<Student>> apiResponse = studentService.findAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@RequestParam("id") Long id){
        ApiResponse<Student> response=studentService.findById(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/name")
    public HttpEntity<?> getByName(@RequestBody String name){
        ApiResponse<Student> response = studentService.findByFullName(name);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save (@RequestBody StudentDTO studentDTO){
        ApiResponse<Student> response = studentService.save(studentDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@RequestParam("id") @RequestBody Long id, StudentDTO studentDTO){
        ApiResponse<Student> response = studentService.edit(id, studentDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@RequestParam Long id){
        ApiResponse<Student> response = studentService.delete(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }






}

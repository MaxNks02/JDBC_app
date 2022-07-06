package com.example.davr_task.Controller;

import com.example.davr_task.entity.PayType;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.service.PayTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/payType")
@RequiredArgsConstructor
public class PayTypeController {

    private PayTypeService  payTypeService;

    @GetMapping("/all")
    public HttpEntity<?> getAllStudent(){
        ApiResponse<List<PayType>> apiResponse = payTypeService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@RequestParam("id") Long id){
        ApiResponse<PayType> response=payTypeService.findById(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @GetMapping("/{name}")
    public HttpEntity<?> getByName(@RequestParam("name") String name){
        ApiResponse<PayType> response = payTypeService.findByName(name);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping("/save")
    public HttpEntity<?> save (@RequestBody String name){
        ApiResponse<PayType> response = payTypeService.save(name);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@RequestParam("id") @RequestBody Long id, String name){
        ApiResponse<PayType> response = payTypeService.edit(id, name);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@RequestParam Long id){
        ApiResponse<PayType> response = payTypeService.delete(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }






}

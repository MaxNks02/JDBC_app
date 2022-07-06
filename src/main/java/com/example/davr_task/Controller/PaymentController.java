package com.example.davr_task.Controller;

import com.example.davr_task.DTO.PaymentDTO;
import com.example.davr_task.entity.Payment;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private PaymentService paymentService;

    @GetMapping("/all")
    public HttpEntity<?> getAllStudent(){
        ApiResponse<List<Payment>> apiResponse = paymentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@RequestParam("id") Long id){
        ApiResponse<Payment> response=paymentService.findById(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }


    @PostMapping("/save")
    public HttpEntity<?> save (@RequestBody PaymentDTO paymentDTO){
        ApiResponse<Payment> response = paymentService.save(paymentDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @PutMapping("/edit/{id}")
    public HttpEntity<?> edit(@RequestParam("id") @RequestBody Long id, PaymentDTO paymentDTO){
        ApiResponse<Payment> response = paymentService.edit(id, paymentDTO);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> delete(@RequestParam Long id){
        ApiResponse<Payment> response = paymentService.delete(id);
        return ResponseEntity.status(response.getSuccess()? HttpStatus.OK : HttpStatus.NOT_FOUND).body(response);
    }






}

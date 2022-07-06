package com.example.davr_task.service;

import com.example.davr_task.DTO.PaymentDTO;
import com.example.davr_task.entity.Payment;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.PaymentRepository;
import com.example.davr_task.repository.TimeTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private PaymentRepository paymentRepository;


    public ApiResponse<List<Payment>> findAll() {
        List<Payment> payments =
                StreamSupport.stream(paymentRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<Payment>>("List of payment", true, payments);
    }




    public ApiResponse<Payment> findById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isEmpty()){
            return new ApiResponse<>("payment not found", false);
        }
            return new ApiResponse<Payment>("Payment",  true, payment.get());
    }

    public ApiResponse<Payment> save(PaymentDTO dto){
        Payment payment = new Payment();

        payment.setPayTypeId(dto.getPayTypeId());
        payment.setSum(dto.getSum());
        payment.setDescription(dto.getDescription());
        payment.setStudentId(dto.getStudentId());
        return new ApiResponse<Payment>("payment saved", true, paymentRepository.save(payment));
    }

    public ApiResponse<Payment> edit(Long id, PaymentDTO dto) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if (paymentOptional.isEmpty()) {
           return  new ApiResponse<>("Payment not found", false);
        } else {
            Payment payment = paymentOptional.get();
            payment.setPayTypeId(dto.getPayTypeId());
            payment.setSum(dto.getSum());
            payment.setDescription(dto.getDescription());
            payment.setStudentId(dto.getStudentId());
            return new ApiResponse<Payment>("payment edited", true, paymentRepository.save(payment));
        }
    }

    public  ApiResponse<Payment> delete(Long id) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if (paymentOptional.isEmpty()) {
            return  new ApiResponse<>("Payment not found", false);
        } else {
            Payment payment = paymentOptional.get();
            paymentRepository.delete(payment);
            return new ApiResponse<>("payment deleted", true);
        }
    }
}




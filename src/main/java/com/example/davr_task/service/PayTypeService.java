package com.example.davr_task.service;

import com.example.davr_task.entity.PayType;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.DayRepository;
import com.example.davr_task.repository.PayTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class PayTypeService {

    private PayTypeRepository payTypeRepository;


    public ApiResponse<List<PayType>> findAll() {
        List<PayType> days =
                StreamSupport.stream(payTypeRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<PayType>>("List of payType", true, days);
    }

    public ApiResponse<PayType> findByName(String Name) {
        Optional<PayType> payType = payTypeRepository.findByName(Name);
        if (payType.isEmpty()) {
            return new ApiResponse<PayType>("PayType's name not found", false);
        } else
            return new ApiResponse<PayType>("PayType",  true, payType.get());
    }


    public ApiResponse<PayType> findById(Long id) {
        Optional<PayType> payType = payTypeRepository.findById(id);
        if (payType.isEmpty()) {
            return new ApiResponse<>("PayType not found", false);
        } else
            return new ApiResponse<PayType>("PayType",  true, payType.get());
    }

    public ApiResponse<PayType> save(String name){
        PayType payType = new PayType();
        payType.setName(name);
        return new ApiResponse<PayType>("payType saved", true, payTypeRepository.save(payType));
    }

    public ApiResponse<PayType> edit(Long id, String name) {
        Optional<PayType> payTypeOptional = payTypeRepository.findById(id);
        if (payTypeOptional.isEmpty()) {
            return new ApiResponse<>("PayType not found", false);
        } else {
            PayType payType = payTypeOptional.get();
            payType.setName(name);
            return new ApiResponse<PayType>("payType edited", true, payTypeRepository.save(payType));
        }
    }

    public ApiResponse<PayType> delete(Long id) {
        Optional<PayType> payTypeOptional = payTypeRepository.findById(id);
        if (payTypeOptional.isEmpty()) {
            return new ApiResponse<>("PayType not found", false);
        } else {
            PayType payType = payTypeOptional.get();
            payTypeRepository.delete(payType);
            return new ApiResponse<>("payType deleted", true);
        }
    }
}




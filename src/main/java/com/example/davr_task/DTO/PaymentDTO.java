package com.example.davr_task.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentDTO {
    private Long payTypeId;
    private String sum;
    private String description;
    private Long studentId;
    private Date createdDate;
}

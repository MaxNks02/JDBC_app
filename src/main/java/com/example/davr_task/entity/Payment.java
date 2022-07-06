package com.example.davr_task.entity;

import com.example.davr_task.entity.AbsEntity.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@ToString
@Table(name = "payment")
public class Payment extends Auditable<String> {

    private Long payTypeId;

    private String sum;

    private String description;


    private Long studentId;


    private Date createdDate;

}

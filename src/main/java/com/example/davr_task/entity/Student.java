package com.example.davr_task.entity;

import com.example.davr_task.entity.AbsEntity.Auditable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "student")
public class Student extends Auditable<String> {


    @Column(nullable = false)
    private String fullName;

    @Column(unique = true)
    private String phone;
}

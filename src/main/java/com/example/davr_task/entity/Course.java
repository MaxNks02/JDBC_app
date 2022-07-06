package com.example.davr_task.entity;

import com.example.davr_task.entity.AbsEntity.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;


@Getter
@Setter
@ToString
@Table(name = "course")
public class Course extends Auditable<String> {

    @Column(nullable = false)
    private String name;


    private String price;

    private String duration;


}

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
@Table(name = "room")
public class Room extends Auditable<String> {

    @Column(nullable = false)
    private String name;

    private Integer capacity;
}

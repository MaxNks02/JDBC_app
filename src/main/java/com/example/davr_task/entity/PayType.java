package com.example.davr_task.entity;

import com.example.davr_task.entity.AbsEntity.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;

@Getter
@Setter
@ToString
@Table(name = "pay_type")
public class PayType extends Auditable<String> {


    private String name;

}

package com.example.davr_task.entity;

import com.example.davr_task.entity.AbsEntity.Auditable;
import com.example.davr_task.security.entity.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Table(name = "group")
public class Group extends Auditable<String> {

    private String name;


    private Long courseId;


    private Long teacherId;


    private Long roomId;

    private List<Student> student;

    private Date startDate;

    private Date endDate;


    private Long statusId;


}

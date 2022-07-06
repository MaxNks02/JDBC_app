package com.example.davr_task.entity;


import com.example.davr_task.entity.AbsEntity.Auditable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Table(name = "time_table")
public class TimeTable extends Auditable<String> {


    private Long dayId;

    private Date startTime;

    private List<Group> groups;

    private Date endTime;


}

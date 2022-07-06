package com.example.davr_task.DTO;

import com.example.davr_task.entity.Group;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TimeTableDTO {
    private Long day_id;
    private Date startTime;
    private Date endTime;
    private List<Group> groups;
}

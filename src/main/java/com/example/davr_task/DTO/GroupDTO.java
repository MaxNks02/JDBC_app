package com.example.davr_task.DTO;

import com.example.davr_task.entity.Student;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GroupDTO {

    private String name;
    private Long courseId;
    private Long teacherId;
    private List<Student> students;
    private Long roomId;
    private Date startDate;
    private Date endDate;
    private Long StatusId;
}

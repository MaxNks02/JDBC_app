package com.example.davr_task.repository;

import com.example.davr_task.entity.TimeTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends CrudRepository<TimeTable, Long> {



}

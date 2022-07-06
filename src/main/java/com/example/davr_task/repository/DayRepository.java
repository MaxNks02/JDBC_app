package com.example.davr_task.repository;

import com.example.davr_task.entity.Day;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DayRepository extends CrudRepository<Day, Long> {
    @Query("select * from davr_task.public.day where name = :name")
    Optional<Day> findByName(@Param("name") String name);



}

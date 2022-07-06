package com.example.davr_task.repository;

import com.example.davr_task.entity.Course;
import com.example.davr_task.entity.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    @Query("select * from davr_task.public.course where name = :name")
    Optional<Course> findByName(@Param("name") String name);



}

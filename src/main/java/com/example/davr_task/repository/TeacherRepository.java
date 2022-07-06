package com.example.davr_task.repository;

import com.example.davr_task.entity.Student;
import com.example.davr_task.entity.Teacher;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;


@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    @Query("select * from davr_task.public.teacher where full_name = :full_name")
    Optional<Teacher> findByFullName(@Param("full_name") String fullName);

    @Query("select * from davr_task.public.teacher where phone = :phone")
    Optional<Teacher> findByPhone(@Param("phone") String phone);

}

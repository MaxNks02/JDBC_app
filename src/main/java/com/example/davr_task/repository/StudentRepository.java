package com.example.davr_task.repository;

import com.example.davr_task.entity.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository

public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("select t.*  from  davr_task.public.student t where t.full_name ilike :full_name limit 1")
    Optional<Student> findByFullName(@Param("full_name") String fullName);

    @Query("select *  from  davr_task.public.student")
    Optional<List<Student>> findAllStudent();

    @Query("select * from davr_task.public.student where phone = :phone")
    Optional<Student> findByPhone(@Param("phone") String phone);



}

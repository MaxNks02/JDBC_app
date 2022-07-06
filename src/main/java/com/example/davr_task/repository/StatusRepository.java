package com.example.davr_task.repository;

import com.example.davr_task.entity.PayType;
import com.example.davr_task.entity.Status;
import com.example.davr_task.entity.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {

    @Query("select * from davr_task.public.status where name = :name")
    Optional<Status> findByName(@Param("name") String name);


}

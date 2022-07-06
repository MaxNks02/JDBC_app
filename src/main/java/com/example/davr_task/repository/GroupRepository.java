package com.example.davr_task.repository;

import com.example.davr_task.entity.Group;
import com.example.davr_task.entity.Room;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    @Query("select * from davr_task.public.group where name = :name")
    Optional<Group> findByName(@Param("name") String name);

}

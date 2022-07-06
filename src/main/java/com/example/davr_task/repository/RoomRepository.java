package com.example.davr_task.repository;

import com.example.davr_task.entity.Room;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    @Query("select * from davr_task.public.room where name = :name")
    Optional<Room> findByName(@Param("name") String name);

}

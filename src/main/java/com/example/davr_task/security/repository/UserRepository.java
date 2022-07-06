package com.example.davr_task.security.repository;


import com.example.davr_task.security.entity.User;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select t.* from davr_task.public.user t  where t.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
    @Query("select t.*  from  davr_task.public.user t where t.full_name ilike :full_name limit 1")
    Optional<User> findByFullName(@Param("full_name") String fullName);
}

package com.example.davr_task.security.repository;

import com.example.davr_task.security.entity.Role;
import com.example.davr_task.security.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query("select t.* from davr_task.public.role t  where t.name = :name")
    Optional<Role> findByName(@Param("name") String name);
}

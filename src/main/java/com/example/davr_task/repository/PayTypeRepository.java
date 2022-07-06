package com.example.davr_task.repository;

import com.example.davr_task.entity.PayType;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PayTypeRepository extends CrudRepository<PayType, Long> {
    @Query("select * from davr_task.public.pay_type where name = :name")
    Optional<PayType> findByName(@Param("name") String name);



}

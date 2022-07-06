package com.example.davr_task.entity.AbsEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@MappedSuperclass
@Entity
public abstract class Auditable<U> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @CreatedBy
    private U createdBy;

    @CreatedDate
    private Date dateCreated;

    @LastModifiedDate
    private Date dateModified;

    @LastModifiedBy
    private U user;


}
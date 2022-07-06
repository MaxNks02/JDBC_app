package com.example.davr_task.repository;

import com.example.davr_task.entity.Student;
import net.minidev.json.JSONObject;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupStudentRepository {
    @Modifying
    @Query("insert into davr_task.public.group_student(group_id, student_id) values " +
            "(:group_id, :student_id)")
    void insertIntoGroupStudent(@Param("group_id") Long groupId, @Param("student_id")  Long studentId);

    @Query("select t.student_id from davr_task.public.group_student t where group_id = : group_id")
    Optional<List<Long>> studentListByGroupId(@Param("group_id") Long id);

    @Query("select t.group_id from davr_task.public.group_student t where  student_id=: group_id limit 1" )
    Optional<Long> groupIdByStudentId(@Param("student_id") Long id);

    @Query("delete  from davr_task.public.group_student where  student_id= :student_id returning student_id")
    Optional<Long> deleteStudentFromGroup(@Param("student_id") Long id);

    @Query("select t.student_id, t.group_id from davr_task.public.group_student t order by group_id")
    Optional<List<JSONObject>> listOfStudentsWithGroup();

    @Query("select t.student_id  from davr_task.public.group_student t where student_id=:id")
    Optional<Long> findByIdStudent(@Param("student_id") Long id);


}

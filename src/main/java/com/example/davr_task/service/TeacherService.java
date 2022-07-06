package com.example.davr_task.service;

import com.example.davr_task.DTO.TeacherDTO;
import com.example.davr_task.entity.Teacher;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private TeacherRepository teacherRepository;


    public ApiResponse<List<Teacher>> findAll() {
        List<Teacher> teachers =
                StreamSupport.stream(teacherRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<Teacher>>("List of Teacher", true, teachers);
    }

    public ApiResponse<Teacher> findByFullName(String fullName) {
        Optional<Teacher> Teacher = teacherRepository.findByFullName(fullName);
        if (Teacher.isEmpty()) {
            return new ApiResponse<Teacher>("Teacher's name not found", false);
        } else
            return new ApiResponse<Teacher>("Teacher ", true, Teacher.get());
    }


    public ApiResponse<Teacher> findById(Long id) {
        Optional<Teacher> Teacher = teacherRepository.findById(id);
        if (Teacher.isEmpty()) {
            return new ApiResponse<>("Teacher not found", false);
        } else
            return new ApiResponse<Teacher>("Teacher", true, Teacher.get());
    }

    public ApiResponse<Teacher> save(TeacherDTO dto) {
        Teacher teacher = new Teacher();
        if (!teacherRepository.findByPhone(dto.getPhone()).isEmpty()) {
            return new ApiResponse<>("phone number already exist", false);
        }
        teacher.setFullName(dto.getFullName());
        teacher.setPhone(dto.getPhone());
        teacher.setSalary(dto.getSalary());

        return new ApiResponse<Teacher>("Teacher saved", true, teacherRepository.save(teacher));
    }

    public ApiResponse<Teacher> edit(Long id, TeacherDTO dto) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isEmpty()) {
            return new ApiResponse<>("Teacher not found", false);
        } else {
            Teacher teacher = teacherOptional.get();
            teacher.setFullName(dto.getFullName());
            teacher.setPhone(dto.getPhone());
            teacher.setSalary(dto.getSalary());
            return new ApiResponse<Teacher>("Teacher edited", true, teacherRepository.save(teacher));
        }
    }

    public ApiResponse<Teacher> delete(Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isEmpty()) {
            return new ApiResponse<>("Teacher not found", false);
        } else {
            Teacher teacher = teacherOptional.get();
            teacherRepository.delete(teacher);
            return new ApiResponse<>("Teacher deleted", true);
        }
    }
}




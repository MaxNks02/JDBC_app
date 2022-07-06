package com.example.davr_task.service;

import com.example.davr_task.DTO.StudentDTO;
import com.example.davr_task.entity.Student;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;


    public ApiResponse<List<Student>> findAll() {
        List<Student> students =
                StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<Student>>("List of student", true, students);
    }

    public ApiResponse<List<Student>> findAllStudent() {
        Optional<List<Student>> students =studentRepository.findAllStudent();
        return new ApiResponse<List<Student>>("List of student", true, students.get());
    }


    public ApiResponse<Student> findByFullName(String fullName) {
        System.out.println(fullName);
        Optional<Student> student = studentRepository.findByFullName(fullName);
        if (student.isEmpty()) {
            return new ApiResponse<Student>("Student's name not found", false);
        } else
            return new ApiResponse<Student>("Student ",  true, student.get());
    }


    public ApiResponse<Student> findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            return new ApiResponse<>("Student not found", false);
        } else
            return new ApiResponse<Student>("Student",  true, student.get());
    }

    public ApiResponse<Student> save(StudentDTO dto){
        Student student = new Student();
        if (!studentRepository.findByPhone(dto.getPhone()).isEmpty()){
            return new ApiResponse<>("phone number already exist", false);
        }
        student.setFullName(dto.getFullName());
        student.setPhone(dto.getPhone());
        return new ApiResponse<Student>("student saved", true, studentRepository.save(student));
    }

    public ApiResponse<Student> edit(Long id, StudentDTO dto) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return new ApiResponse<>("Student not found", false);
        } else {
            Student student = studentOptional.get();
            student.setFullName(dto.getFullName());
            student.setPhone(dto.getPhone());
            return new ApiResponse<Student>("student edited", true, studentRepository.save(student));
        }
    }

    public ApiResponse<Student> delete(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()) {
            return new ApiResponse<>("Student not found", false);
        } else {
            Student student = studentOptional.get();
            studentRepository.delete(student);
            return new ApiResponse<>("student deleted", true);
        }
    }
}




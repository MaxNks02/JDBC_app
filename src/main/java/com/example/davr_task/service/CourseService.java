package com.example.davr_task.service;

import com.example.davr_task.DTO.CourseDTO;
import com.example.davr_task.entity.Course;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.CourseRepository;
import com.example.davr_task.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class CourseService {

    private CourseRepository courseRepository;


    public ApiResponse<List<Course>> findAll() {
        List<Course> courses =
                StreamSupport.stream(courseRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<Course>>("List of course", true, courses);
    }

    public ApiResponse<Course> findByName(String name) {
        Optional<Course> course = courseRepository.findByName(name);
        if (course.isEmpty()) {
            return new ApiResponse<Course>("Course's name not found", false);
        } else
            return new ApiResponse<Course>("Course ",  true, course.get());
    }


    public ApiResponse<Course> findById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty()) {
            return new ApiResponse<>("Course not found", false);
        } else
            return new ApiResponse<Course>("Course",  true, course.get());
    }

    public ApiResponse<Course> save(CourseDTO dto){
        Course course = new Course();

        course.setName(dto.getName());
        course.setDuration(dto.getDuration());
        course.setPrice(dto.getPrice());
        return new ApiResponse<Course>("course saved", true, courseRepository.save(course));
    }

    public ApiResponse<Course> edit(Long id, CourseDTO dto) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) {
           return  new ApiResponse<>("Course not found", false);
        } else {
            Course course = courseOptional.get();
            course.setName(dto.getName());
            course.setDuration(dto.getDuration());
            course.setPrice(dto.getPrice());
            return new ApiResponse<Course>("course edited", true, courseRepository.save(course));
        }
    }

    public  ApiResponse<Course> delete(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) {
            return  new ApiResponse<>("Course not found", false);
        } else {
            Course course = courseOptional.get();
            courseRepository.delete(course);
            return new ApiResponse<>("course deleted", true);
        }
    }
}




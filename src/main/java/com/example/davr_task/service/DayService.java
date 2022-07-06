package com.example.davr_task.service;

import com.example.davr_task.entity.Day;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class DayService {

    private DayRepository dayRepository;


    public ApiResponse<List<Day>> findAll() {
        List<Day> days =
                StreamSupport.stream(dayRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<Day>>("List of day", true, days);
    }

    public ApiResponse<Day> findByName(String Name) {
        Optional<Day> day = dayRepository.findByName(Name);
        if (day.isEmpty()) {
            return new ApiResponse<Day>("Day's name not found", false);
        } else
            return new ApiResponse<Day>("Day",  true, day.get());
    }


    public ApiResponse<Day> findById(Long id) {
        Optional<Day> day = dayRepository.findById(id);
        if (day.isEmpty()) {
            return new ApiResponse<>("Day not found", false);
        } else
            return new ApiResponse<Day>("Day",  true, day.get());
    }

    public ApiResponse<Day> save(String name){
        Day day = new Day();
        day.setName(name);
        return new ApiResponse<Day>("day saved", true, dayRepository.save(day));
    }

    public ApiResponse<Day> edit(Long id, String name) {
        Optional<Day> dayOptional = dayRepository.findById(id);
        if (dayOptional.isEmpty()) {
            return new ApiResponse<>("Day not found", false);
        } else {
            Day day = dayOptional.get();
            day.setName(name);
            return new ApiResponse<Day>("day edited", true, dayRepository.save(day));
        }
    }

    public ApiResponse<Day> delete(Long id) {
        Optional<Day> dayOptional = dayRepository.findById(id);
        if (dayOptional.isEmpty()) {
            return new ApiResponse<>("Day not found", false);
        } else {
            Day day = dayOptional.get();
            dayRepository.delete(day);
            return new ApiResponse<>("day deleted", true);
        }
    }
}




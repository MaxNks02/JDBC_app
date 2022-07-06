package com.example.davr_task.service;

import com.example.davr_task.DTO.TimeTableDTO;
import com.example.davr_task.entity.TimeTable;
import com.example.davr_task.playload.ApiResponse;
import com.example.davr_task.repository.CourseRepository;
import com.example.davr_task.repository.TimeTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class TimeTableService {

    private TimeTableRepository timeTableRepository;


    public ApiResponse<List<TimeTable>> findAll() {
        List<TimeTable> timeTables =
                StreamSupport.stream(timeTableRepository.findAll().spliterator(), false)
                        .collect(Collectors.toList());
        return new ApiResponse<List<TimeTable>>("List of timeTable", true, timeTables);
    }


    public ApiResponse<TimeTable> findById(Long id) {
        Optional<TimeTable> timeTable = timeTableRepository.findById(id);
        if (timeTable.isEmpty()) {
            return new ApiResponse<>("TimeTable not found", false);
        } else
            return new ApiResponse<TimeTable>("TimeTable", true, timeTable.get());
    }

    public ApiResponse<TimeTable> save(TimeTableDTO dto) {
        TimeTable timeTable = new TimeTable();

        timeTable.setDayId(dto.getDay_id());
        timeTable.setStartTime(dto.getStartTime());
        timeTable.setEndTime(dto.getEndTime());
        timeTable.setGroups(dto.getGroups());
        return new ApiResponse<TimeTable>("timeTable saved", true, timeTableRepository.save(timeTable));
    }

    public ApiResponse<TimeTable> edit(Long id, TimeTableDTO dto) {
        Optional<TimeTable> timeTableOptional = timeTableRepository.findById(id);
        if (timeTableOptional.isEmpty()) {
            return new ApiResponse<>("TimeTable not found", false);
        } else {
            TimeTable timeTable = timeTableOptional.get();
            timeTable.setDayId(dto.getDay_id());
            timeTable.setStartTime(dto.getStartTime());
            timeTable.setEndTime(dto.getEndTime());
            timeTable.setGroups(dto.getGroups());
            return new ApiResponse<TimeTable>("timeTable edited", true, timeTableRepository.save(timeTable));
        }
    }

    public ApiResponse<TimeTable> delete(Long id) {
        Optional<TimeTable> timeTableOptional = timeTableRepository.findById(id);
        if (timeTableOptional.isEmpty()) {
            return new ApiResponse<>("TimeTable not found", false);
        } else {
            TimeTable timeTable = timeTableOptional.get();
            timeTableRepository.delete(timeTable);
            return new ApiResponse<>("timeTable deleted", true);
        }
    }
}




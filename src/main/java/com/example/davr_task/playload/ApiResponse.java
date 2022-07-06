package com.example.davr_task.playload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    String name;

    Boolean success;

    private T object;

    public ApiResponse(String name, Boolean success) {
        this.name = name;
        this.success = success;
    }
}

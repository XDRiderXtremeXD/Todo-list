package com.projects.subTask.dtos;


import lombok.Data;

@Data
public class SubTaskCreate {
    
    private Long taskId; // la tarea a la que pertenece la subtask

    
    private String title;
}

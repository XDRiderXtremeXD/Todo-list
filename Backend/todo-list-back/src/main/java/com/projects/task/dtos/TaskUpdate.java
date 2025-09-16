package com.projects.task.dtos;

import java.time.LocalDate;

import com.projects.task.Task.Priority;
import com.projects.task.Task.Status;

import lombok.Data;

@Data
public class TaskUpdate {
	private String title;

    private String description;

    private Status status = Status.PENDING;

    private Priority priority = Priority.MEDIUM; 

    private LocalDate dueDate;
}

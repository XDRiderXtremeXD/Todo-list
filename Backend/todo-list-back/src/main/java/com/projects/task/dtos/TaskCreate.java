package com.projects.task.dtos;

import java.time.LocalDate;
import com.projects.task.Task.Priority;
import com.projects.task.Task.Status;

import lombok.Data;

@Data
public class TaskCreate {
	
	//private Long userId; no lo pongo pq en el backend se va a trabajar con él en base a su seguridad
	
	private String title;

    private String description;

    private Status status = Status.PENDING;

    private Priority priority = Priority.MEDIUM; 

    private LocalDate dueDate;
}

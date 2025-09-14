package com.projects.task;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.subTask.SubTaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	private final TaskRepository taskRepo;
	private final SubTaskRepository subTaskRepo;
	
	   public List<Task> getAllTasks() {
	        return taskRepo.findAll();
	    }

	    public Task getTaskById(Long id) {
	        return taskRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Task not found"));
	    }

	    public Task createTask(Task task) {
	        return taskRepo.save(task);
	    }

	    public void deleteTask(Long id) {
	        taskRepo.deleteById(id);
	    }
}

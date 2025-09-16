package com.projects.task;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.subTask.SubTaskRepository;
import com.projects.task.dtos.TaskCreate;
import com.projects.task.dtos.TaskUpdate;
import com.projects.user.User;
import com.projects.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	private final TaskRepository taskRepo;
	private final UserRepository userRepo;
	
	   public List<Task> getAllTasks() {
	        return taskRepo.findAll();
	    }

	    public Task getTaskById(Long id) {
	        return taskRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Task not found"));
	    }

	    public Task createTask(TaskCreate dto, Long lloggedUserId) {
	        User user = userRepo.findById(lloggedUserId) //id del usuario logeado, no viene del dto donde podria tener la libertad de escoger cualquier id
	        		.orElseThrow(()-> new RuntimeException("No se ha encontrado el id"));
	        
	        Task task = Task.builder()
	        		.user(user)
	        		.title(dto.getTitle())
	        		.description(dto.getDescription())
	        		.status(dto.getStatus())
	        		.priority(dto.getPriority())
	        		.dueDate(dto.getDueDate())
	        		.build();
	        		
	        return taskRepo.save(task);
	        
	    }
	    
	    public Task updateTask(Long taskId, TaskUpdate dto ) {
	    	Task task = taskRepo.findById(taskId)
	    			.orElseThrow(()-> new RuntimeException("El id no se ha encontrado"));
	    	
	    	if(dto.getTitle() != null) task.setTitle(dto.getTitle());
	    	if(dto.getDescription() != null) task.setDescription(dto.getDescription());
	    	if(dto.getStatus() != null) task.setStatus(dto.getStatus());
	    	if(dto.getPriority() != null) task.setPriority(dto.getPriority());
	    	if(dto.getDueDate() != null) task.setDueDate(dto.getDueDate());
	    	
	    	return taskRepo.save(task);
	    	
	    }

	    public void deleteTask(Long id) {
	        taskRepo.deleteById(id);
	    }
}

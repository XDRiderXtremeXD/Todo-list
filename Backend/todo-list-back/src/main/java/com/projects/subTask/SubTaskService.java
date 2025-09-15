package com.projects.subTask;

import com.projects.subTask.dtos.SubTaskCreate;
import com.projects.subTask.dtos.SubTaskUpdate;
import com.projects.task.Task;
import com.projects.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubTaskService {

    private final SubTaskRepository subTaskRepo;
    private final TaskRepository taskRepo;

    // Listar todas las subtasks
    public List<SubTask> getAllSubTasks() {
        return subTaskRepo.findAll();
    }

    // Buscar subtask por ID
    public SubTask getSubTaskById(Long id) {
        return subTaskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SubTask not found"));
    }

    // Crear una subtask
    public SubTask createSubTask(SubTaskCreate dto) {
        Task task = taskRepo.findById(dto.getTaskId())
                .orElseThrow(() -> new RuntimeException("Task not found"));

        SubTask subTask = SubTask.builder()
                .task(task)
                .title(dto.getTitle())
                .done(false) // siempre empieza en false
                .build();

        return subTaskRepo.save(subTask);
    }

    // Actualizar subtask
    public SubTask updateSubTask(Long id, SubTaskUpdate dto) {
        SubTask subTask = subTaskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("SubTask not found"));

        if (dto.getTitle() != null) subTask.setTitle(dto.getTitle());
        if (dto.getDone() != null) subTask.setDone(dto.getDone());

        return subTaskRepo.save(subTask);
    }

    // Eliminar subtask
    public void deleteSubTask(Long id) {
        subTaskRepo.deleteById(id);
    }
}

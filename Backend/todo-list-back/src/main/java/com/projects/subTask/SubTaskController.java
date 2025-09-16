package com.projects.subTask;

import com.projects.subTask.dtos.SubTaskCreate;
import com.projects.subTask.dtos.SubTaskUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subtasks")
@RequiredArgsConstructor
public class SubTaskController {

    private final SubTaskService subTaskService;

    // Obtener todas las subtasks
    @GetMapping
    public ResponseEntity<List<SubTask>> getAllSubTasks() {
        return ResponseEntity.ok(subTaskService.getAllSubTasks());
    }

    // Obtener una subtask por ID
    @GetMapping("/{id}")
    public ResponseEntity<SubTask> getSubTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(subTaskService.getSubTaskById(id));
    }

    // Crear nueva subtask
    @PostMapping
    public ResponseEntity<SubTask> createSubTask(@RequestBody SubTaskCreate dto) {
        return ResponseEntity.ok(subTaskService.createSubTask(dto));
    }

    // Actualizar subtask
    @PutMapping("/{id}")
    public ResponseEntity<SubTask> updateSubTask(
            @PathVariable Long id,
            @RequestBody SubTaskUpdate dto) {
        return ResponseEntity.ok(subTaskService.updateSubTask(id, dto));
    }

    // Eliminar subtask
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubTask(@PathVariable Long id) {
        subTaskService.deleteSubTask(id);
        return ResponseEntity.noContent().build();
    }
}

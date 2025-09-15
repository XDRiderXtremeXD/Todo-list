package com.projects.task;

import com.projects.task.dtos.TaskCreate;
import com.projects.task.dtos.TaskUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks") // todos los endpoints empiezan con /tasks
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // Obtener todas las tareas
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // Obtener una tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    // Crear nueva tarea (ejemplo usando un userId fijo simulado)
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskCreate dto) {
        Long loggedUserId = 1L; // 🔹 Simulación: aquí iría el usuario logeado
        return ResponseEntity.ok(taskService.createTask(dto, loggedUserId));
    }

    // Actualizar tarea
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody TaskUpdate dto) {
        return ResponseEntity.ok(taskService.updateTask(id, dto));
    }

    // Eliminar tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build(); // 204 vacío
    }
}

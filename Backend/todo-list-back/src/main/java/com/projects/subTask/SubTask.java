package com.projects.subTask;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import com.projects.task.Task;

import java.time.LocalDateTime;

@Entity
@Table(name = "subtasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private Boolean done = false;   // Valor por defecto FALSE

    @CreationTimestamp
    private LocalDateTime createdAt;
}

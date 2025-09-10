-- ========================
-- BASE DE DATOS: todo_list
-- ========================
CREATE DATABASE todo_list CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE todo_list;

-- ========================
-- TABLA DE USUARIOS
-- ========================
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ========================
-- TABLA DE TAREAS
-- ========================
CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status ENUM('PENDING','IN_PROGRESS','DONE') DEFAULT 'PENDING',
    priority ENUM('LOW','MEDIUM','HIGH') DEFAULT 'MEDIUM',
    due_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- ========================
-- TABLA DE SUBTAREAS (checklist dentro de una tarea)
-- ========================
CREATE TABLE subtasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    done BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (task_id) REFERENCES tasks(id) ON DELETE CASCADE
);

-- ========================
-- TABLA DE CATEGORÍAS (ej: Trabajo, Personal, Estudio)
-- ========================
CREATE TABLE categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- Relación muchos-a-muchos entre tareas y categorías
CREATE TABLE task_categories (
    task_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (task_id, category_id),
    FOREIGN KEY (task_id) REFERENCES tasks(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);

-- ========================
-- TABLA DE TAREAS COMPARTIDAS
-- ========================
CREATE TABLE shared_tasks (
    task_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    can_edit BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (task_id, user_id),
    FOREIGN KEY (task_id) REFERENCES tasks(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- ========================
-- TABLA DE HISTORIAL DE CAMBIOS (auditoría de tareas)
-- ========================
CREATE TABLE task_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    action VARCHAR(255) NOT NULL, -- "CREATED", "UPDATED", "STATUS_CHANGED", etc.
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (task_id) REFERENCES tasks(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

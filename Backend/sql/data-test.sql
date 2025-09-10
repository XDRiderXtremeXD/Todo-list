USE todo_list;
-- ========================
-- USUARIOS
-- ========================
INSERT INTO users (username, email, password_hash, role) VALUES
('angelo', 'angelo@mail.com', '1234', 'USER'),
('maria', 'maria@mail.com', '1234', 'USER'),
('admin', 'admin@mail.com', 'admin123', 'ADMIN');

-- ========================
-- CATEGORÍAS
-- ========================
INSERT INTO categories (name) VALUES
('Trabajo'),
('Personal'),
('Estudio');

-- ========================
-- TAREAS
-- ========================
INSERT INTO tasks (user_id, title, description, status, priority, due_date) VALUES
(1, 'Finalizar proyecto Spring', 'Avanzar el backend con JWT y seguridad', 'IN_PROGRESS', 'HIGH', '2025-09-20'),
(1, 'Hacer ejercicio', 'Ir al gimnasio 1 hora', 'PENDING', 'MEDIUM', '2025-09-12'),
(2, 'Preparar examen de matemáticas', 'Repasar capítulos 5 y 6', 'PENDING', 'HIGH', '2025-09-18'),
(2, 'Lista de compras', 'Comprar frutas y verduras', 'DONE', 'LOW', '2025-09-05');

-- ========================
-- SUBTAREAS
-- ========================
INSERT INTO subtasks (task_id, title, done) VALUES
(1, 'Configurar Spring Security', FALSE),
(1, 'Implementar JWT Filter', FALSE),
(1, 'Probar login con Angular', FALSE),
(2, 'Calentamiento 10 min', TRUE),
(2, 'Rutina de pesas', FALSE),
(3, 'Resolver ejercicios prácticos', FALSE);

-- ========================
-- TAREAS ↔ CATEGORÍAS
-- ========================
INSERT INTO task_categories (task_id, category_id) VALUES
(1, 1), -- tarea "Finalizar proyecto Spring" → Trabajo
(2, 2), -- tarea "Hacer ejercicio" → Personal
(3, 3), -- tarea "Preparar examen" → Estudio
(4, 2); -- tarea "Lista de compras" → Personal

-- ========================
-- TAREAS COMPARTIDAS
-- ========================
INSERT INTO shared_tasks (task_id, user_id, can_edit) VALUES
(1, 2, TRUE),  -- María puede editar la tarea de Angelo
(3, 1, FALSE); -- Angelo solo puede ver la tarea de María

-- ========================
-- HISTORIAL DE CAMBIOS
-- ========================
INSERT INTO task_history (task_id, user_id, action) VALUES
(1, 1, 'CREATED'),
(1, 1, 'STATUS_CHANGED to IN_PROGRESS'),
(2, 1, 'CREATED'),
(3, 2, 'CREATED'),
(4, 2, 'CREATED'),
(4, 2, 'STATUS_CHANGED to DONE');

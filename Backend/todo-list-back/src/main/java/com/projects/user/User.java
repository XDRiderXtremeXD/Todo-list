package com.projects.user;

import com.projects.task.Task;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class User {
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //LAZY (para no traer todas las tareas siempre que se cargue un User)
	private List<Task> tasks = new ArrayList<>();

}

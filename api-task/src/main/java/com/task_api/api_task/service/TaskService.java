package com.task_api.api_task.service;

import com.task_api.api_task.model.Task;
import com.task_api.api_task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> listar() {
        return repository.findAll();
    }

    public Task criar(Task task) {
        return repository.save(task);
    }

    public Task atualizar(Long id, Task task) {
        Task tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        tarefa.setNome(task.getNome());
        tarefa.setConcluida(task.isConcluida());

        return repository.save(tarefa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
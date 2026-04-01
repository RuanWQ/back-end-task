package com.task_api.api_task.controller;

import com.task_api.api_task.model.Task;
import com.task_api.api_task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> listar() {
        return service.listar();
    }

    @PostMapping
    public Task criar(@RequestBody Task task) {
        return service.criar(task);
    }

    @PutMapping("/{id}")
    public Task atualizar(@PathVariable Long id, @RequestBody Task task) {
        return service.atualizar(id, task);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
package mainPackage.controllers;

import mainPackage.entities.enums.Complexity;
import mainPackage.entities.Task;
import lombok.NonNull;
import mainPackage.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import static mainPackage.controllers.MainPageController.service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {
    @Autowired
    public TaskServiceImpl repo;
    @GetMapping("/tasks")
    public List<Task> list() {
        return service.findALl();
    }

    @PostMapping("/tasks")
    public int createTask(@RequestParam("name") @NonNull String name,
                          @RequestParam("complexity") @NonNull Complexity complexity) {
        Task task = new Task(name, complexity);
        return service.save(task);
    }

    @DeleteMapping("/tasks/")
    public void deleteTasks() {
        service.deleteAll();
    }
}

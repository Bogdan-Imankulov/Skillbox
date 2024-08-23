package MainPackage;

import Entities.Complexity;
import Entities.Task;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {

    @GetMapping("/tasks/")
    public List<Task> list() {
        return Storage.getMainStorage();
    }

    @PostMapping("/tasks/")
    public int createTask(@RequestParam("name") @NonNull String name,
                          @RequestParam("complexity") @NonNull Complexity complexity) {
        Task result = new Task(name, complexity);
        Storage.addTask(result);
        return result.getId();
    }

    @DeleteMapping("/tasks/")
    public List<Task> deleteTasks() {
        for (Task task : Storage.getMainStorage()) {
            Storage.removeTask(task.getId());
        }
        return Storage.getMainStorage();
    }
}

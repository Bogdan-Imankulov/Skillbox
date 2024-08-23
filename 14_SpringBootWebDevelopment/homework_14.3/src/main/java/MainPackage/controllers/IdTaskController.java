package mainPackage.controllers;

import mainPackage.entities.enums.Complexity;
import mainPackage.entities.Task;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import static mainPackage.controllers.MainPageController.service;
import javax.servlet.http.HttpServletResponse;

@RestController
public class IdTaskController {

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/tasks/{id}")
    public int post() {
        return HttpServletResponse.SC_METHOD_NOT_ALLOWED;
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable int id,
                       @RequestParam("name") @NonNull String name,
                       @RequestParam("complexity") @NonNull Complexity complexity){
        return service.update(id, name, complexity);
    }

    @DeleteMapping("/tasks/{id}")
    public int deleteTask(@PathVariable int id){
        return service.delete(id);
    }
}

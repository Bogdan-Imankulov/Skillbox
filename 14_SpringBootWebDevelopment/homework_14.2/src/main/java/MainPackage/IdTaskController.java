package MainPackage;

import Entities.Complexity;
import Entities.Task;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class IdTaskController {

    @GetMapping("/tasks/{id}")
    public Task list(@PathVariable int id) {
        return Storage.getTask(id);
    }

    @PostMapping("/tasks/{id}")
    public int post() {
        return HttpServletResponse.SC_METHOD_NOT_ALLOWED;
    }

    @PutMapping("/tasks/{id}")
    public void update(@PathVariable int id,
                       @RequestParam("name") @NonNull String name,
                       @RequestParam("complexity") @NonNull Complexity complexity){
        Storage.getTask(id).setName(name);
        Storage.getTask(id).setComplexity(complexity);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTask(@PathVariable int id){
        return Storage.removeTask(id);
    }
}

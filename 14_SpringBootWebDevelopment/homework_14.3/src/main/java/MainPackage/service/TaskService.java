package mainPackage.service;

import mainPackage.entities.Task;
import mainPackage.entities.enums.Complexity;

import java.util.List;

public interface TaskService {
    int save(Task task);
    List<Task> findALl();
    void deleteAll();
    Task findById(int taskId);
    int delete(int id);
    Task update(int id, String newName, Complexity newComplexity);
}

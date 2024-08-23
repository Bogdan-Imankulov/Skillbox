package mainPackage.service.impl;

import mainPackage.entities.Task;
import mainPackage.entities.enums.Complexity;
import mainPackage.repository.TaskRepository;
import mainPackage.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    @Transactional
    public int save(Task task){
        return repository.save(task).getId();
    }

    @Override
    public List<Task> findALl(){
       return (List<Task>) repository.findAll();
    }

    @Override
    @Transactional
    public void deleteAll(){
        repository.deleteAll();
    }

    @Override
    public Task findById(int taskId){
        return repository.findById(taskId).orElse(null);
    }

    @Override
    @Transactional
    public int delete(int id){
        Task toDelete = repository.findById(id).orElse(null);
        int result = -1;
        if (toDelete != null) {
            repository.delete(toDelete);
            result = toDelete.getId();
        }
        return result == -1 ? HttpServletResponse.SC_NOT_FOUND : toDelete.getId();
    }

    @Override
    public Task update(int id, String newName, Complexity newComplexity) {
        Task toUpdate = repository.findById(id).orElse(null);
        if (toUpdate != null) {
            toUpdate.setName(newName);
            toUpdate.setComplexity(newComplexity);
        }
        return toUpdate;
    }
}

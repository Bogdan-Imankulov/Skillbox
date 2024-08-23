package MainPackage;

import Entities.Task;

import java.util.HashMap;
import java.util.List;

public class Storage {
    private static final HashMap<Integer, Task> mainStorage = new HashMap<>();
    private static int newTaskId = 1;

    public static int addTask(Task taskToAdd) throws NullPointerException{
        int taskId = newTaskId++;
        taskToAdd.setId(taskId);
        mainStorage.put(taskId, taskToAdd);
        return taskId;
    }
    public static Task getTask(int taskId){
        return mainStorage.get(taskId);
    }
    public static Task removeTask(int taskId){
        return mainStorage.remove(taskId);
    }
    public static List<Task> getMainStorage() {
        return (List<Task>)mainStorage.values();
    }
}

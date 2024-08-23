package Entities;

import lombok.Data;

@Data
public class Task {
    private int id = 0;
    private String name;
    private Complexity complexity;

    public Task(String name, Complexity complexity) {
        this.name = name;
        this.complexity = complexity;
    }
}

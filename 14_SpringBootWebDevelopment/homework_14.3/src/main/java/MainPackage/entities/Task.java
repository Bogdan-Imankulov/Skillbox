package mainPackage.entities;

import lombok.Data;
import mainPackage.entities.enums.Complexity;

import javax.persistence.*;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "complexity")
    private Complexity complexity;

    public Task(String name, Complexity complexity) {
        this.name = name;
        this.complexity = complexity;
    }
    public Task(){}
}

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Teachers")
@Data
@AllArgsConstructor
public class Teacher extends CoreEntity implements Comparable<Teacher> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private int salary;

    @Column(name = "age")
    private int age;

    @Override
    public int compareTo(@NonNull Teacher otherTeacher) {
        return this.getId() - otherTeacher.getId();
    }
}

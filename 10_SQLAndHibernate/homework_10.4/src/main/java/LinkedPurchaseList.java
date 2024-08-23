import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class LinkedPurchaseList implements Serializable {

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;
}

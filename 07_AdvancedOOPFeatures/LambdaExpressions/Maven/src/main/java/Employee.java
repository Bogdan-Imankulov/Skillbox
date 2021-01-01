import lombok.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@ToString(exclude = "workStart")
@Data
@AllArgsConstructor
@With
@NoArgsConstructor
public class Employee
{
    private String name;
    private Integer salary;
    private Date workStart;
}

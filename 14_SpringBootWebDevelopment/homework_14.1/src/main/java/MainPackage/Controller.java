package MainPackage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class Controller {

    @RequestMapping("")
    public String index(){
        return "Today's date is " + LocalDate.now() + "; Current time is " + LocalTime.now();
    }

}

package kz.bitlab.techorda2025.thirdProject;

import org.springframework.stereotype.Controller;

@Controller("/addstudent")
public class Students {
    public String Students() {
        return "addstudent";
    }
}

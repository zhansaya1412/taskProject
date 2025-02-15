package kz.bitlab.bitlabspringsprinttask1.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model){
        model.addAttribute("myText", "guy's name");
        return "index";
    }


    @GetMapping("/addstudent")
    public String addStudentPage(){
        return "addstudent";
    }

    @PostMapping("/addstudent")
    public String addStudent(){

        //redirect back to student list:
        return "index";
    }
}

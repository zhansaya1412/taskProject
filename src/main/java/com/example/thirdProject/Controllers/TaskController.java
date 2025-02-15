package com.example.thirdProject.Controllers;

import com.example.thirdProject.db.TaskManager;
import com.example.thirdProject.db.Tasks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskController {
    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", TaskManager.getTaskList());
        return "tasks";
    }
    @GetMapping("/details/{idishka}")
    public String getTasks(Model model,
                           @PathVariable("idishka") Long id){
        model.addAttribute("task",TaskManager.getTask(id));
        return "details";
    }
}

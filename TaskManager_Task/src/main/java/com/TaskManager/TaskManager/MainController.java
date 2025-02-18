package com.TaskManager.TaskManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        List<Task> taskList = DBManager.getTaskList();
        model.addAttribute("taskList", taskList);

        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam("taskName") String name,
                        @RequestParam("taskDescription") String description,
                        @RequestParam("taskDeadlineDate") String date) {

        Task task = new Task();
        task.setName(name);
        task.setDeadlineDate(date);
        task.setDescription(description);
        task.setIsCompleted("NO");

        DBManager.addTask(task);

        return "redirect:/";

    }

    @GetMapping("/detail/{id}")
    public String detail( Model model, @PathVariable Long id) {

        Task task = DBManager.getTask(id);
        model.addAttribute("taskById", task);

        return "detail";
    }

    @PostMapping("/detail/{id}")
    public String updateOrDelete(@PathVariable Long id, @RequestParam("taskName") String name,
                                 @RequestParam("taskDescription") String description,
                                 @RequestParam("taskDeadlineDate") String deadlineDate,
                                 @RequestParam("action") String action,
                                 @RequestParam("taskCompleted") String completed
                                 ) {

        Task task = DBManager.getTask(id);
        if(action.equals("delete")) {
            DBManager.removeTask(id);
//            return "redirect:/";
        }else {
            task.setName(name);
            task.setDeadlineDate(deadlineDate);
            task.setDescription(description);
            task.setIsCompleted(completed);
            DBManager.updateTask(task);
        }
        return "redirect:/";
    }
}

package com.example.thirdProject.Controllers;

import com.example.thirdProject.db.TaskManager;
import com.example.thirdProject.db.Tasks;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
>>>>>>> 5f9dcbd (Added functions add,save,delete)

@Controller
public class TaskController {
    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", TaskManager.getTaskList());
        return "tasks";
    }
<<<<<<< HEAD
    @GetMapping("/details/{idishka}")
    public String getTasks(Model model,
                           @PathVariable("idishka") Long id){
        model.addAttribute("task",TaskManager.getTask(id));
        return "details";
    }
=======
    @GetMapping("/details/{idshka}")
    public String getDetailsOfTasks(Model model,
                           @PathVariable("idshka") Long id){
        model.addAttribute("task",TaskManager.getTask(id));
        return "details";
    }

    @GetMapping("/addTask")
    public String addTasks(Model model){
        model.addAttribute("task", new Tasks());
        return "addTask";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam(name ="taskName") String taskName,
                          @RequestParam(name="description")String description,
                          @RequestParam(name="date")String date,
                          @RequestParam(name="complete") String complete) {

        Tasks task = Tasks.builder()
                .name(taskName)
                .description(description)
                .deadlineDate(date)
                .isCompleted("true".equalsIgnoreCase(complete)) // safer boolean parsing
                .build();

        TaskManager.addTask(task);
        return "redirect:/tasks";
    }
    @PostMapping("/saveTask")
    public String saveTask(@RequestParam(name ="id") Long id,
                           @RequestParam(name ="taskName") String taskName,
                          @RequestParam(name="description")String description,
                          @RequestParam(name="date")String date,
                          @RequestParam(name="complete")String complete
    ){
        Tasks task = Tasks.builder()
                .id(id)
                .name(taskName)
                .description(description)
                .deadlineDate(date)
                .isCompleted(Boolean.parseBoolean(complete))
                .build();

        TaskManager.saveTask(task);
        return "redirect:/tasks";
    }
    @DeleteMapping(value = "/deleteTask")
    public String deleteTask(@RequestParam(name ="id") Long id){
        TaskManager.deleteTask(id);
        return "redirect:/tasks";
    }
>>>>>>> 5f9dcbd (Added functions add,save,delete)
}

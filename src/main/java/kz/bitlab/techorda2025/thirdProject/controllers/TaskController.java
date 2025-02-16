package kz.bitlab.techorda2025.thirdProject.controllers;

import kz.bitlab.techorda2025.thirdProject.db.Task;
import kz.bitlab.techorda2025.thirdProject.db.TaskManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", TaskManager.getTaskList());
        return "tasks";
    }
    @GetMapping("/details/{idshka}")
    public String getDetailsOfTask(Model model,
                           @PathVariable("idshka") Long id) {
        model.addAttribute("task", TaskManager.getTask(id));
        return "details";
    }

    @PostMapping("/saveTask")
    public String saveTask(   @RequestParam(name = "id") Long id,
                              @RequestParam(name = "taskName") String taskname,
                           @RequestParam(name = "description") String description,
                           @RequestParam(name = "date") String date,
                           @RequestParam(name = "complete") String complete) {

        Task task = Task.builder()
                .id(id)
                .name(taskname)
                .description(description)
                .deadlineDate(date)
                .isCompleted(Boolean.parseBoolean(complete))
                .build();

        TaskManager.saveTask(task);
        return "redirect:/tasks";
    }

    @DeleteMapping(value = "/deleteTask")
    public String deleteTask(@RequestParam(name = "id") Long id) {
        TaskManager.deleteTask(id);
        return "redirect:/tasks";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam(name = "taskName") String taskName,
                          @RequestParam(name= "taskDescription") String taskDescription,
                          @RequestParam(name = "date") String date,
                          @RequestParam(name = "complete", defaultValue = "false") String complete) {

        Task task = Task.builder()
                .name(taskName)
                .description(taskDescription)
                .deadlineDate(date)
                .isCompleted(Boolean.parseBoolean(complete))
                .build();

        TaskManager.addTask(task);
        return "redirect:/tasks";
    }


}

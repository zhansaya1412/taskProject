package kz.bitlab.techorda2025.thirdProject.controllers;

import kz.bitlab.techorda2025.thirdProject.beans.TestBean;
import kz.bitlab.techorda2025.thirdProject.db.Task;
import kz.bitlab.techorda2025.thirdProject.db.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

//    @Autowired
//    TestBean testBean;

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        System.out.println("tesBEan 3:" + new TestBean());
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

}

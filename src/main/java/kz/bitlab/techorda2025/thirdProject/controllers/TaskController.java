package kz.bitlab.techorda2025.thirdProject.controllers;

import kz.bitlab.techorda2025.thirdProject.db.Task;
import kz.bitlab.techorda2025.thirdProject.db.TaskManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @GetMapping("/tasks")
    public String getTasks(Model model){
        model.addAttribute("tasks", TaskManager.getTaskList());
        return "tasks";
    }

    @GetMapping("/details/{id}")
    public String getDetails(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("task", TaskManager.getTask(id));
        return "details";
    }

    @PostMapping("/saveTask")
    public String saveTask(
            @RequestParam(name = "taskId") Long  id,
            @RequestParam(name = "taskName") String name,
            @RequestParam(name = "taskDescription") String description,
            @RequestParam(name = "task_deadline") String deadline,
            @RequestParam(name = "task_status") String status
            )
    {
        Task task = TaskManager.getTask(id);
        task.setId(id);
        task.setName(name);
        task.setDescription(description);
        task.setDeadlineDate(deadline);
        task.setCompleted(Boolean.parseBoolean(status));

        return "redirect:/tasks";
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam(name = "taskId") Long id){
        TaskManager.deleteTask(id);

        return "redirect:/tasks";
    }
}
package kz.bitlab.techorda2025.thirdProject.controllers;

import jakarta.servlet.http.HttpSession;
import kz.bitlab.techorda2025.thirdProject.db.Task;
import kz.bitlab.techorda2025.thirdProject.db.TaskManager;
import kz.bitlab.techorda2025.thirdProject.db.Users;
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

    @PostMapping(value = "/addTask")
    public String addTask(@RequestParam(name = "taskName") String name,
                          @RequestParam(name = "description") String description,
                          @RequestParam(name = "date") String date) {

        Task task = Task.builder()
                .name(name)
                .description(description)
                .deadlineDate(date)
                .build();

        TaskManager.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping(value = "/logout")
    public String login(HttpSession session) {
        session.removeAttribute("currentUser");
        return "tasks";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password, HttpSession session) {

        Users user = TaskManager.getUser(email);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("currentUser", user);
        }
        return "redirect:/tasks";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(@RequestParam(name = "fullName") String fullName,
                           @RequestParam(name = "email") String email,
                           @RequestParam(name = "password") String password,
                           HttpSession session) {

        Users user = new Users();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(password);

        TaskManager.addUser(user);
        session.setAttribute("currentUser", user);
        return "redirect:/tasks";
    }

    @GetMapping(value = "/tasksCompleted")
    public String completedTasks(Model model) {
        model.addAttribute("tasks", TaskManager.getTaskList());
        return "completed";
    }

    @GetMapping(value = "/tasksNotCompleted")
    public String notCompletedTasks(Model model) {
        model.addAttribute("tasks", TaskManager.getTaskList());
        return "notCompleted";
    }
}

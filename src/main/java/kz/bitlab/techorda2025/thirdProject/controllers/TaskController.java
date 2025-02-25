package kz.bitlab.techorda2025.thirdProject.controllers;

import jakarta.servlet.http.HttpSession;
import kz.bitlab.techorda2025.thirdProject.db.Category;
import kz.bitlab.techorda2025.thirdProject.db.Task;
import kz.bitlab.techorda2025.thirdProject.db.Users;
import kz.bitlab.techorda2025.thirdProject.repositories.CategoryRepository;
import kz.bitlab.techorda2025.thirdProject.repositories.TaskRepository;
import kz.bitlab.techorda2025.thirdProject.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final UsersRepository usersRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping("/tasks")
    public String getTasks(@RequestParam(name = "regis", required = false) String regis, Model model) {
        model.addAttribute("regis", regis);

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        Users currentUser = (Users) session.getAttribute("currentUser");
        if (currentUser != null) {
            model.addAttribute("tasks", taskRepository.findAllByUser(currentUser));
        }
        return "tasks";
    }
    @GetMapping("/details/{idshka}")
    public String getDetailsOfTask(Model model,
                           @PathVariable("idshka") Long id) {
//        Task task = taskRepository.findById(id).orElse(null);
        Task task = new Task();
        if (taskRepository.findById(id).isPresent()) {
            task = taskRepository.findById(id).get();
        } else {
            task.setName("DEAFAULT");
            task.setCompleted(false);
            task.setDeadlineDate("");
            task.setId(id);
        }
        model.addAttribute("task", task);

        List<Category> taskCategories = task.getCategories();
        List<Category> allCategories = categoryRepository.findAll();
        allCategories.removeAll(taskCategories);

        model.addAttribute("categories",  allCategories);
        return "details";
    }

    @PostMapping("/saveTask")
    public String saveTask(   @RequestParam(name = "id") Long id,
                              @RequestParam(name = "taskName") String taskname,
                           @RequestParam(name = "date") String date,
                           @RequestParam(name = "complete") String complete) {

        Task task = Task.builder()
                .id(id)
                .name(taskname)
                .deadlineDate(date)
                .isCompleted(Boolean.parseBoolean(complete))
                .build();

        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @DeleteMapping(value = "/deleteTask")
    public String deleteTask(@RequestParam(name = "id") Long id) {
        taskRepository.deleteById(id);
        return "redirect:/tasks";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam(name = "taskName") String taskName,
                          @RequestParam(name = "date") String date,
                          @RequestParam(name = "complete", defaultValue = "false") String complete) {

        Task task = Task.builder()
                .name(taskName)
                .deadlineDate(date)
                .isCompleted(Boolean.parseBoolean(complete))
                .build();

        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam(name = "searchValue") String searchValue, Model model) {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession();
        Users currentUser = (Users) session.getAttribute("currentUser");

        List<Task> taskList = taskRepository.findAllByNameContainsIgnoreCaseAndUser(searchValue, currentUser);
        model.addAttribute("tasks", taskList);
        return "tasks";
    }

    @PostMapping(value = "/register")
    public String register(@RequestParam(name = "email") String email,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "fullName") String fullName, Model model) {

        Users users = new Users();
        users.setEmail(email);
        users.setPassword(password);
        users.setFullName(fullName);

        usersRepository.save(users);
        return "redirect:/tasks";
    }

    @PostMapping(value = "/login")
    public String register(@RequestParam(name = "email") String email,
                           @RequestParam(name = "password") String password, Model model) {
        Users currentUser = usersRepository.getUsersByEmail(email);
        String redirect = "";
        if (currentUser != null) {
            if (currentUser.getPassword().equals(password)) {
                ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
                HttpSession session = attr.getRequest().getSession();
                session.setAttribute("currentUser", currentUser);

                taskRepository.findAllByUser(currentUser);
                redirect = "redirect:/tasks";
            }
        } else {
            redirect = "redirect:/tasks?UserError";
        }

        return redirect;
    }

    @PostMapping(value = "/addCat")
    public String addCat(@RequestParam(name = "taskId") Long taskId,
                         @RequestParam(name = "catId") Long catId) {

        Category category = categoryRepository.findById(catId).orElse(null);
        Task task = taskRepository.findById(taskId).orElse(null);

        List<Category> taskCategories = task.getCategories();

        if(taskCategories == null && taskCategories.isEmpty()) {
            taskCategories = new ArrayList<>();
        }
        taskCategories.add(category);
        task.setCategories(taskCategories);

        taskRepository.save(task);
        return "redirect:/details/" + taskId;
    }

    @PostMapping(value = "/deleteCat")
    public String deleteCat(@RequestParam(name = "taskId") Long taskId,
                         @RequestParam(name = "catId") Long catId) {
        Category category = categoryRepository.findById(catId).orElse(null);
        Task task = taskRepository.findById(taskId).orElse(null);

        List<Category> taskCategories = task.getCategories();
        taskCategories.remove(category);
        task.setCategories(taskCategories);

        taskRepository.save(task);
        return "redirect:/details/" + taskId;
    }
}

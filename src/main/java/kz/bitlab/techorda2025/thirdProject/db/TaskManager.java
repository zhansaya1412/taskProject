package kz.bitlab.techorda2025.thirdProject.db;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private static Long id = 6L;
    @Getter
    public static List<Task> taskList = new ArrayList<>();

    static {
        taskList.add(new Task(1L, "Congratulate father", "Call to dad at midnight", "2025-02-25", false));
        taskList.add(new Task(2L, "Clean the room", "Do not be lazy!", "2025-03-08", false));
        taskList.add(new Task(3L, "To eat", "Make a dinner (desirable)", "2025-03-03", true));
        taskList.add(new Task(4L, "Understand git and github", "As soon as possible", "2025-03-04", false));
        taskList.add(new Task(5L, "To do assignment 3", "The deadline is in 2 hours!!!", "2025-03-03", false));
    }

    public static Task getTask(Long id){
        return taskList.stream().filter(task -> task.getId().equals(id)).findFirst().orElse(null);
    }

    public static void addTask(Task task){
        task.setId(id);
        taskList.add(task);
        id++;
    }

    public static void deleteTask(Long id) {
        taskList.remove(TaskManager.getTask(id));
    }
}
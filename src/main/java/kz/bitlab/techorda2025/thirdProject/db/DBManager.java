package kz.bitlab.techorda2025.thirdProject.db;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static List<Task> taskList = new ArrayList<>();
    private static Long id = 6L;

    static {
        taskList.add(new Task(1L, "Clean the House", "10.02.2025", "NO", "Ademilep tazala asykpai"));
        taskList.add(new Task(2L, "Wash the Car", "11.02.2025", "NO", "Ademilep tazala asykpai balondaryn tozhe"));
        taskList.add(new Task(3L, "Finish SpringBoot", "20.02.2025", "NO", "Durystap oky ademilep"));
        taskList.add(new Task(4L, "Finish the book", "14.02.2025", "YES", "Tusinip oky ademilep"));
        taskList.add(new Task(5L, "Go to friend's house", "9.02.2025", "NO", "Durys nietpen bar, aramy bolmai"));
    }

    public static List<Task> getTaskList() {
        return taskList;
    }

    public static void addTask(Task task) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate date = LocalDate.parse(task.getDeadlineDate(), inputFormatter);
        task.setDeadlineDate(date.format(outputFormatter));  // Convert to DD.MM.YYYY

        task.setId(id);
        taskList.add(task);
        id++;
    }

    public static void removeTask(Long id) {
        taskList.removeIf(task -> task.getId().equals(id));
    }

    public static Task getTask(Long id) {
        return taskList.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static void updateTask(Task updatedTask) {
        Task existingTask = getTask(updatedTask.getId());

        if (existingTask != null) {
            existingTask.setName(updatedTask.getName());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDeadlineDate(updatedTask.getDeadlineDate());
        }
    }
}

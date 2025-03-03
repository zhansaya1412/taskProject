package kz.bitlab.techorda2025.thirdProject.db;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private static Long id = 6L;
    @Getter
    public static List<Task> taskList = new ArrayList<>();

    static {
        taskList.add(new Task(1L, "Congratulate father", "2025-02-25", false));
        taskList.add(new Task(2L, "Clean the room", "2025-03-08", false));
        taskList.add(new Task(3L, "To eat", "2025-03-03", true));
        taskList.add(new Task(4L, "Understand git and github", "2025-03-04", false));
        taskList.add(new Task(5L, "To do assignment 3", "2025-03-03", false));
    }

}
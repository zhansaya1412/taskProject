package kz.bitlab.techorda2025.thirdProject.db;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private static List<Task> taskList = new ArrayList<>();
    private static Long id = 6L;

    static {
        taskList.add(new Task(1L, "Complete task5", "Lorem ipsum dolor...", "2025-02-16", false));

        taskList.add(new Task(2L, "Clean home", "Lorem ipsum dolor...", "2025-02-16", false));

        taskList.add(new Task(3L, "Buy a cake", "Lorem ipsum dolor...", "2025-02-15", true));

        taskList.add(new Task(4L, "Complete all home tasks", "Lorem ipsum dolor...", "2025-02-20", false));

        taskList.add(new Task(5L, "Create a new brach with your changes", "Lorem ipsum dolor...", "2025-02-18", false));
    }

    public static List<Task> getTaskList() {
        return taskList;
    }

    public static Task getTask(Long id) {
        return taskList.stream().filter(task -> task.getId()==id).findAny().orElse(null);
    }
    public static void addTask(Task task){
        task.setId(id);
        taskList.add(task);
        id++;
    }

    public static void saveTask(Task task){
        for (int i = 0; i < taskList.size(); i++) {
            if(taskList.get(i).getId() == task.getId()) {
                taskList.set(i, task);
            }
        }
    }

    public static void deleteTask(Long id) {
        taskList.remove(TaskManager.getTask(id));
    }


    private static List<Users> userList = new ArrayList<>();
    static {
        userList.add(new Users(1L, "user@gmail.com", "User Userov", "12345678"));
        userList.add(new Users(2L, "human@gmail.com", "Human Humanov", "87654321"));
    }

    public static Users getUser(String email) {
        return userList.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
    }

    private static Long idUser = 3L;
    public static void addUser(Users user) {
        user.setId(idUser);
        userList.add(user);
        idUser++;
    }
}

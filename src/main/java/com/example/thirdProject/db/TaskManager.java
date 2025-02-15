package com.example.thirdProject.db;

import org.springframework.scheduling.config.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private static List<Tasks> taskList = new ArrayList<>();
    private static  Long id=6L;

    static {
        taskList.add(new Tasks(1L,"Completed task 5 ","2025-02-16",false));
        taskList.add(new Tasks(2L,"Create task 14 ","2025-02-16",false));
        taskList.add(new Tasks(3L,"Completed task 30 ","2025-02-15",true));
        taskList.add(new Tasks(4L,"Change task 25 ","2025-02-16",false));
        taskList.add(new Tasks(5L,"Completed task 23 ","2025-02-16",false));

    }

    public static List<Tasks> getTaskList() {
        return taskList;
    }
    public static Tasks getTask(Long id){
        return taskList.stream().filter(task->task.getId()==id).findAny().orElse(null);
    }
}

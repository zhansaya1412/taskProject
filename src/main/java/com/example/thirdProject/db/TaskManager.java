package com.example.thirdProject.db;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private static List<Tasks> taskList = new ArrayList<>();
    private static  Long id=6L;

    static {
        taskList.add(new Tasks(1L, "Review completed task #5", "2025-02-16",
                "Ensure all aspects of task #5 are finalized and documented.", false));

        taskList.add(new Tasks(2L, "Create new task #14", "2025-02-16",
                "Draft and outline the steps needed for task #14 implementation.", false));

        taskList.add(new Tasks(3L, "Finalize and close task #30", "2025-02-15",
                "Double-check the completion of task #30 before archiving.", true));

        taskList.add(new Tasks(4L, "Modify task #25 details", "2025-02-16",
                "Update task #25 with the latest requirements and specifications.", false));

        taskList.add(new Tasks(5L, "Confirm completion of task #23", "2025-02-16",
                "Verify that task #23 meets all criteria before closing.", false));
    }


    public static List<Tasks> getTaskList() {
        return taskList;
    }
    public static Tasks getTask(Long id){
        return taskList.stream().filter(task->task.getId() == id).findAny().orElse(null);
    }
    public static void addTask(Tasks task){
        task.setId(id);
        taskList.add(task);
        id++;
    }
    public static void saveTask(Tasks task){
       for(int i=0;i<taskList.size();i++){
           if(taskList.get(i).getId() == task.getId()){
               taskList.set(i,task);
           }
       }
    }
    public static void deleteTask(Long id){
        taskList.remove(TaskManager.getTask(id));
    }
}

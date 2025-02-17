package com.example.thirdProject.db;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import lombok.*;
>>>>>>> 5f9dcbd (Added functions add,save,delete)

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tasks {
    private Long id;
    private String name;
    private String deadlineDate;
<<<<<<< HEAD
=======
    private String description;
>>>>>>> 5f9dcbd (Added functions add,save,delete)
    private boolean isCompleted;
}

package com.example.thirdProject.db;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tasks {
    private Long id;
    private String name;
    private String deadlineDate;
    private String description;
    private boolean isCompleted;
}

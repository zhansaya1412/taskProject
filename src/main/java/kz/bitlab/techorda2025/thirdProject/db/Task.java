package kz.bitlab.techorda2025.thirdProject.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "t_tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "task_name", nullable = false, length = 80)
    private String name;

    @Column(name = "deadline")
    private String deadlineDate;

    private boolean isCompleted;

    @ManyToOne
    private Users user;

    @ManyToMany
    private List<Category> categories;
}

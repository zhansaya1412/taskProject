package kz.bitlab.techorda2025.thirdProject.db;

public class Task {

    private Long id;
    private String name;
    private String deadlineDate;

    private String isCompleted;

    private String description;

    public Task() {

    }

    public Task(Long id, String name, String deadlineDate, String isCompleted, String description) {
        this.id = id;
        this.name = name;
        this.deadlineDate = deadlineDate;
        this.isCompleted = isCompleted;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }
}

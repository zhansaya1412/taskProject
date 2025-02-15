package kz.bitlab.bitlabspringsprinttask1.db;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;

    public Student(String name, String surname, int exam) {
        this.name = name;
        this.surname = surname;
        this.exam = exam;
    }
}

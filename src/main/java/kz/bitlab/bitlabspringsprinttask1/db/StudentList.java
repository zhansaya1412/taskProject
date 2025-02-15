package kz.bitlab.bitlabspringsprinttask1.db;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student){
        studentList.add(student);
    }
}

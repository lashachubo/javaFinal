package oop.finalexam.t2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<LearningCourse> learningCourses;

    public Student(String name) {
        this.name = name;
        this.learningCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<LearningCourse> getLearningCourses() {
        return learningCourses;
    }

    public void addCourse(LearningCourse course) {
        this.learningCourses.add(course);
    }
}

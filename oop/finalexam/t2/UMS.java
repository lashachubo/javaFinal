package oop.finalexam.t2;

import java.util.ArrayList;
import java.util.List;

public class UMS {
    private List<Student> students;

    public UMS() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void printStudentData(Student student) {
        System.out.println("Student Name: " + student.getName());
        System.out.println("Learning Courses:");
        for (LearningCourse course : student.getLearningCourses()) {
            System.out.println(" - " + course);
        }
        System.out.println();
    }

    public Student getMyStudentData() {
        Student lasha = new Student("Lasha Chubo");

        lasha.addCourse(new LearningCourse(
            "Computer Organization",
            "Itroduction To Programming",
            "Caching"
        ));
        lasha.addCourse(new LearningCourse(
            "Algorithms and Data Structures",
            "Introduction to C",
            "Algorithms, Binary Trees"
        ));
        lasha.addCourse(new LearningCourse(
            "Object Oriented Programming",
            "None",
            "Packages, Classes"
        ));
        lasha.addCourse(new LearningCourse(
            "Computer and Society",
            "None",
            "AI Impact, Privacy"
        ));

        return lasha;
    }


}

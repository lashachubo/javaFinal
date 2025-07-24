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



    public static void main(String[] args) {
        UMS ums = new UMS();

        Student lasha = ums.getMyStudentData();
        ums.addStudent(lasha);

        Student student2 = new Student("Lionel Messi");
        student2.addCourse(new LearningCourse("Calculus 101", "None", "Algebra"));
        student2.addCourse(new LearningCourse("Introduction to C", "None", "C, loops, lists"));
        student2.addCourse(new LearningCourse("Physics 101", "None", "Physics"));
        ums.addStudent(student2);

        for (Student s : ums.getStudents()) {
            ums.printStudentData(s);
        }
    }
}

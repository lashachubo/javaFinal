# University Management System (UMS) - Task #2

## Overview

This project implements a simple University Management System (UMS) that models students and their learning courses.

- Each **Student** has a name and a list of **LearningCourse** objects.
- Each **LearningCourse** contains:
  - Title
  - Acceptance Prerequisites
  - Major Topics
- The **UMS** class manages the students and provides a method to print student data along with their courses.

## Project Structure

oop/
└── finalexam/
└── t2/
├── UMS.java
├── Student.java
├── LearningCourse.java
└── README.md

### LearningCourse

- Fields: `title`, `acceptancePrerequisites`, `majorTopics` (all Strings)
- Getters and setters for each field
- Represents a course a student can learn

### Student

- Field: `name` (String)
- Field: `learningCourses` (List of LearningCourse)
- Methods to add courses and retrieve student data

### UMS (University Management System)

- Field: `students` (List of Student)
- Methods to add students and print student data
- Contains a method to return the student data for "Lasha Chubinidze" with predefined courses

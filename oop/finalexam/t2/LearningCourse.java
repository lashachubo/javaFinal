package oop.finalexam.t2;

public class LearningCourse {
    private String title;
    private String acceptancePrerequisites;
    private String majorTopics;

    public LearningCourse(String title, String acceptancePrerequisites, String majorTopics) {
        this.title = title;
        this.acceptancePrerequisites = acceptancePrerequisites;
        this.majorTopics = majorTopics;
    }

    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setAcceptancePrerequisites(String acceptancePrerequisites) {
        this.acceptancePrerequisites = acceptancePrerequisites;
    }

    public void setMajorTopics(String majorTopics) {
        this.majorTopics = majorTopics;
    }

    @Override
    public String toString() {
        return "Course Title: " + title + ", Prerequisites: " + acceptancePrerequisites + ", Major Topics: " + majorTopics;
    }
}

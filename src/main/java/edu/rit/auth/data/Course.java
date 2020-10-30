package edu.rit.auth.data;

import org.springframework.data.annotation.Id;

public class Course {
    @Id
    private String courseId;
    private String courseName;
    private String teacher;
    private String[] students;

    public Course() {

    }

    public String[] getStudents() {
        return students;
    }

    public void setStudents(String[] students) {
        this.students = students;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacherId(String teacher) {
        this.teacher = teacher;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

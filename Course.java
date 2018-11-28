package com.company;
//import com.sun.org.apache.xpath.internal.operations.String;

import java.io.Serializable;
import java.lang.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Vector;

public class Course implements Serializable{
    private String name, id;
    private Teacher teacher;
    HashSet<Student> students;
    HashSet<Course> prerequisites;
    HashSet<CourseFile> courseFiles;
    int creditsNumber;
    Faculty faculty;

    public Course(){}
    public Course(String name, String id, int creditNum){
        this.name = name;
        this.id = id;
        this.creditsNumber = creditNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        Driver.students.add(student);

    }

    public HashSet<Course> getPrerequisites() {
        return prerequisites;
    }

    public void addPrerequisite(Course c) {
        this.prerequisites.add(c);
    }

    public HashSet<CourseFile> getCourseFiles() {
        return courseFiles;
    }

    public void setCourseFiles(HashSet<CourseFile> courseFiles) {
        this.courseFiles = courseFiles;
    }

    public int getCreditsNumber() {
        return creditsNumber;
    }

    public void setCreditsNumber(int creditsNumber) {
        this.creditsNumber = creditsNumber;
    }

    public Faculty getFaculty(){
        return faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Course c = (Course) o;
        return (name.equals(c.name) && id.equals(c.id) && teacher.equals(c.teacher)
                && students.equals(c.students) && prerequisites.equals(c.prerequisites) && courseFiles.equals(c.courseFiles));
    }


    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", teacher=" + teacher +
                ", students=" + students +
                ", prerequisites=" + prerequisites +
                ", courseFiles=" + courseFiles +
                ", creditsNumber=" + creditsNumber +
                '}';
    }
}

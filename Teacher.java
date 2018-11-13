package com.company;

import java.util.HashSet;

public class Teacher {
    private Rank rank;
    private HashSet<Course> courses;

    public Teacher(Rank rank, HashSet<Course> courses) {
        this.rank = rank;
        this.courses = courses;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public HashSet<Course> getCourses() {
        return courses;
    }

    public void setCourses(HashSet<Course> courses){
        this.courses = courses;
    }

    public void putMark(Course c, Student s, Mark m){
        if(!courses.contains(c)) return;
        if(c.getStudents().contains(c)) return;
        s.
    }
}
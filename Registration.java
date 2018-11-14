package com.company;

import java.io.Serializable;
import java.util.HashSet;

public class Registration implements Serializable {
    private Student student;
    private Course course;
    private Type type;
    private HashSet<Registration> registrations = new HashSet<>();

    public Registration(){}
    public Registration(Student student, Course course, Type type){
        this.student = student;
        this.course = course;
        this.type = type.PENDING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registration that = (Registration) o;

        return (student.equals(that.student) && course.equals(that.course) && type == that.type);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "student=" + student +
                ", course=" + course +
                ", type=" + type +
                '}';
    }

    public void acceptRegistration() {
        /*student.getCourses().add(course);
        student.setTeacher(course, course.getTeacher());*/
        course.addStudent(student);
        course.getTeacher().addStudent(course, student);
        type = Type.ACCEPTED;
    }

    public void rejectRegitration() {
        type = Type.REJECTED;
    }

    public void addRegistration(Registration registration){
        registrations.add(registration);
    }
}
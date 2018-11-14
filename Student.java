package com.company;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Student extends Person implements Serializable, Comparable, Interactive {
    //working on it
    private double gpa;
    private Faculty faculty;
    private HashSet<Course> current = new HashSet<>();
    private HashSet<Course> passed = new HashSet<>();
    private HashMap<Course, Teacher> teachers = new HashMap<>();
    private Registration registration = new Registration();
    private HashMap<Course, Mark> marks = new HashMap<>();

    public Student(){}

    public Student(String login, String name, String id, String password, Double gpa, Faculty faculty){
        super(name, password, id, login);
        this.gpa = gpa;
        this.faculty = faculty;
    }

    public void registerForACourse(Course c){
        registration.addRegistration(new Registration(this, c, Type.PENDING));
    }

    public HashSet<Course> getCourses(){
        return current;
    }

    public HashSet<CourseFile> getCourseFile(Course c){
        return c.getCourseFiles();
    }
    public HashMap<Course, Mark> getMarks(){
        return marks;
    }

    public Mark getMark(Course c){
        if(!getMarks().containsKey(c)){
            marks.put(c, null);
        }
        return marks.get(c);
    }


    public void setMark(Mark m, Course c){
        if(!getMarks().containsKey(c)){
            marks.put(c, m);
        }
        marks.replace(c, m);
    }

    public String viewTeacher(Course c){
        Teacher t = c.getTeacher();
        return t + "\n";
    }

    public String viewCourses(){
        String s = "";
        for(Course c : current){
            s += c + "\n";
        }
        return s;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gpa, faculty, current, passed, teachers, registration, marks);
    }

    public void setTeacher(Course course, Teacher teacher){
        teachers.put(course, teacher);
    }

    public int getCreditsNum(){
        int cnt = 0;
        for(Course c : getCourses()){
            cnt+=c.getCreditsNumber();
        }
        return cnt;
    }

    public Faculty getFaculty(){
        return faculty;
    }

    public void setFaculty(Faculty faculty){
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        return (gpa == student.gpa && faculty == student.faculty && current.equals(student.current)
                && passed.equals(student.passed) && marks.equals(student.marks) && teachers.equals(student.teachers));
    }

    @Override
    public String toString() {
        return "Student{" +
                ", faculty=" + faculty +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;

        if(gpa > s.gpa) return 1;
        if(gpa == s.gpa) return 0;
        return -1;
    }

    @Override
    public void login() {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome Student!");
        System.out.println("Enter name: ");
        name = s.next();
        System.out.println("Enter password: ");
        password = s.next();
    }
    
}

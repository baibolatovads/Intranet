package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Teacher extends Employee implements Serializable {
    private Rank rank;
    private HashSet<Course> courses;
    private Teacher teacher;
    private Mode mode;
    private Mark mark;
    private Person person;
    private ArrayList<Course> curCourses;
    private static final Scanner sc = new Scanner(System.in);
    private Student student;
    private Mark mark;
    public Teacher(Rank rank, HashSet<Course> courses) {
        this.rank = rank;
        this.courses = courses;
    }

    public Teacher(String name, String login, String password){
        super(name, login, password);
    }
    public Teacher(String name, String login, String password, String id, Rank rank, HashSet<Course> courses) {
        super(name, login, password, id);
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
        s.setMark(m, c);
    }

    public void addCourseFile(CourseFile cf, Course c){
        c.getCourseFiles().add(cf);
    }

    public void deleteCourseFile(CourseFile cf, Course c){
        if(!courses.contains(c)) return;
        if(!c.getCourseFiles().contains(cf)) return;
        c.getCourseFiles().remove(cf);
    }

    public String viewStudents(){
        String s = "";
        for(Course c : courses){
            s += c + "\n---------------------------------\n";
            for(Student student : c.getStudents())
                s += student + "\n";
            s += "---------------------------------\n";
        }
        return s;
    }

    public String viewCourse(){
        String s = "";
        for(Course c : courses){
            s += c + "\n";
        }
        return s;
    }

    public void sendOrders(Order order){
        Executor.addOrder(order);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "rank=" + rank +
                ", courses=" + courses +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    public void session(){
        teacher = (Teacher) person;
        mode = Mode.Teacher;
        student = (Student) person;
        System.out.println("You are logged as a teacher");

        System.out.println("Choose option");
        System.out.println("1. View Students");
        System.out.println("2. View courses");
        System.out.println("3. Put mark");
        String ans = sc.nextLine();

        switch(ans){
            case "1":
                teacher.viewStudents();
                break;
            case "2":
                teacher.viewCourse();
                break;
            case "3":
                double fst = sc.nextDouble();
                double snd = sc.nextDouble();
                double finalE = sc.nextDouble();
                mark = new Mark(fst, snd, finalE);
                putMark(mark, );
        }
    }
}
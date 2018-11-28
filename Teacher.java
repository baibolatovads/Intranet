package com.company;

import java.io.Serializable;
import java.nio.charset.CoderMalfunctionError;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Teacher extends Employee implements Serializable, Interactive {
    private Rank rank;
    private HashSet<Course> courses;
    private static Scanner sc = new Scanner(System.in);

    private ArrayList<Course> curCourses;

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

    public void putMark(){
        System.out.print("Course (write ID): ");
        String id = sc.next();
        sc.nextLine();
        Course course = null;
        for (Course c : courses) {
            if (id == c.getId()) {
                course = c;
                break;
            }
        }
        if (course == null) {
            System.out.println("Such course doesn't exist!");
            return;
        }

        System.out.print("Student name: ");
        String sName = sc.nextLine();


        for(Course c : courses){
            for(Student s : c.getStudents()){
                if(s.getName() == sName){
                    System.out.print("Mark for 1st attestation: ");
                    double att1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Mark for 2nd attestation: ");
                    double att2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Mark for final exam: ");
                    double finalExam = sc.nextInt();
                    sc.nextLine();

                    Mark m = new Mark(att1, att2, finalExam);
                    s.setMark(m, c);
                    return;
                }
            }
        }
    }

    public void addCourseFile(){
        System.out.print("Course (write ID): ");
        String id = sc.next();
        sc.nextLine();
        Course course = null;
        for (Course c : courses) {
            if (id == c.getId()) {
                course = c;
                break;
            }
        }
        if (course == null) {
            System.out.println("Such course doesn't exist!");
            return;
        }

        System.out.print("Course file id (integer): ");
        int cfId = sc.nextInt();
        sc.nextLine();
        for(Course c : courses){
            for(CourseFile cf : c.courseFiles){
                if(cfId == cf.getId()){
                    System.out.println("Such course file ID already exists!");
                    return;
                }
            }
        }

        System.out.print("Course file title: ");
        String title = sc.nextLine();
        System.out.println("Course file description: ");
        String description = sc.nextLine();

        CourseFile cf = new CourseFile(title, description, cfId);
        course.getCourseFiles().add(cf);

        System.out.println("Course file was added successfully.");
    }

    public void deleteCourseFile(){
        System.out.println("Course file ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        for(Course c : courses){
            for(CourseFile cf : c.courseFiles){
                if(cf.getId() == id){
                    c.getCourseFiles().remove(cf);
                    System.out.println("Course file was deleted successfully.");
                    return;
                }
            }
        }
        System.out.println("Course file not found!");
    }

    public void viewStudents(){
        int i = 1;
        for(Course c : courses){
            System.out.println(i + ". " + c + "\n---------------------------------");
            int j = 1;
            for(Student student : c.getStudents())
                System.out.println(j + ") " + student + "\n");
            System.out.println("---------------------------------");
            i++;
        }
    }

    public void viewCourses(){
        int i = 1;
        for(Course c : courses){
            System.out.println(i + ") " + c);
            i++;
        }
    }

    public void sendOrder(){
        System.out.println("Message: ");
        String message = sc.nextLine();

        System.out.println("ID (int): ");
        int id = sc.nextInt();
        sc.nextLine();

        Executor.addOrder(new Order(this, message, id));
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
        System.out.println("What do you want to do, "
                + rank.name().toLowerCase() + " " + name + "?\n");

        while(true) {
            System.out.println("0) Log off");
            System.out.println("1) View courses");
            System.out.println("2) View students");
            System.out.println("3) Add a course file");
            System.out.println("4) Delete a course file");
            System.out.println("5) Put mark");
            System.out.println("6) Send order\n");

            Scanner sc = new Scanner(System.in);
            int cmd = sc.nextInt();
            sc.nextLine();

            if (cmd == 0) {
                break;
            }

            switch (cmd) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    addCourseFile();
                    break;
                case 4:
                    deleteCourseFile();
                    break;
                case 5:
                    putMark();
                    break;
                case 6:
                    sendOrder();
                    break;
                default:
                    System.out.println("Command index is out of range!");
            }
        }

    }
}
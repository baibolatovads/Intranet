package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Employee implements Comparable, Serializable, Interactive{
    Manager manager;
    Mode mode;
    Person person;
    private static final Scanner sc = new Scanner(System.in);
    public Manager()
    { }

    public Manager(String name, String login, String password){
        super(name, login, password);
    }
    public Manager(String name, String login, String password, String id, double salary) {
        super(name, login, password, id, salary);
    }
    static private ArrayList<Student> students = new ArrayList<>();
    static private ArrayList<Teacher> teachers = new ArrayList<>();
    static public ArrayList<Student> getAllStudents()
    {
        return students;
    }
    static public ArrayList<Teacher> getAllTeachers() { return teachers; }



    public String ViewInfoAboutStudents()
    {
        String s = "";
        ArrayList<Student> students = getAllStudents();
        for(int i = 0; i < students.size(); i++)
        {
            s += i+1 + " " + students.get(i).getName() + " " + students.get(i).getPassword() + "\n";
        }
        return s;
    }
    public String ViewInfoAboutTeachers()
    {
        String s = "";
        ArrayList<Teacher> teachers = getAllTeachers();
        for(int i = 0; i < teachers.size(); i++)
        {
            s += i+1 + " " + teachers.get(i).getName() + " " + teachers.get(i).getPassword() + "\n";
        }

        return s;
    }

    public void session(){
       manager = (Manager) person;
        mode = Mode.Manager;

        System.out.println("You are logged as a manager");

        System.out.println("Choose option");
        System.out.println("1. View info about teachers");
        System.out.println("2. View info about students");
        System.out.println("3. Add courses");

        String ans = sc.nextLine();

        switch(ans){
            case "1":
                System.out.println(manager.ViewInfoAboutTeachers());
                break;
            case "2":
                System.out.println(manager.ViewInfoAboutStudents());
                break;
            case "3":
                addCourseForRegistration();
                break;
        }
    }


    public void addCourseForRegistration(){
        System.out.println("Enter name of the course:");
        String name = sc.nextLine();
        System.out.println("Enter id of the course " + name);
        String id = sc.nextLine();
        System.out.println("Enter credits number of the course");
        Integer credNum = sc.nextInt();
        Course c = new Course(name, id, credNum);
        Driver.courses.add(c);
        Driver.saveCourses();
        System.out.println("Course is added successfully!");
    }
}


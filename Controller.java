package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private Mode mode;
    private Person person;
    private Student student;
    private Manager manager;
    private Executor executor;
    private Admin admin;
    private ArrayList<Course> curCourses;

    private static final Scanner sc = new Scanner(System.in);
    private static final String EXCEPT_CLASS = "Class not found!";
    private static final String EXCEPT_FILE = "File not found!";
    private static final String EXCEPT_IO = "Input / Output exception!";

    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    public static ArrayList<Manager> managers = new ArrayList<Manager>();
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<Executor> executors = new ArrayList<Executor>();

    public static ArrayList<Student> students = new ArrayList<Student>();

    public static ArrayList<Course> courses = new ArrayList<Course>();

    public void begin(){
        System.out.println("Welcome to Intranet!\nAre you enter as admin or user?");
        String answer = sc.nextLine().toLowerCase();
        if(!(answer.equals("user") || answer.equals("admin"))) return;
        System.out.println("Enter login and password:\n");
        String login = sc.nextLine().toLowerCase();
        String password = sc.nextLine();

        switch (answer){
            case "admin":
                sessionAdmin(login, password);
                break;
            case "user":
                sessionUser(login, password);
                break;
        }
    saveData();
    }

    private void sessionUser(String login, String password){
        ArrayList<Person> list = new ArrayList<>();
        boolean found = false;

        list.addAll(teachers);
        list.addAll(students);
        list.addAll(managers);
        list.addAll(executors);

        for(Person p: list){
            if(p.getLogin().equals(login) && p.getPassword().equals(password)){
                person = p;
                found = true;

                switch (p.getClass().toString().split(" ")[1]){
                    case "Student":
                        sessionStudent();
                        break;
                    case "Teacher":
                        sessionTeacher();
                        break;
                    case "Manager":
                        sessionManager();
                        break;
                    case "Executor":
                        sessionExecutor();
                        break;

                }
                break;
            }
        }
        if(!found){
            System.out.println("Invalid login or password!\n"); //exception place
        }
    }

    private void sessionStudent(){
        student = (Student)person;
        mode = Mode.Student;
        System.out.println("You are logged as student!");

        System.out.println("Choose the option you want");
        System.out.println("1. Courses");
        System.out.println("2. Transcript");
        System.out.println("3. Registration");
        System.out.println("4. Edit Info");

        String ans = sc.nextLine();
        switch (ans) {
            case "1":
                showCourses(Mode.STUDENT);
                break;
            case "2":
                studentTranscript();
                break;
            case "3":
                studentRegistration();
                break;
            case "4":
                studentInfo();
                break;
        }
    }
}

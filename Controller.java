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
}

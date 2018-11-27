package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Controller2 {
    private Person user = null;
    private HashSet<Person> users;
    private final String path = "src/com/company/files/";
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    public static ArrayList<Manager> managers = new ArrayList<Manager>();
    public static ArrayList<Executor> executors = new ArrayList<Executor>();

    public static ArrayList<Student> students = new ArrayList<Student>();

    public static ArrayList<Course> courses = new ArrayList<Course>();

    private void init(){
        try {
            input = new ObjectInputStream(new FileInputStream(path + "users.ser"));
            output = new ObjectOutputStream(new FileOutputStream(path + "users.ser"));

            users = (HashSet<Person>)input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        init();


        System.out.println("Welcome to Intranet!\n");

        System.out.print("Login: ");
        String login = sc.nextLine().toLowerCase();

        System.out.print("Password: ");
        String password = sc.nextLine();

        findUser(login, password);

        user.session();
    }

    private void findUser(String login, String password){
        for(Person u : users){
            if(u.login.equals(login)){
                user = u;
            }
        }
        if(user == null){
            throw LoginNotFoundException;
        }
        if(user.password != password){
            throw InvalidPasswordException;
        }
    }
}

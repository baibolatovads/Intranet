package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Controller {
    private static Person user = null;
    private static HashSet<Person> users = new HashSet<>();
    private static final String path = "src\\com\\company\\files\\";
    private static ObjectOutputStream output;
    private static ObjectInputStream input;

    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    public static ArrayList<Manager> managers = new ArrayList<Manager>();
    public static ArrayList<Executor> executors = new ArrayList<Executor>();

    public static ArrayList<Student> students = new ArrayList<Student>();

    public static ArrayList<Course> courses = new ArrayList<Course>();

    public static void initialSerialization(){
        Admin admin1 = new Admin("Abzal Myrzash", "1111", "17BD01", "a_myrzash", 500000);
        Admin admin2 = new Admin("Dariya Baibolatova", "2222", "17BD02", "d_baibolatova", 500000);
        Admin admin3 = new Admin("Shynar Ayanbek", "3333", "17BD03", "sh_ayanbek", 500000);

        Manager m = new Manager("Bob Bob", "mngr", "mngr", "b_bob", 300000);
        HashSet<Course> c = new HashSet<>();
        c.add(new Course("Calculus", "MATH1204", 4, Faculty.FIT));
        Teacher t = new Teacher("Fuad Gadzhiev", "f_gadzhiev", "tchr", "tchr", Rank.PROFESSOR, c);

        Student s1 = new Student("s_steve", "Steve Steve", "std1", "std1", 3.0, Faculty.BS);
        Student s2 = new Student("s_syroezhkin", "Sergei Syroezhkin", "std2", "std2", 4.0, Faculty.FIT);

        Executor ex = new Executor("Alex Alex", "exec", "exec", "a_alex", 200000);


        users.add(admin1);
        users.add(admin2);
        users.add(admin3);
        users.add(m);
        users.add(t);
        users.add(s1);
        users.add(s2);
        users.add(ex);

        try {
            output = new ObjectOutputStream(new FileOutputStream(path + "users.ser"));
            output.writeObject(users);
            output.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void init(){
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

    public static void run(){
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

    private static void findUser(String login, String password){
        for(Person u : users){
            if(u.login.equals(login)){
                user = u;
            }
        }
        if(user == null){
            System.out.println("User is not found");
        }
        if(user.password != password){
            System.out.println("Invalid Password");
        }
    }
}
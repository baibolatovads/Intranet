package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

import java.io.IOException;


public class Admin extends Employee implements Interactive {

    private Admin admin;
    private static final Scanner sc = new Scanner(System.in);

    private Person person;
    private static final String PATH = "src/com/company/files/";
    private static final String LOG = "log.txt";
    private static final String FILE = "admin.txt";
    private static final String EXCEPT_IO = "Input / Output exception!";

    public enum UserType {
        TEACHER, STUDENT, MANAGER;
    }

    public Admin(){
        getData();
    }


    public Admin(String name, String login, String password){
        super(name, login, password);
    }


    public Admin(String name, String login, String password, String id, double salary) {
        super(name, login, password, id, salary);
    }


    private static boolean isHaveDigits(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= '0' && text.charAt(i) <= '9')
                return true;
        }
        return false;
    }

    private static boolean isHaveSpace(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                return true;
        }
        return false;

    }

    static public char GetSymbolByType(UserType Type) {
        if (Type == UserType.TEACHER)
            return '.';
        else if (Type == UserType.STUDENT)
            return '_';
        else
            return '#';
    }

    public void addUser(String name, String newLogin, String password, Mode mode) {
        switch (mode) {
            case Student:
                addStudent(name, newLogin, password);
                break;
            case Teacher:
                System.out.println("Enter rank");
                Rank rank = Rank.valueOf(sc.next().toUpperCase());
                sc.nextLine();
                addTeacher(name, newLogin, password, rank);
                break;
            case Manager:
                addManager( name, newLogin, password);
                break;
            case Executor:
                addExecutor(name, newLogin, password);
                break;
        }
    }

    private void addExecutor(String name, String newLogin, String password) {
        Executor executor = new Executor(name, newLogin, password);

        if (!Driver.executors.contains(executor)) {
            Driver.executors.add(executor);
        }
        else {
            System.out.println(executor.getClass().toString().split(" ")[1] + " already exists!");
        }
    }

    private void addManager(String name, String newLogin, String password) {
        Manager manager = new Manager(name, newLogin, password);

        if (!Driver.managers.contains(manager)) {
            Driver.managers.add(manager);
        }
        else {
            System.out.println(manager.getClass().toString().split(" ")[1] + " already exists!");
        }
    }

    private void addTeacher( String name, String newLogin, String password, Rank rank) {
        Teacher teacher = new Teacher( name, newLogin, password, null, rank, new HashSet<Course>());

        if (!Driver.teachers.contains(teacher)) {
            Driver.teachers.add(teacher);
        }
        else {
            System.out.println(teacher.getClass().toString().split(" ")[1] + " already exists!");
        }
    }

    public void addStudent(String name, String newLogin, String password) {
        Student student = new Student( name, newLogin, password);

        if (!Driver.students.contains(student)) {
            Driver.students.add(student);
        }
        else {
            System.out.println(student.getClass().toString().split(" ")[1] + " already exists!");
        }
    }
   /* public void adminAdd() {
        while (true) {
            System.out.println("Whom you want to add?");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Manager");
            System.out.println("4. OR Manager");
            System.out.println("5. Executor");

            String ans = sc.nextLine();
            Mode mode;

            switch (ans) {
                case "1":
                    mode = Mode.Student;
                    break;
                case "2":
                    mode = Mode.Teacher;
                    break;
                case "3":
                    mode = Mode.Manager;
                    break;
                case "4":
                    mode = Mode.Executor;
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid option!");
                    continue;
            }

            System.out.println("Enter your name:");

            String name = sc.nextLine();

            System.out.println("Enter login");

            String login = sc.nextLine();

            System.out.println("Enter password");
            String password = sc.nextLine();

            admin.addUser(name, login, password, mode);
        }

    }*/

    public void adminRemove() {
        System.out.println("Enter user`s login you want to delete");

        String login = sc.nextLine();

        if (admin.deleteUser(login)) {
            System.out.println("Success!");
        }
        else {
            System.out.println("User not found!");
        }
    }

    public boolean deleteUser(String login) {
        for (Person u: Driver.students) {
            if (u.getLogin().equals(login)) {
                Driver.students.remove(u);

                return true;
            }
        }
        for (Person u: Driver.managers) {
            if (u.getLogin().equals(login)) {
                Driver.managers.remove(u);

                return true;
            }
        }

        for (Person u: Driver.executors) {
            if (u.getLogin().equals(login)) {
                Driver.executors.remove(u);

                return true;
            }
        }
        for (Person u: Driver.teachers) {
            if (u.getLogin().equals(login)) {
                Driver.teachers.remove(u);

                return true;
            }
        }

        return false;
    }

    public void adminLogs() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH + LOG));

            String line = br.readLine();

            while (line != null) {
                System.out.println(line);

                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(EXCEPT_IO);
        }
    }

    /*public void session() {
        admin = new Admin();
        if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
            String ans = "";
            System.out.println("Admin logged in");

            while (!ans.equals("exit")) {
                System.out.println("Choose the option!");
                System.out.println("1. Add new user");
                System.out.println("2. Delete user");
                System.out.println("3. Show log file");
                System.out.println("4. Exit");

                ans = sc.nextLine();

                switch (ans) {
                    case "1":
                        adminAdd();
                        break;
                    case "2":
                        adminRemove();
                        break;
                    case "3":
                        adminLogs();
                        break;
                    case "4":
                        return;
                    default:
                        System.out.println("Error!");
                        break;
                }
            }
        } else {
            System.out.println("Invalid login or password!");
        }
    }*/

    private void getData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH + FILE));

            String firstLine = br.readLine();
            String secondLine = br.readLine();

            String r_login, r_password;

            try {
                r_login = firstLine.split(" ")[1];
                r_password = secondLine.split(" ")[1];

                login = r_login;
                password = r_password;
            }
            catch (Exception e) {
                System.out.println("Wrong data in " + FILE);
            }

        }
        catch (IOException e) {
            System.out.println("Cannot read from " + FILE);
        }
    }
}

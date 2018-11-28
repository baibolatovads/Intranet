package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import java.io.IOException;


public class Admin extends Employee implements Interactive {

    private Admin admin;
    private static final Scanner sc = new Scanner(System.in);

<<<<<<< HEAD

    private final String PATH = "src/com/company/files/";
    private static final String LOG = "log.txt";
=======
    private Person person;
    private static final String PATH = "src/com/company/files/";
    private static final String LOG = "log.txt";
    private static final String FILE = "admin.txt";
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
    private static final String EXCEPT_IO = "Input / Output exception!";

    public enum UserType {
        TEACHER, STUDENT, MANAGER;
    }

    public Admin(){
        getData();
    }

<<<<<<< HEAD
    public Admin() {
    }

    public Admin(String name, String login){
        super(name, login);
    }


    public Admin(String name, String password, String id, String login, double salary) {
        super(name, password, id, login, salary);
=======

    public Admin(String name, String login, String password){
        super(name, login, password);
    }


    public Admin(String name, String login, String password, String id, double salary) {
        super(name, login, password, id, salary);
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
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

    public static boolean ValidLogin(String login) {
        if (!(login.contains("_") || login.contains("#") || login.contains(".")))
            return false;
        if (isHaveSpace(login))
            return false;
        if (isHaveDigits(login))
            return false;
        return true;
    }

    public static boolean ValidName(String name) {
        if (isHaveDigits(name))
            return false;
        if (isHaveSpace(name))
            return false;
        return true;
    }

    static public char GetSymbolByType(UserType Type) {
        if (Type == UserType.TEACHER)
            return '.';
        else if (Type == UserType.STUDENT)
            return '_';
        else
            return '#';
    }

<<<<<<< HEAD
    public void addUser(String name, String newLogin, Mode mode) {
        switch (mode) {
            case Student:
                addStudent(name, newLogin);
                break;
            case Teacher:
                addTeacher(name, newLogin);
                break;
            case Manager:
                addManager( name, newLogin);
                break;
            case Executor:
                addExecutor(name, newLogin);
=======
    public void addUser(String name, String newLogin, String password, Mode mode) {
        switch (mode) {
            case Student:
                addStudent(name, newLogin, password);
                break;
            case Teacher:
                addTeacher(name, newLogin, password);
                break;
            case Manager:
                addManager( name, newLogin, password);
                break;
            case Executor:
                addExecutor(name, newLogin, password);
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
                break;
        }
    }

<<<<<<< HEAD
    private void addExecutor(String name, String newLogin) {
        Executor executor = new Executor(name, newLogin);

        if (!Controller.executors.contains(executor)) {
            Controller.executors.add(executor);
=======
    private void addExecutor(String name, String newLogin, String password) {
        Executor executor = new Executor(name, newLogin, password);

        if (!Driver.executors.contains(executor)) {
            Driver.executors.add(executor);
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
        }
        else {
            System.out.println(executor.getClass().toString().split(" ")[1] + " already exists!");
        }
    }

<<<<<<< HEAD
    private void addManager(String name, String newLogin) {
        Manager manager = new Manager(name, newLogin);

        if (!Controller.managers.contains(manager)) {
            Controller.managers.add(manager);
=======
    private void addManager(String name, String newLogin, String password) {
        Manager manager = new Manager(name, newLogin, password);

        if (!Driver.managers.contains(manager)) {
            Driver.managers.add(manager);
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
        }
        else {
            System.out.println(manager.getClass().toString().split(" ")[1] + " already exists!");
        }
    }

<<<<<<< HEAD
    private void addTeacher( String name, String newLogin) {
        Teacher teacher = new Teacher( name, newLogin);

        if (!Controller.teachers.contains(teacher)) {
            Controller.teachers.add(teacher);
=======
    private void addTeacher( String name, String newLogin, String password) {
        Teacher teacher = new Teacher( name, newLogin, password);

        if (!Driver.teachers.contains(teacher)) {
            Driver.teachers.add(teacher);
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
        }
        else {
            System.out.println(teacher.getClass().toString().split(" ")[1] + " already exists!");
        }
    }

<<<<<<< HEAD
    private void addStudent(String name, String newLogin) {
        Student student = new Student( name, newLogin);

        if (!Controller.students.contains(student)) {
            Controller.students.add(student);
=======
    public void addStudent(String name, String newLogin, String password) {
        Student student = new Student( name, newLogin, password);

        if (!Driver.students.contains(student)) {
            Driver.students.add(student);
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
        }
        else {
            System.out.println(student.getClass().toString().split(" ")[1] + " already exists!");
        }
    }
<<<<<<< HEAD
    private void adminAdd() {
=======
   /* public void adminAdd() {
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
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

<<<<<<< HEAD
            admin.addUser(name, login, mode);
        }

    }

    private void adminRemove() {
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
        for (Person u: Controller.students) {
            if (u.getLogin().equals(login)) {
                Controller.students.remove(u);

                return true;
            }
        }
        for (Person u: Controller.managers) {
            if (u.getLogin().equals(login)) {
                Controller.managers.remove(u);

                return true;
            }
        }

        for (Person u: Controller.executors) {
            if (u.getLogin().equals(login)) {
                Controller.executors.remove(u);

                return true;
            }
        }
        for (Person u: Controller.teachers) {
            if (u.getLogin().equals(login)) {
                Controller.teachers.remove(u);

                return true;
            }
        }

        return false;
    }

    private void adminLogs() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH + LOG));

            String line = br.readLine();

=======
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

>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
            while (line != null) {
                System.out.println(line);

                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println(EXCEPT_IO);
        }
    }

<<<<<<< HEAD
    public void session() {
=======
    /*public void session() {
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
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
<<<<<<< HEAD
=======
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
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
    }
}
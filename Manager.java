package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Manager extends Employee implements Comparable, Serializable, Interactive{
    public Manager()
    { }

<<<<<<< HEAD
    public Manager(String name, String login){
        super(name, login);
    }
    public Manager(String name, String password, String id, String login, double salary)
    {
        super(name,password,id, login,salary);
=======
    public Manager(String name, String login, String password){
        super(name, login, password);
    }
    public Manager(String name, String login, String password, String id, double salary) {
        super(name, login, password, id, salary);
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
    }
    static private ArrayList<Student> students;
    static private ArrayList<Teacher> teachers;
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

<<<<<<< HEAD
    public void session(){}
=======
    public void session(){

    }
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684

}
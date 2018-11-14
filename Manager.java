package com.company;

import java.util.ArrayList;

public abstract class Manager extends Employee{
    public Manager()
    { }
    public Manager(String name, String password, String login, double salary)
    {
        super(name,password,login,salary);
    }
    static private ArrayList<Student> students;
    static private ArrayList<Teacher> teachers;
    static public ArrayList<Student> getAllStudents()
    {
        return students;
    }
    static public ArrayList<Teacher> getAllTeachers() { return teachers; }



    public void ViewInfoAboutStudents()
    {
        ArrayList<Student> students = getAllStudents();
        for(int i = 0; i < students.size(); i++)
        {
            System.out.println(i+1 + " " + students.get(i).getName() + " " + students.get(i).getPassword());
        }
    }
    public void ViewInfoAboutTeachers()
    {
        ArrayList<Teacher> teachers = getAllTeachers();
        for(int i = 0; i < teachers.size(); i++)
        {
            System.out.println(i+1 + " " + teachers.get(i).getName() + " " + teachers.get(i).getPassword());
        }

    }

}